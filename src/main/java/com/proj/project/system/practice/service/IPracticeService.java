package com.proj.project.system.practice.service;

import java.util.List;
import com.proj.project.system.practice.domain.Practice;

/**
 * 实践教学工作Service接口
 * 
 * @author admin
 * @date 2021-04-15
 */
public interface IPracticeService 
{
    /**
     * 查询实践教学工作
     * 
     * @param id 实践教学工作ID
     * @return 实践教学工作
     */
    public Practice selectPracticeById(Long id);

    /**
     * 查询实践教学工作列表
     * 
     * @param practice 实践教学工作
     * @return 实践教学工作集合
     */
    public List<Practice> selectPracticeList(Practice practice);

    /**
     * 新增实践教学工作
     * 
     * @param practice 实践教学工作
     * @return 结果
     */
    public int insertPractice(Practice practice);

    /**
     * 修改实践教学工作
     * 
     * @param practice 实践教学工作
     * @return 结果
     */
    public int updatePractice(Practice practice);

    /**
     * 批量删除实践教学工作
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePracticeByIds(String ids);

    /**
     * 删除实践教学工作信息
     * 
     * @param id 实践教学工作ID
     * @return 结果
     */
    public int deletePracticeById(Long id);

    int importList(List<Practice> list, boolean updateSupport);
}
