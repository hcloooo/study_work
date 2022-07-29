package com.proj.project.system.applyconfig.domain;

import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 审批流程对象 t_applyconfig
 * 
 * @author admin
 * @date 2021-04-26
 */
public class Applyconfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 奖惩类型 */
    @Excel(name = "奖惩类型")
    private Long priceId;
    private String priceName;

    /** 处理人角色 */
    @Excel(name = "处理人角色")
    private Long roleId;
    private String roleName;

    /** 处理顺序 */
    @Excel(name = "处理顺序")
    private Integer sortNum;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPriceId(Long priceId)
    {
        this.priceId = priceId;
    }

    public Long getPriceId()
    {
        return priceId;
    }
    public void setRoleId(Long roleId)
    {
        this.roleId = roleId;
    }

    public Long getRoleId()
    {
        return roleId;
    }
    public void setSortNum(Integer sortNum)
    {
        this.sortNum = sortNum;
    }

    public Integer getSortNum()
    {
        return sortNum;
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
