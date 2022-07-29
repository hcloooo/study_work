package com.proj.project.system.contest.service;

import java.util.List;
import com.proj.project.system.contest.domain.PerfRateContest;

/**
 * 教学-竞赛业绩奖励Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRateContestService 
{
    /**
     * 查询教学-竞赛业绩奖励
     * 
     * @param id 教学-竞赛业绩奖励ID
     * @return 教学-竞赛业绩奖励
     */
    public PerfRateContest selectPerfRateContestById(Long id);

    /**
     * 查询教学-竞赛业绩奖励列表
     * 
     * @param perfRateContest 教学-竞赛业绩奖励
     * @return 教学-竞赛业绩奖励集合
     */
    public List<PerfRateContest> selectPerfRateContestList(PerfRateContest perfRateContest);

    /**
     * 新增教学-竞赛业绩奖励
     * 
     * @param perfRateContest 教学-竞赛业绩奖励
     * @return 结果
     */
    public int insertPerfRateContest(PerfRateContest perfRateContest);

    /**
     * 修改教学-竞赛业绩奖励
     * 
     * @param perfRateContest 教学-竞赛业绩奖励
     * @return 结果
     */
    public int updatePerfRateContest(PerfRateContest perfRateContest);

    /**
     * 批量删除教学-竞赛业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateContestByIds(String ids);

    /**
     * 删除教学-竞赛业绩奖励信息
     * 
     * @param id 教学-竞赛业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateContestById(Long id);

    int importList(List<PerfRateContest> list, boolean updateSupport);
}
