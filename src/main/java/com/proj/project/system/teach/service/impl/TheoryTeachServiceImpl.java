package com.proj.project.system.teach.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.common.utils.security.ShiroUtils;
import com.proj.project.system.user.domain.User;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.teach.mapper.TheoryTeachMapper;
import com.proj.project.system.teach.domain.TheoryTeach;
import com.proj.project.system.teach.service.ITheoryTeachService;
import com.proj.common.utils.text.Convert;

/**
 * 理论教学工作Service业务层处理
 * 
 * @author admin
 * @date 2021-04-14
 */
@Service
public class TheoryTeachServiceImpl implements ITheoryTeachService 
{
    @Autowired
    private TheoryTeachMapper theoryTeachMapper;

    /**
     * 查询理论教学工作
     * 
     * @param id 理论教学工作ID
     * @return 理论教学工作
     */
    @Override
    public TheoryTeach selectTheoryTeachById(Long id)
    {
        return theoryTeachMapper.selectTheoryTeachById(id);
    }

    /**
     * 查询理论教学工作列表
     * 
     * @param theoryTeach 理论教学工作
     * @return 理论教学工作
     */
    @Override
    public List<TheoryTeach> selectTheoryTeachList(TheoryTeach theoryTeach)
    {
        return theoryTeachMapper.selectTheoryTeachList(theoryTeach);
    }

    /**
     * 新增理论教学工作
     * 
     * @param theoryTeach 理论教学工作
     * @return 结果
     */
    @Override
    public int insertTheoryTeach(TheoryTeach theoryTeach)
    {
        theoryTeach.setCreateTime(DateUtils.getNowDate());
        return theoryTeachMapper.insertTheoryTeach(theoryTeach);
    }

    /**
     * 修改理论教学工作
     * 
     * @param theoryTeach 理论教学工作
     * @return 结果
     */
    @Override
    public int updateTheoryTeach(TheoryTeach theoryTeach)
    {
        return theoryTeachMapper.updateTheoryTeach(theoryTeach);
    }

    /**
     * 删除理论教学工作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTheoryTeachByIds(String ids)
    {
        return theoryTeachMapper.deleteTheoryTeachByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除理论教学工作信息
     * 
     * @param id 理论教学工作ID
     * @return 结果
     */
    @Override
    public int deleteTheoryTeachById(Long id)
    {
        return theoryTeachMapper.deleteTheoryTeachById(id);
    }

    @Override
    public int importList(List<TheoryTeach> list, boolean updateSupport) {
        int rows = 1;
        User sysUser = ShiroUtils.getSysUser();
        for (TheoryTeach theoryTeach : list) {
            theoryTeach.setCreateUser(sysUser.getUserId().intValue());
            rows += theoryTeachMapper.insertTheoryTeach(theoryTeach);
        }
        return rows;
    }
}
