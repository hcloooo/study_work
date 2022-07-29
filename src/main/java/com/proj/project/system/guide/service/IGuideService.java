package com.proj.project.system.guide.service;

import java.util.List;
import com.proj.project.system.guide.domain.Guide;

/**
 * 学科竞赛指导工作量Service接口
 * 
 * @author admin
 * @date 2021-04-15
 */
public interface IGuideService 
{
    /**
     * 查询学科竞赛指导工作量
     * 
     * @param id 学科竞赛指导工作量ID
     * @return 学科竞赛指导工作量
     */
    public Guide selectGuideById(Long id);

    /**
     * 查询学科竞赛指导工作量列表
     * 
     * @param guide 学科竞赛指导工作量
     * @return 学科竞赛指导工作量集合
     */
    public List<Guide> selectGuideList(Guide guide);

    /**
     * 新增学科竞赛指导工作量
     * 
     * @param guide 学科竞赛指导工作量
     * @return 结果
     */
    public int insertGuide(Guide guide);

    /**
     * 修改学科竞赛指导工作量
     * 
     * @param guide 学科竞赛指导工作量
     * @return 结果
     */
    public int updateGuide(Guide guide);

    /**
     * 批量删除学科竞赛指导工作量
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteGuideByIds(String ids);

    /**
     * 删除学科竞赛指导工作量信息
     * 
     * @param id 学科竞赛指导工作量ID
     * @return 结果
     */
    public int deleteGuideById(Long id);

    int importList(List<Guide> list, boolean updateSupport);
}
