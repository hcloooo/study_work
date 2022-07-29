package com.proj.project.system.skill.service;

import java.util.List;
import com.proj.project.system.skill.domain.PerfRateSkill;

/**
 * 学术业绩奖励Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRateSkillService 
{
    /**
     * 查询学术业绩奖励
     * 
     * @param id 学术业绩奖励ID
     * @return 学术业绩奖励
     */
    public PerfRateSkill selectPerfRateSkillById(Long id);

    /**
     * 查询学术业绩奖励列表
     * 
     * @param perfRateSkill 学术业绩奖励
     * @return 学术业绩奖励集合
     */
    public List<PerfRateSkill> selectPerfRateSkillList(PerfRateSkill perfRateSkill);

    /**
     * 新增学术业绩奖励
     * 
     * @param perfRateSkill 学术业绩奖励
     * @return 结果
     */
    public int insertPerfRateSkill(PerfRateSkill perfRateSkill);

    /**
     * 修改学术业绩奖励
     * 
     * @param perfRateSkill 学术业绩奖励
     * @return 结果
     */
    public int updatePerfRateSkill(PerfRateSkill perfRateSkill);

    /**
     * 批量删除学术业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateSkillByIds(String ids);

    /**
     * 删除学术业绩奖励信息
     * 
     * @param id 学术业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateSkillById(Long id);

    int importList(List<PerfRateSkill> list, boolean updateSupport);
}
