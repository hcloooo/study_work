package com.proj.project.system.base.domain;

import java.math.BigDecimal;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 教学-基本业绩奖励对象 t_perf_rate_base
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateBase extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 院系 */
    @Excel(name = "院系")
    private Long deptId;

    /** 类别 */
    @Excel(name = "类别")
    private String type;

    /** 成果名称 */
    @Excel(name = "成果名称")
    private String resultName;
    private String projName;

    /** 获奖等级 */
    @Excel(name = "获奖等级")
    private String grade;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long userId;

    /** 获奖年度 */
    @Excel(name = "获奖年度")
    private Integer priceYear;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal priceAmount;

    /** 获奖证书 */
    @Excel(name = "获奖证书")
    private String priceCert;

    public String getProjName() {
        return this.resultName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setResultName(String resultName)
    {
        this.resultName = resultName;
    }

    public String getResultName()
    {
        return resultName;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setPriceYear(Integer priceYear)
    {
        this.priceYear = priceYear;
    }

    public Integer getPriceYear()
    {
        return priceYear;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
    public void setPriceCert(String priceCert)
    {
        this.priceCert = priceCert;
    }

    public String getPriceCert()
    {
        return priceCert;
    }
}
