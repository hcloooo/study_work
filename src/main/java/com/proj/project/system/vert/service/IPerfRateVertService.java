package com.proj.project.system.vert.service;

import java.util.List;
import com.proj.project.system.vert.domain.PerfRateVert;

/**
 * 纵横向业绩奖励Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRateVertService 
{
    /**
     * 查询纵横向业绩奖励
     * 
     * @param id 纵横向业绩奖励ID
     * @return 纵横向业绩奖励
     */
    public PerfRateVert selectPerfRateVertById(Long id);

    /**
     * 查询纵横向业绩奖励列表
     * 
     * @param perfRateVert 纵横向业绩奖励
     * @return 纵横向业绩奖励集合
     */
    public List<PerfRateVert> selectPerfRateVertList(PerfRateVert perfRateVert);

    /**
     * 新增纵横向业绩奖励
     * 
     * @param perfRateVert 纵横向业绩奖励
     * @return 结果
     */
    public int insertPerfRateVert(PerfRateVert perfRateVert);

    /**
     * 修改纵横向业绩奖励
     * 
     * @param perfRateVert 纵横向业绩奖励
     * @return 结果
     */
    public int updatePerfRateVert(PerfRateVert perfRateVert);

    /**
     * 批量删除纵横向业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateVertByIds(String ids);

    /**
     * 删除纵横向业绩奖励信息
     * 
     * @param id 纵横向业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateVertById(Long id);

    int importList(List<PerfRateVert> list, boolean updateSupport);
}
