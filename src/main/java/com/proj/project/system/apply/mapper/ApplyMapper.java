package com.proj.project.system.apply.mapper;

import java.util.List;
import com.proj.project.system.apply.domain.Apply;

/**
 * 上报申请奖励信息Mapper接口
 * 
 * @author admin
 * @date 2021-04-26
 */
public interface ApplyMapper 
{
    /**
     * 查询上报申请奖励信息
     * 
     * @param id 上报申请奖励信息ID
     * @return 上报申请奖励信息
     */
    public Apply selectApplyById(Long id);

    /**
     * 查询上报申请奖励信息列表
     * 
     * @param apply 上报申请奖励信息
     * @return 上报申请奖励信息集合
     */
    public List<Apply> selectApplyList(Apply apply);

    /**
     * 新增上报申请奖励信息
     * 
     * @param apply 上报申请奖励信息
     * @return 结果
     */
    public int insertApply(Apply apply);

    /**
     * 修改上报申请奖励信息
     * 
     * @param apply 上报申请奖励信息
     * @return 结果
     */
    public int updateApply(Apply apply);

    /**
     * 删除上报申请奖励信息
     * 
     * @param id 上报申请奖励信息ID
     * @return 结果
     */
    public int deleteApplyById(Long id);

    /**
     * 批量删除上报申请奖励信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteApplyByIds(String[] ids);
}
