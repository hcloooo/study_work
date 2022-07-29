package com.proj.project.system.apply.service.impl;

import java.util.Date;
import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.applyconfig.domain.Applyconfig;
import com.proj.project.system.applyconfig.mapper.ApplyconfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.proj.project.system.apply.mapper.ApplyMapper;
import com.proj.project.system.apply.domain.Apply;
import com.proj.project.system.apply.service.IApplyService;
import com.proj.common.utils.text.Convert;

/**
 * 上报申请奖励信息Service业务层处理
 * 
 * @author admin
 * @date 2021-04-26
 */
@Service
public class ApplyServiceImpl implements IApplyService 
{
    @Autowired
    private ApplyMapper applyMapper;
    @Autowired
    private ApplyconfigMapper applyconfigMapper;

    /**
     * 查询上报申请奖励信息
     * 
     * @param id 上报申请奖励信息ID
     * @return 上报申请奖励信息
     */
    @Override
    public Apply selectApplyById(Long id)
    {
        return applyMapper.selectApplyById(id);
    }

    /**
     * 查询上报申请奖励信息列表
     * 
     * @param apply 上报申请奖励信息
     * @return 上报申请奖励信息
     */
    @Override
    public List<Apply> selectApplyList(Apply apply)
    {
        return applyMapper.selectApplyList(apply);
    }

    /**
     * 新增上报申请奖励信息
     * 
     * @param apply 上报申请奖励信息
     * @return 结果
     */
    @Transactional
    @Override
    public int insertApply(Apply apply)
    {
        int row = 0;
        Date nowDate = DateUtils.getNowDate();
        apply.setCreateTime(nowDate);
        apply.setUpdateTime(nowDate);
        String[] split = apply.getUserIds().split(",");
        for (String id : split) {
            apply.setUserId(Long.valueOf(id));
            row += applyMapper.insertApply(apply);
        }
        return row;
    }

    /**
     * 修改上报申请奖励信息
     * 
     * @param apply 上报申请奖励信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateApply(Apply apply)
    {
        apply.setUpdateTime(DateUtils.getNowDate());
        return applyMapper.updateApply(apply);
    }

    /**
     * 删除上报申请奖励信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteApplyByIds(String ids)
    {
        applyMapper.deleteApplyByIds(Convert.toStrArray(ids));
        return applyMapper.deleteApplyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除上报申请奖励信息信息
     * 
     * @param id 上报申请奖励信息ID
     * @return 结果
     */
    @Override
    public int deleteApplyById(Long id)
    {
        applyMapper.deleteApplyById(id);
        return applyMapper.deleteApplyById(id);
    }
}
