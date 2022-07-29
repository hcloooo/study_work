package com.proj.project.system.rateGuide.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.rateGuide.mapper.PerfRateGuideMapper;
import com.proj.project.system.rateGuide.domain.PerfRateGuide;
import com.proj.project.system.rateGuide.service.IPerfRateGuideService;
import com.proj.common.utils.text.Convert;

/**
 * 教科研业绩及额定Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateGuideServiceImpl implements IPerfRateGuideService 
{
    @Autowired
    private PerfRateGuideMapper perfRateGuideMapper;

    /**
     * 查询教科研业绩及额定
     * 
     * @param id 教科研业绩及额定ID
     * @return 教科研业绩及额定
     */
    @Override
    public PerfRateGuide selectPerfRateGuideById(Long id)
    {
        return perfRateGuideMapper.selectPerfRateGuideById(id);
    }

    /**
     * 查询教科研业绩及额定列表
     * 
     * @param perfRateGuide 教科研业绩及额定
     * @return 教科研业绩及额定
     */
    @Override
    public List<PerfRateGuide> selectPerfRateGuideList(PerfRateGuide perfRateGuide)
    {
        return perfRateGuideMapper.selectPerfRateGuideList(perfRateGuide);
    }

    /**
     * 新增教科研业绩及额定
     * 
     * @param perfRateGuide 教科研业绩及额定
     * @return 结果
     */
    @Override
    public int insertPerfRateGuide(PerfRateGuide perfRateGuide)
    {
        perfRateGuide.setCreateTime(DateUtils.getNowDate());
        return perfRateGuideMapper.insertPerfRateGuide(perfRateGuide);
    }

    /**
     * 修改教科研业绩及额定
     * 
     * @param perfRateGuide 教科研业绩及额定
     * @return 结果
     */
    @Override
    public int updatePerfRateGuide(PerfRateGuide perfRateGuide)
    {
        return perfRateGuideMapper.updatePerfRateGuide(perfRateGuide);
    }

    /**
     * 删除教科研业绩及额定对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateGuideByIds(String ids)
    {
        return perfRateGuideMapper.deletePerfRateGuideByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教科研业绩及额定信息
     * 
     * @param id 教科研业绩及额定ID
     * @return 结果
     */
    @Override
    public int deletePerfRateGuideById(Long id)
    {
        return perfRateGuideMapper.deletePerfRateGuideById(id);
    }
}
