package com.proj.project.system.standard.mapper;

import java.util.List;
import com.proj.project.system.standard.domain.WorkStandard;

/**
 * 工作、业绩发放标准Mapper接口
 * 
 * @author admin
 * @date 2021-04-26
 */
public interface WorkStandardMapper 
{
    /**
     * 查询工作、业绩发放标准
     * 
     * @param id 工作、业绩发放标准ID
     * @return 工作、业绩发放标准
     */
    public WorkStandard selectWorkStandardById(Long id);

    /**
     * 查询工作、业绩发放标准列表
     * 
     * @param workStandard 工作、业绩发放标准
     * @return 工作、业绩发放标准集合
     */
    public List<WorkStandard> selectWorkStandardList(WorkStandard workStandard);

    /**
     * 新增工作、业绩发放标准
     * 
     * @param workStandard 工作、业绩发放标准
     * @return 结果
     */
    public int insertWorkStandard(WorkStandard workStandard);

    /**
     * 修改工作、业绩发放标准
     * 
     * @param workStandard 工作、业绩发放标准
     * @return 结果
     */
    public int updateWorkStandard(WorkStandard workStandard);

    /**
     * 删除工作、业绩发放标准
     * 
     * @param id 工作、业绩发放标准ID
     * @return 结果
     */
    public int deleteWorkStandardById(Long id);

    /**
     * 批量删除工作、业绩发放标准
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkStandardByIds(String[] ids);
}
