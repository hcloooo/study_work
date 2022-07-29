package com.proj.project.system.applyconfig.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.applyconfig.mapper.ApplyconfigMapper;
import com.proj.project.system.applyconfig.domain.Applyconfig;
import com.proj.project.system.applyconfig.service.IApplyconfigService;
import com.proj.common.utils.text.Convert;

/**
 * 审批流程Service业务层处理
 * 
 * @author admin
 * @date 2021-04-26
 */
@Service
public class ApplyconfigServiceImpl implements IApplyconfigService 
{
    @Autowired
    private ApplyconfigMapper applyconfigMapper;

    /**
     * 查询审批流程
     * 
     * @param id 审批流程ID
     * @return 审批流程
     */
    @Override
    public Applyconfig selectApplyconfigById(Long id)
    {
        return applyconfigMapper.selectApplyconfigById(id);
    }

    /**
     * 查询审批流程列表
     * 
     * @param applyconfig 审批流程
     * @return 审批流程
     */
    @Override
    public List<Applyconfig> selectApplyconfigList(Applyconfig applyconfig)
    {
        return applyconfigMapper.selectApplyconfigList(applyconfig);
    }

    /**
     * 新增审批流程
     * 
     * @param applyconfig 审批流程
     * @return 结果
     */
    @Override
    public int insertApplyconfig(Applyconfig applyconfig)
    {
        return applyconfigMapper.insertApplyconfig(applyconfig);
    }

    /**
     * 修改审批流程
     * 
     * @param applyconfig 审批流程
     * @return 结果
     */
    @Override
    public int updateApplyconfig(Applyconfig applyconfig)
    {
        return applyconfigMapper.updateApplyconfig(applyconfig);
    }

    /**
     * 删除审批流程对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteApplyconfigByIds(String ids)
    {
        return applyconfigMapper.deleteApplyconfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除审批流程信息
     * 
     * @param id 审批流程ID
     * @return 结果
     */
    @Override
    public int deleteApplyconfigById(Long id)
    {
        return applyconfigMapper.deleteApplyconfigById(id);
    }
}
