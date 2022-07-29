package com.proj.project.system.textbook.mapper;

import java.util.List;
import com.proj.project.system.textbook.domain.PerfRateTextbook;

/**
 * 教学-教材业绩奖励Mapper接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface PerfRateTextbookMapper 
{
    /**
     * 查询教学-教材业绩奖励
     * 
     * @param id 教学-教材业绩奖励ID
     * @return 教学-教材业绩奖励
     */
    public PerfRateTextbook selectPerfRateTextbookById(Long id);

    /**
     * 查询教学-教材业绩奖励列表
     * 
     * @param perfRateTextbook 教学-教材业绩奖励
     * @return 教学-教材业绩奖励集合
     */
    public List<PerfRateTextbook> selectPerfRateTextbookList(PerfRateTextbook perfRateTextbook);

    /**
     * 新增教学-教材业绩奖励
     * 
     * @param perfRateTextbook 教学-教材业绩奖励
     * @return 结果
     */
    public int insertPerfRateTextbook(PerfRateTextbook perfRateTextbook);

    /**
     * 修改教学-教材业绩奖励
     * 
     * @param perfRateTextbook 教学-教材业绩奖励
     * @return 结果
     */
    public int updatePerfRateTextbook(PerfRateTextbook perfRateTextbook);

    /**
     * 删除教学-教材业绩奖励
     * 
     * @param id 教学-教材业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateTextbookById(Long id);

    /**
     * 批量删除教学-教材业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateTextbookByIds(String[] ids);
}
