package com.proj.project.system.teach.service;

import java.util.List;
import com.proj.project.system.teach.domain.TheoryTeach;

/**
 * 理论教学工作Service接口
 * 
 * @author admin
 * @date 2021-04-14
 */
public interface ITheoryTeachService 
{
    /**
     * 查询理论教学工作
     * 
     * @param id 理论教学工作ID
     * @return 理论教学工作
     */
    public TheoryTeach selectTheoryTeachById(Long id);

    /**
     * 查询理论教学工作列表
     * 
     * @param theoryTeach 理论教学工作
     * @return 理论教学工作集合
     */
    public List<TheoryTeach> selectTheoryTeachList(TheoryTeach theoryTeach);

    /**
     * 新增理论教学工作
     * 
     * @param theoryTeach 理论教学工作
     * @return 结果
     */
    public int insertTheoryTeach(TheoryTeach theoryTeach);

    /**
     * 修改理论教学工作
     * 
     * @param theoryTeach 理论教学工作
     * @return 结果
     */
    public int updateTheoryTeach(TheoryTeach theoryTeach);

    /**
     * 批量删除理论教学工作
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTheoryTeachByIds(String ids);

    /**
     * 删除理论教学工作信息
     * 
     * @param id 理论教学工作ID
     * @return 结果
     */
    public int deleteTheoryTeachById(Long id);

    int importList(List<TheoryTeach> list, boolean updateSupport);
}
