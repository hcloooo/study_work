package com.proj.project.system.applyconfig.service;

import java.util.List;
import com.proj.project.system.applyconfig.domain.Applyconfig;

/**
 * 审批流程Service接口
 * 
 * @author admin
 * @date 2021-04-26
 */
public interface IApplyconfigService 
{
    /**
     * 查询审批流程
     * 
     * @param id 审批流程ID
     * @return 审批流程
     */
    public Applyconfig selectApplyconfigById(Long id);

    /**
     * 查询审批流程列表
     * 
     * @param applyconfig 审批流程
     * @return 审批流程集合
     */
    public List<Applyconfig> selectApplyconfigList(Applyconfig applyconfig);

    /**
     * 新增审批流程
     * 
     * @param applyconfig 审批流程
     * @return 结果
     */
    public int insertApplyconfig(Applyconfig applyconfig);

    /**
     * 修改审批流程
     * 
     * @param applyconfig 审批流程
     * @return 结果
     */
    public int updateApplyconfig(Applyconfig applyconfig);

    /**
     * 批量删除审批流程
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApplyconfigByIds(String ids);

    /**
     * 删除审批流程信息
     * 
     * @param id 审批流程ID
     * @return 结果
     */
    public int deleteApplyconfigById(Long id);
}
