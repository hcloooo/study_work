package com.proj.project.system.vert.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 纵横向业绩奖励对象 t_perf_rate_vert
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateVert extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 立项时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "立项时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date subjectTime;

    /** 课题名称 */
    @Excel(name = "课题名称")
    private String subjectName;

    /** 课题类别 */
    @Excel(name = "课题类别")
    private String subjectType;

    /** 课题来源 */
    @Excel(name = "课题来源")
    private String subjectFrom;

    /** 级别 */
    @Excel(name = "级别")
    private String grade;

    /** 总经费 */
    @Excel(name = "总经费")
    private BigDecimal totalMoney;

    /** 拟奖励额 */
    @Excel(name = "拟奖励额")
    private BigDecimal priceAmount;

    /** 院系 */
    @Excel(name = "院系")
    private Long deptId;
    private String deptName;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long userId;

    /** 课题编号 */
    @Excel(name = "课题编号")
    private String subjectNo;

    private String projName;

    public String getProjName() {
        return this.subjectName;
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
    public void setSubjectTime(Date subjectTime)
    {
        this.subjectTime = subjectTime;
    }

    public Date getSubjectTime()
    {
        return subjectTime;
    }
    public void setSubjectName(String subjectName)
    {
        this.subjectName = subjectName;
    }

    public String getSubjectName()
    {
        return subjectName;
    }
    public void setSubjectType(String subjectType)
    {
        this.subjectType = subjectType;
    }

    public String getSubjectType()
    {
        return subjectType;
    }
    public void setSubjectFrom(String subjectFrom)
    {
        this.subjectFrom = subjectFrom;
    }

    public String getSubjectFrom()
    {
        return subjectFrom;
    }
    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGrade()
    {
        return grade;
    }
    public void setTotalMoney(BigDecimal totalMoney)
    {
        this.totalMoney = totalMoney;
    }

    public BigDecimal getTotalMoney()
    {
        return totalMoney;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
    public void setDeptId(Long deptId)
    {
        this.deptId = deptId;
    }

    public Long getDeptId()
    {
        return deptId;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setSubjectNo(String subjectNo)
    {
        this.subjectNo = subjectNo;
    }

    public String getSubjectNo()
    {
        return subjectNo;
    }
}
