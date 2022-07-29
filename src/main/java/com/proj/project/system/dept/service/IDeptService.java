package com.proj.project.system.dept.service;

import java.util.List;
import com.proj.framework.web.domain.Ztree;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.role.domain.Role;

/**
 * 院系管理 服务层
 * 
 * @author admin
 */
public interface IDeptService
{
    /**
     * 查询院系管理数据
     * 
     * @param dept 院系信息
     * @return 院系信息集合
     */
    public List<Dept> selectDeptList(Dept dept);

    /**
     * 查询院系管理树
     * 
     * @param dept 院系信息
     * @return 所有院系信息
     */
    public List<Ztree> selectDeptTree(Dept dept);

    /**
     * 查询院系管理树（排除下级）
     * 
     * @param dept 院系信息
     * @return 所有院系信息
     */
    public List<Ztree> selectDeptTreeExcludeChild(Dept dept);

    /**
     * 根据角色ID查询菜单
     *
     * @param role 角色对象
     * @return 菜单列表
     */
    public List<Ztree> roleDeptTreeData(Role role);

    /**
     * 查询院系人数
     * 
     * @param parentId 父院系ID
     * @return 结果
     */
    public int selectDeptCount(Long parentId);

    /**
     * 查询院系是否存在用户
     * 
     * @param deptId 院系ID
     * @return 结果 true 存在 false 不存在
     */
    public boolean checkDeptExistUser(Long deptId);

    /**
     * 删除院系管理信息
     * 
     * @param deptId 院系ID
     * @return 结果
     */
    public int deleteDeptById(Long deptId);

    /**
     * 新增保存院系信息
     * 
     * @param dept 院系信息
     * @return 结果
     */
    public int insertDept(Dept dept);

    /**
     * 修改保存院系信息
     * 
     * @param dept 院系信息
     * @return 结果
     */
    public int updateDept(Dept dept);

    /**
     * 根据院系ID查询信息
     * 
     * @param deptId 院系ID
     * @return 院系信息
     */
    public Dept selectDeptById(Long deptId);

    /**
     * 根据ID查询所有子院系（正常状态）
     * 
     * @param deptId 院系ID
     * @return 子院系数
     */
    public int selectNormalChildrenDeptById(Long deptId);

    /**
     * 校验院系名称是否唯一
     * 
     * @param dept 院系信息
     * @return 结果
     */
    public String checkDeptNameUnique(Dept dept);
}
