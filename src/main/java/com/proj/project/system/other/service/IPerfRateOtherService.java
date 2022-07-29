package com.proj.project.system.other.service;

import java.util.List;
import com.proj.project.system.other.domain.PerfRateOther;

/**
 * 成果、其他业绩奖励Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRateOtherService 
{
    /**
     * 查询成果、其他业绩奖励
     * 
     * @param id 成果、其他业绩奖励ID
     * @return 成果、其他业绩奖励
     */
    public PerfRateOther selectPerfRateOtherById(Long id);

    /**
     * 查询成果、其他业绩奖励列表
     * 
     * @param perfRateOther 成果、其他业绩奖励
     * @return 成果、其他业绩奖励集合
     */
    public List<PerfRateOther> selectPerfRateOtherList(PerfRateOther perfRateOther);

    /**
     * 新增成果、其他业绩奖励
     * 
     * @param perfRateOther 成果、其他业绩奖励
     * @return 结果
     */
    public int insertPerfRateOther(PerfRateOther perfRateOther);

    /**
     * 修改成果、其他业绩奖励
     * 
     * @param perfRateOther 成果、其他业绩奖励
     * @return 结果
     */
    public int updatePerfRateOther(PerfRateOther perfRateOther);

    /**
     * 批量删除成果、其他业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateOtherByIds(String ids);

    /**
     * 删除成果、其他业绩奖励信息
     * 
     * @param id 成果、其他业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateOtherById(Long id);

    int importList(List<PerfRateOther> list, boolean updateSupport);
}
