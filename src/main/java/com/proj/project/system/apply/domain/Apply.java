package com.proj.project.system.apply.domain;

import java.util.List;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;
import com.proj.project.system.standard.domain.PriceStandard;

/**
 * 上报申请奖励信息对象 t_apply
 * 
 * @author admin
 * @date 2021-04-26
 */
public class Apply extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 工号 */
    @Excel(name = "工号")
    private Long userId;
    private String userIds;

    /** 奖惩类型 */
    @Excel(name = "奖惩类型")
    private Long priceId;

    /** 个人情况说明 */
    @Excel(name = "个人情况说明")
    private String descr;

    /** 处理人角色 */
    @Excel(name = "处理人角色")
    private Long applyRoleId;

    /** 审批进度 */
    @Excel(name = "审批进度")
    private Integer applyStatus;
    private String priceName;
    private String roleName;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setPriceId(Long priceId)
    {
        this.priceId = priceId;
    }

    public Long getPriceId()
    {
        return priceId;
    }
    public void setDescr(String descr)
    {
        this.descr = descr;
    }

    public String getDescr()
    {
        return descr;
    }
    public void setApplyRoleId(Long applyRoleId)
    {
        this.applyRoleId = applyRoleId;
    }

    public Long getApplyRoleId()
    {
        return applyRoleId;
    }
    public void setApplyStatus(Integer applyStatus)
    {
        this.applyStatus = applyStatus;
    }

    public Integer getApplyStatus()
    {
        return applyStatus;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
