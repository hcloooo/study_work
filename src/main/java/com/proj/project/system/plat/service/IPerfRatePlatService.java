package com.proj.project.system.plat.service;

import java.util.List;
import com.proj.project.system.plat.domain.PerfRatePlat;

/**
 * 平台业绩奖励Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRatePlatService 
{
    /**
     * 查询平台业绩奖励
     * 
     * @param id 平台业绩奖励ID
     * @return 平台业绩奖励
     */
    public PerfRatePlat selectPerfRatePlatById(Long id);

    /**
     * 查询平台业绩奖励列表
     * 
     * @param perfRatePlat 平台业绩奖励
     * @return 平台业绩奖励集合
     */
    public List<PerfRatePlat> selectPerfRatePlatList(PerfRatePlat perfRatePlat);

    /**
     * 新增平台业绩奖励
     * 
     * @param perfRatePlat 平台业绩奖励
     * @return 结果
     */
    public int insertPerfRatePlat(PerfRatePlat perfRatePlat);

    /**
     * 修改平台业绩奖励
     * 
     * @param perfRatePlat 平台业绩奖励
     * @return 结果
     */
    public int updatePerfRatePlat(PerfRatePlat perfRatePlat);

    /**
     * 批量删除平台业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRatePlatByIds(String ids);

    /**
     * 删除平台业绩奖励信息
     * 
     * @param id 平台业绩奖励ID
     * @return 结果
     */
    public int deletePerfRatePlatById(Long id);

    int importList(List<PerfRatePlat> list, boolean updateSupport);
}
