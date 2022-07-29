package com.proj.project.system.base.service;

import java.util.List;
import com.proj.project.system.base.domain.PerfRateBase;

/**
 * 教学-基本业绩奖励Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRateBaseService 
{
    /**
     * 查询教学-基本业绩奖励
     * 
     * @param id 教学-基本业绩奖励ID
     * @return 教学-基本业绩奖励
     */
    public PerfRateBase selectPerfRateBaseById(Long id);

    /**
     * 查询教学-基本业绩奖励列表
     * 
     * @param perfRateBase 教学-基本业绩奖励
     * @return 教学-基本业绩奖励集合
     */
    public List<PerfRateBase> selectPerfRateBaseList(PerfRateBase perfRateBase);

    /**
     * 新增教学-基本业绩奖励
     * 
     * @param perfRateBase 教学-基本业绩奖励
     * @return 结果
     */
    public int insertPerfRateBase(PerfRateBase perfRateBase);

    /**
     * 修改教学-基本业绩奖励
     * 
     * @param perfRateBase 教学-基本业绩奖励
     * @return 结果
     */
    public int updatePerfRateBase(PerfRateBase perfRateBase);

    /**
     * 批量删除教学-基本业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateBaseByIds(String ids);

    /**
     * 删除教学-基本业绩奖励信息
     * 
     * @param id 教学-基本业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateBaseById(Long id);

    int importList(List<PerfRateBase> list, boolean updateSupport);
}
