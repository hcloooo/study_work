package com.proj.project.system.base.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.other.domain.PerfRateOther;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.base.mapper.PerfRateBaseMapper;
import com.proj.project.system.base.domain.PerfRateBase;
import com.proj.project.system.base.service.IPerfRateBaseService;
import com.proj.common.utils.text.Convert;

/**
 * 教学-基本业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateBaseServiceImpl implements IPerfRateBaseService 
{
    @Autowired
    private PerfRateBaseMapper perfRateBaseMapper;

    /**
     * 查询教学-基本业绩奖励
     * 
     * @param id 教学-基本业绩奖励ID
     * @return 教学-基本业绩奖励
     */
    @Override
    public PerfRateBase selectPerfRateBaseById(Long id)
    {
        return perfRateBaseMapper.selectPerfRateBaseById(id);
    }

    /**
     * 查询教学-基本业绩奖励列表
     * 
     * @param perfRateBase 教学-基本业绩奖励
     * @return 教学-基本业绩奖励
     */
    @Override
    public List<PerfRateBase> selectPerfRateBaseList(PerfRateBase perfRateBase)
    {
        return perfRateBaseMapper.selectPerfRateBaseList(perfRateBase);
    }

    /**
     * 新增教学-基本业绩奖励
     * 
     * @param perfRateBase 教学-基本业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateBase(PerfRateBase perfRateBase)
    {
        perfRateBase.setCreateTime(DateUtils.getNowDate());
        return perfRateBaseMapper.insertPerfRateBase(perfRateBase);
    }

    /**
     * 修改教学-基本业绩奖励
     * 
     * @param perfRateBase 教学-基本业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateBase(PerfRateBase perfRateBase)
    {
        return perfRateBaseMapper.updatePerfRateBase(perfRateBase);
    }

    /**
     * 删除教学-基本业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateBaseByIds(String ids)
    {
        return perfRateBaseMapper.deletePerfRateBaseByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教学-基本业绩奖励信息
     * 
     * @param id 教学-基本业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateBaseById(Long id)
    {
        return perfRateBaseMapper.deletePerfRateBaseById(id);
    }
    @Override
    public int importList(List<PerfRateBase> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateBase item : list) {
            rows += perfRateBaseMapper.insertPerfRateBase(item);
        }
        return rows;
    }
}
