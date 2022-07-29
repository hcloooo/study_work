package com.proj.project.system.other.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import com.proj.project.system.skill.domain.PerfRateSkill;
import com.proj.project.system.user.domain.User;
import com.proj.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.other.mapper.PerfRateOtherMapper;
import com.proj.project.system.other.domain.PerfRateOther;
import com.proj.project.system.other.service.IPerfRateOtherService;
import com.proj.common.utils.text.Convert;

/**
 * 成果、其他业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateOtherServiceImpl implements IPerfRateOtherService 
{
    @Autowired
    private PerfRateOtherMapper perfRateOtherMapper;

    /**
     * 查询成果、其他业绩奖励
     * 
     * @param id 成果、其他业绩奖励ID
     * @return 成果、其他业绩奖励
     */
    @Override
    public PerfRateOther selectPerfRateOtherById(Long id)
    {
        return perfRateOtherMapper.selectPerfRateOtherById(id);
    }

    /**
     * 查询成果、其他业绩奖励列表
     * 
     * @param perfRateOther 成果、其他业绩奖励
     * @return 成果、其他业绩奖励
     */
    @Override
    public List<PerfRateOther> selectPerfRateOtherList(PerfRateOther perfRateOther)
    {
        return perfRateOtherMapper.selectPerfRateOtherList(perfRateOther);
    }

    /**
     * 新增成果、其他业绩奖励
     * 
     * @param perfRateOther 成果、其他业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateOther(PerfRateOther perfRateOther)
    {
        perfRateOther.setCreateTime(DateUtils.getNowDate());
        return perfRateOtherMapper.insertPerfRateOther(perfRateOther);
    }

    /**
     * 修改成果、其他业绩奖励
     * 
     * @param perfRateOther 成果、其他业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateOther(PerfRateOther perfRateOther)
    {
        return perfRateOtherMapper.updatePerfRateOther(perfRateOther);
    }

    /**
     * 删除成果、其他业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateOtherByIds(String ids)
    {
        return perfRateOtherMapper.deletePerfRateOtherByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除成果、其他业绩奖励信息
     * 
     * @param id 成果、其他业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateOtherById(Long id)
    {
        return perfRateOtherMapper.deletePerfRateOtherById(id);
    }

    @Override
    public int importList(List<PerfRateOther> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateOther item : list) {
            rows += perfRateOtherMapper.insertPerfRateOther(item);
        }
        return rows;
    }
}
