package com.proj.project.system.guide.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 学科竞赛指导工作量对象 t_guide
 * 
 * @author admin
 * @date 2021-04-15
 */
public class Guide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 工号 */
    @Excel(name = "工号")
    private String userNo;

    /** 指导老师 */
    @Excel(name = "指导老师")
    private String userName;

    /** 上课班级 */
    @Excel(name = "上课班级")
    private String className;

    /** 学生姓名 */
    @Excel(name = "学生姓名")
    private String studentName;

    /** 竞赛名称 */
    @Excel(name = "竞赛名称")
    private String raceName;

    /** 竞赛时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "竞赛时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date raceTime;

    /** 周数 */
    @Excel(name = "周数")
    private String weekNum;

    /** 修正系数P */
    @Excel(name = "修正系数P")
    private BigDecimal modulus;

    /** 计划学时 */
    @Excel(name = "计划学时")
    private Integer planNum;

    /** $column.columnComment */
//    @Excel(name = "计划学时")
    private Integer createUser;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserNo(String userNo)
    {
        this.userNo = userNo;
    }

    public String getUserNo()
    {
        return userNo;
    }
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }
    public void setClassName(String className)
    {
        this.className = className;
    }

    public String getClassName()
    {
        return className;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }

    public String getStudentName()
    {
        return studentName;
    }
    public void setRaceName(String raceName)
    {
        this.raceName = raceName;
    }

    public String getRaceName()
    {
        return raceName;
    }
    public void setRaceTime(Date raceTime)
    {
        this.raceTime = raceTime;
    }

    public Date getRaceTime()
    {
        return raceTime;
    }
    public void setWeekNum(String weekNum)
    {
        this.weekNum = weekNum;
    }

    public String getWeekNum()
    {
        return weekNum;
    }
    public void setModulus(BigDecimal modulus)
    {
        this.modulus = modulus;
    }

    public BigDecimal getModulus()
    {
        return modulus;
    }
    public void setPlanNum(Integer planNum)
    {
        this.planNum = planNum;
    }

    public Integer getPlanNum()
    {
        return planNum;
    }
    public void setCreateUser(Integer createUser)
    {
        this.createUser = createUser;
    }

    public Integer getCreateUser()
    {
        return createUser;
    }
}
