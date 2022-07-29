package com.proj.project.system.practice.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.common.utils.security.ShiroUtils;
import com.proj.project.system.teach.domain.TheoryTeach;
import com.proj.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.practice.mapper.PracticeMapper;
import com.proj.project.system.practice.domain.Practice;
import com.proj.project.system.practice.service.IPracticeService;
import com.proj.common.utils.text.Convert;

/**
 * 实践教学工作Service业务层处理
 * 
 * @author admin
 * @date 2021-04-15
 */
@Service
public class PracticeServiceImpl implements IPracticeService 
{
    @Autowired
    private PracticeMapper practiceMapper;

    /**
     * 查询实践教学工作
     * 
     * @param id 实践教学工作ID
     * @return 实践教学工作
     */
    @Override
    public Practice selectPracticeById(Long id)
    {
        return practiceMapper.selectPracticeById(id);
    }

    /**
     * 查询实践教学工作列表
     * 
     * @param practice 实践教学工作
     * @return 实践教学工作
     */
    @Override
    public List<Practice> selectPracticeList(Practice practice)
    {
        return practiceMapper.selectPracticeList(practice);
    }

    /**
     * 新增实践教学工作
     * 
     * @param practice 实践教学工作
     * @return 结果
     */
    @Override
    public int insertPractice(Practice practice)
    {
        practice.setCreateTime(DateUtils.getNowDate());
        return practiceMapper.insertPractice(practice);
    }

    /**
     * 修改实践教学工作
     * 
     * @param practice 实践教学工作
     * @return 结果
     */
    @Override
    public int updatePractice(Practice practice)
    {
        return practiceMapper.updatePractice(practice);
    }

    /**
     * 删除实践教学工作对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePracticeByIds(String ids)
    {
        return practiceMapper.deletePracticeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除实践教学工作信息
     * 
     * @param id 实践教学工作ID
     * @return 结果
     */
    @Override
    public int deletePracticeById(Long id)
    {
        return practiceMapper.deletePracticeById(id);
    }

    @Override
    public int importList(List<Practice> list, boolean updateSupport) {
        int rows = 1;
        User sysUser = ShiroUtils.getSysUser();
        for (Practice practice : list) {
            practice.setCreateUser(sysUser.getUserId().intValue());
            rows += practiceMapper.insertPractice(practice);
        }
        return rows;
    }
}
