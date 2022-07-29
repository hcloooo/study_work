package com.proj.project.system.standard.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.standard.mapper.WorkStandardMapper;
import com.proj.project.system.standard.domain.WorkStandard;
import com.proj.project.system.standard.service.IWorkStandardService;
import com.proj.common.utils.text.Convert;

/**
 * 工作、业绩发放标准Service业务层处理
 * 
 * @author admin
 * @date 2021-04-26
 */
@Service
public class WorkStandardServiceImpl implements IWorkStandardService 
{
    @Autowired
    private WorkStandardMapper workStandardMapper;

    /**
     * 查询工作、业绩发放标准
     * 
     * @param id 工作、业绩发放标准ID
     * @return 工作、业绩发放标准
     */
    @Override
    public WorkStandard selectWorkStandardById(Long id)
    {
        return workStandardMapper.selectWorkStandardById(id);
    }

    /**
     * 查询工作、业绩发放标准列表
     * 
     * @param workStandard 工作、业绩发放标准
     * @return 工作、业绩发放标准
     */
    @Override
    public List<WorkStandard> selectWorkStandardList(WorkStandard workStandard)
    {
        return workStandardMapper.selectWorkStandardList(workStandard);
    }

    /**
     * 新增工作、业绩发放标准
     * 
     * @param workStandard 工作、业绩发放标准
     * @return 结果
     */
    @Override
    public int insertWorkStandard(WorkStandard workStandard)
    {
        return workStandardMapper.insertWorkStandard(workStandard);
    }

    /**
     * 修改工作、业绩发放标准
     * 
     * @param workStandard 工作、业绩发放标准
     * @return 结果
     */
    @Override
    public int updateWorkStandard(WorkStandard workStandard)
    {
        return workStandardMapper.updateWorkStandard(workStandard);
    }

    /**
     * 删除工作、业绩发放标准对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkStandardByIds(String ids)
    {
        return workStandardMapper.deleteWorkStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除工作、业绩发放标准信息
     * 
     * @param id 工作、业绩发放标准ID
     * @return 结果
     */
    @Override
    public int deleteWorkStandardById(Long id)
    {
        return workStandardMapper.deleteWorkStandardById(id);
    }
}
