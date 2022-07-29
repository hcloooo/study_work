package com.proj.project.system.book.mapper;

import java.util.List;
import com.proj.project.system.book.domain.PerfRateBook;

/**
 * 学术著作业绩奖励Mapper接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface PerfRateBookMapper 
{
    /**
     * 查询学术著作业绩奖励
     * 
     * @param id 学术著作业绩奖励ID
     * @return 学术著作业绩奖励
     */
    public PerfRateBook selectPerfRateBookById(Long id);

    /**
     * 查询学术著作业绩奖励列表
     * 
     * @param perfRateBook 学术著作业绩奖励
     * @return 学术著作业绩奖励集合
     */
    public List<PerfRateBook> selectPerfRateBookList(PerfRateBook perfRateBook);

    /**
     * 新增学术著作业绩奖励
     * 
     * @param perfRateBook 学术著作业绩奖励
     * @return 结果
     */
    public int insertPerfRateBook(PerfRateBook perfRateBook);

    /**
     * 修改学术著作业绩奖励
     * 
     * @param perfRateBook 学术著作业绩奖励
     * @return 结果
     */
    public int updatePerfRateBook(PerfRateBook perfRateBook);

    /**
     * 删除学术著作业绩奖励
     * 
     * @param id 学术著作业绩奖励ID
     * @return 结果
     */
    public int deletePerfRateBookById(Long id);

    /**
     * 批量删除学术著作业绩奖励
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateBookByIds(String[] ids);
}
