package com.proj.project.system.skill.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 学术业绩奖励对象 t_perf_rate_skill
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateSkill extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 院系 */
//    @Excel(name = "院系")
    private Long deptId;
    @Excel(name = "院系")
    private String deptName;

    /** 学术名称 */
    @Excel(name = "学术名称")
    private String skillName;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 标准类型 */
    @Excel(name = "标准类型")
    private String standard;

    /** 排名 */
    @Excel(name = "排名")
    private Integer sortNo;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal priceAmount;
    private String projName;

    public String getProjName() {
        return this.skillName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
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
    public void setSkillName(String skillName)
    {
        this.skillName = skillName;
    }

    public String getSkillName()
    {
        return skillName;
    }
    public void setPublishTime(Date publishTime)
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime()
    {
        return publishTime;
    }
    public void setStandard(String standard)
    {
        this.standard = standard;
    }

    public String getStandard()
    {
        return standard;
    }
    public void setSortNo(Integer sortNo)
    {
        this.sortNo = sortNo;
    }

    public Integer getSortNo()
    {
        return sortNo;
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
