package com.proj.project.system.dept.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proj.common.constant.UserConstants;
import com.proj.common.exception.BusinessException;
import com.proj.common.utils.StringUtils;
import com.proj.common.utils.security.ShiroUtils;
import com.proj.framework.aspectj.lang.annotation.DataScope;
import com.proj.framework.web.domain.Ztree;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.mapper.DeptMapper;
import com.proj.project.system.role.domain.Role;

/**
 * 院系管理 服务实现
 * 
 * @author admin
 */
@Service
public class DeptServiceImpl implements IDeptService
{
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询院系管理数据
     * 
     * @param dept 院系信息
     * @return 院系信息集合
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Dept> selectDeptList(Dept dept)
    {
        return deptMapper.selectDeptList(dept);
    }

    /**
     * 查询院系管理树
     * 
     * @param dept 院系信息
     * @return 所有院系信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectDeptTree(Dept dept)
    {
        List<Dept> deptList = deptMapper.selectDeptList(dept);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    /**
     * 查询院系管理树（排除下级）
     * 
     * @param deptId 院系ID
     * @return 所有院系信息
     */
    @Override
    @DataScope(deptAlias = "d")
    public List<Ztree> selectDeptTreeExcludeChild(Dept dept)
    {
        Long deptId = dept.getDeptId();
        List<Dept> deptList = deptMapper.selectDeptList(dept);
        Iterator<Dept> it = deptList.iterator();
        while (it.hasNext())
        {
            Dept d = (Dept) it.next();
            if (d.getDeptId().intValue() == deptId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), deptId + ""))
            {
                it.remove();
            }
        }
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    /**
     * 根据角色ID查询院系（数据权限）
     *
     * @param role 角色对象
     * @return 院系列表（数据权限）
     */
    @Override
    public List<Ztree> roleDeptTreeData(Role role)
    {
        Long roleId = role.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<Dept> deptList = selectDeptList(new Dept());
        if (StringUtils.isNotNull(roleId))
        {
            List<String> roleDeptList = deptMapper.selectRoleDeptTree(roleId);
            ztrees = initZtree(deptList, roleDeptList);
        }
        else
        {
            ztrees = initZtree(deptList);
        }
        return ztrees;
    }

    /**
     * 对象转院系树
     *
     * @param deptList 院系列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList)
    {
        return initZtree(deptList, null);
    }

    /**
     * 对象转院系树
     *
     * @param deptList 院系列表
     * @param roleDeptList 角色已存在菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList, List<String> roleDeptList)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleDeptList);
        for (Dept dept : deptList)
        {
            if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(dept.getDeptId());
                ztree.setpId(dept.getParentId());
                ztree.setName(dept.getDeptName());
                ztree.setTitle(dept.getDeptName());
                if (isCheck)
                {
                    ztree.setChecked(roleDeptList.contains(dept.getDeptId() + dept.getDeptName()));
                }
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }

    /**
     * 查询院系人数
     * 
     * @param parentId 院系ID
     * @return 结果
     */
    @Override
    public int selectDeptCount(Long parentId)
    {
        Dept dept = new Dept();
        dept.setParentId(parentId);
        return deptMapper.selectDeptCount(dept);
    }

    /**
     * 查询院系是否存在用户
     * 
     * @param deptId 院系ID
     * @return 结果 true 存在 false 不存在
     */
    @Override
    public boolean checkDeptExistUser(Long deptId)
    {
        int result = deptMapper.checkDeptExistUser(deptId);
        return result > 0 ? true : false;
    }

    /**
     * 删除院系管理信息
     * 
     * @param deptId 院系ID
     * @return 结果
     */
    @Override
    public int deleteDeptById(Long deptId)
    {
        return deptMapper.deleteDeptById(deptId);
    }

    /**
     * 新增保存院系信息
     * 
     * @param dept 院系信息
     * @return 结果
     */
    @Override
    public int insertDept(Dept dept)
    {
        Dept info = deptMapper.selectDeptById(dept.getParentId());
        // 如果父节点不为"正常"状态,则不允许新增子节点
        if (!UserConstants.DEPT_NORMAL.equals(info.getStatus()))
        {
            throw new BusinessException("院系停用，不允许新增");
        }
        dept.setCreateBy(ShiroUtils.getLoginName());
        dept.setAncestors(info.getAncestors() + "," + dept.getParentId());
        return deptMapper.insertDept(dept);
    }

    /**
     * 修改保存院系信息
     * 
     * @param dept 院系信息
     * @return 结果
     */
    @Override
    @Transactional
    public int updateDept(Dept dept)
    {
        Dept newParentDept = deptMapper.selectDeptById(dept.getParentId());
        Dept oldDept = selectDeptById(dept.getDeptId());
        if (StringUtils.isNotNull(newParentDept) && StringUtils.isNotNull(oldDept))
        {
            String newAncestors = newParentDept.getAncestors() + "," + newParentDept.getDeptId();
            String oldAncestors = oldDept.getAncestors();
            dept.setAncestors(newAncestors);
            updateDeptChildren(dept.getDeptId(), newAncestors, oldAncestors);
        }
        dept.setUpdateBy(ShiroUtils.getLoginName());
        int result = deptMapper.updateDept(dept);
        if (UserConstants.DEPT_NORMAL.equals(dept.getStatus()))
        {
            // 如果该院系是启用状态，则启用该院系的所有上级院系
            updateParentDeptStatus(dept);
        }
        return result;
    }

    /**
     * 修改该院系的父级院系状态
     * 
     * @param dept 当前院系
     */
    private void updateParentDeptStatus(Dept dept)
    {
        String updateBy = dept.getUpdateBy();
        dept = deptMapper.selectDeptById(dept.getDeptId());
        dept.setUpdateBy(updateBy);
        deptMapper.updateDeptStatus(dept);
    }

    /**
     * 修改子元素关系
     * 
     * @param deptId 被修改的院系ID
     * @param newAncestors 新的父ID集合
     * @param oldAncestors 旧的父ID集合
     */
    public void updateDeptChildren(Long deptId, String newAncestors, String oldAncestors)
    {
        List<Dept> children = deptMapper.selectChildrenDeptById(deptId);
        for (Dept child : children)
        {
            child.setAncestors(child.getAncestors().replace(oldAncestors, newAncestors));
        }
        if (children.size() > 0)
        {
            deptMapper.updateDeptChildren(children);
        }
    }

    /**
     * 修改子元素关系
     * 
     * @param deptId 院系ID
     * @param ancestors 元素列表
     */
    public void updateDeptChildren(Long deptId, String ancestors)
    {
        Dept dept = new Dept();
        dept.setParentId(deptId);
        List<Dept> childrens = deptMapper.selectDeptList(dept);
        for (Dept children : childrens)
        {
            children.setAncestors(ancestors + "," + dept.getParentId());
        }
        if (childrens.size() > 0)
        {
            deptMapper.updateDeptChildren(childrens);
        }
    }

    /**
     * 根据院系ID查询信息
     * 
     * @param deptId 院系ID
     * @return 院系信息
     */
    @Override
    public Dept selectDeptById(Long deptId)
    {
        return deptMapper.selectDeptById(deptId);
    }

    /**
     * 根据ID查询所有子院系（正常状态）
     * 
     * @param deptId 院系ID
     * @return 子院系数
     */
    @Override
    public int selectNormalChildrenDeptById(Long deptId)
    {
        return deptMapper.selectNormalChildrenDeptById(deptId);
    }

    /**
     * 校验院系名称是否唯一
     * 
     * @param dept 院系信息
     * @return 结果
     */
    @Override
    public String checkDeptNameUnique(Dept dept)
    {
        Long deptId = StringUtils.isNull(dept.getDeptId()) ? -1L : dept.getDeptId();
        Dept info = deptMapper.checkDeptNameUnique(dept.getDeptName(), dept.getParentId());
        if (StringUtils.isNotNull(info) && info.getDeptId().longValue() != deptId.longValue())
        {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;
    }
}
