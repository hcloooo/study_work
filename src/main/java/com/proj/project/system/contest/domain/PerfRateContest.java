package com.proj.project.system.contest.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 教学-竞赛业绩奖励对象 t_perf_rate_contest
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateContest extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 院系 */
    @Excel(name = "院系")
    private Long deptId;
    private String deptName;

    /** 竞赛名称 */
    @Excel(name = "竞赛名称")
    private String contestName;
    private String projName;

    /** 项目级 */
    @Excel(name = "项目级")
    private String grade;

    /** 奖励级 */
    @Excel(name = "奖励级")
    private String priceBaseGrade;

    /** 主办单位 */
    @Excel(name = "主办单位")
    private String organizer;

    /** 获奖时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "获奖时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date priceTime;

    /** 获奖等级 */
    @Excel(name = "获奖等级")
    private String priceGrade;

    /** 国家 */
    @Excel(name = "国家")
    private String country;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal priceAmount;

    /** 指导老师姓名 */
    @Excel(name = "指导老师姓名")
    private Integer userId;

    public String getProjName() {
        return this.contestName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
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
    public void setContestName(String contestName)
    {
        this.contestName = contestName;
    }

    public String getContestName()
    {
        return contestName;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setPriceBaseGrade(String priceBaseGrade)
    {
        this.priceBaseGrade = priceBaseGrade;
    }

    public String getPriceBaseGrade()
    {
        return priceBaseGrade;
    }
    public void setOrganizer(String organizer)
    {
        this.organizer = organizer;
    }

    public String getOrganizer()
    {
        return organizer;
    }
    public void setPriceTime(Date priceTime)
    {
        this.priceTime = priceTime;
    }

    public Date getPriceTime()
    {
        return priceTime;
    }
    public void setPriceGrade(String priceGrade)
    {
        this.priceGrade = priceGrade;
    }

    public String getPriceGrade()
    {
        return priceGrade;
    }
    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountry()
    {
        return country;
    }
    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getProvince()
    {
        return province;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
    public void setUserId(Integer userId)
    {
        this.userId = userId;
    }

    public Integer getUserId()
    {
        return userId;
    }
}
