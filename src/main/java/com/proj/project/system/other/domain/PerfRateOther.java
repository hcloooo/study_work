package com.proj.project.system.other.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 成果、其他业绩奖励对象 t_perf_rate_other
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateOther extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projName;

    /** 主要完成人 */
    @Excel(name = "主要完成人(员工号)")
    private Long userId;

    /** 主要完成单位 */
    @Excel(name = "主要完成单位")
    private String unit;

    /** 获奖时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "获奖时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date priceTime;

    /** 授奖单位 */
    @Excel(name = "授奖单位")
    private String priceUnit;

    /** 获奖等级 */
    @Excel(name = "获奖等级")
    private String priceGrade;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal priceAmount;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setProjName(String projName)
    {
        this.projName = projName;
    }

    public String getProjName()
    {
        return projName;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getUnit()
    {
        return unit;
    }
    public void setPriceTime(Date priceTime)
    {
        this.priceTime = priceTime;
    }

    public Date getPriceTime()
    {
        return priceTime;
    }
    public void setPriceUnit(String priceUnit)
    {
        this.priceUnit = priceUnit;
    }

    public String getPriceUnit()
    {
        return priceUnit;
    }
    public void setPriceGrade(String priceGrade)
    {
        this.priceGrade = priceGrade;
    }

    public String getPriceGrade()
    {
        return priceGrade;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
}
