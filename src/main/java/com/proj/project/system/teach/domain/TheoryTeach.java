package com.proj.project.system.teach.domain;

import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 理论教学工作对象 t_theory_teach
 * 
 * @author admin
 * @date 2021-04-14
 */
public class TheoryTeach extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 课程号 */
    @Excel(name = "课程号")
    private String courseNo;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String courseName;

    /** 工号 */
    @Excel(name = "工号")
    private String userNo;

    /** 任课老师 */
    @Excel(name = "任课老师")
    private String userName;

    /** 上课班级 */
    @Excel(name = "上课班级")
    private String className;

    /** 实际班级人数 */
    @Excel(name = "实际班级人数")
    private Integer classPerson;

    /** 课程大类 */
    @Excel(name = "课程大类")
    private String classTopType;

    /** 课程小类 */
    @Excel(name = "课程小类")
    private String classType;

    /** 优质课程使用类型 */
    @Excel(name = "优质课程使用类型")
    private String goodClassType;

    /** 优质课程使用次数 */
    @Excel(name = "优质课程使用次数")
    private Integer goodClassTypeNum;

    /** 计划学时 */
    @Excel(name = "计划学时")
    private Integer planNum;

    /** 教研室主任加分 */
    @Excel(name = "教研室主任加分")
    private Long addScore;

    /** $column.columnComment */
//    @Excel(name = "教研室主任加分")
    private Integer createUser;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setCourseNo(String courseNo)
    {
        this.courseNo = courseNo;
    }

    public String getCourseNo()
    {
        return courseNo;
    }
    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public String getCourseName()
    {
        return courseName;
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
    public void setClassPerson(Integer classPerson)
    {
        this.classPerson = classPerson;
    }

    public Integer getClassPerson()
    {
        return classPerson;
    }
    public void setClassTopType(String classTopType)
    {
        this.classTopType = classTopType;
    }

    public String getClassTopType()
    {
        return classTopType;
    }
    public void setClassType(String classType)
    {
        this.classType = classType;
    }

    public String getClassType()
    {
        return classType;
    }
    public void setGoodClassType(String goodClassType)
    {
        this.goodClassType = goodClassType;
    }

    public String getGoodClassType()
    {
        return goodClassType;
    }
    public void setGoodClassTypeNum(Integer goodClassTypeNum)
    {
        this.goodClassTypeNum = goodClassTypeNum;
    }

    public Integer getGoodClassTypeNum()
    {
        return goodClassTypeNum;
    }
    public void setPlanNum(Integer planNum)
    {
        this.planNum = planNum;
    }

    public Integer getPlanNum()
    {
        return planNum;
    }
    public void setAddScore(Long addScore)
    {
        this.addScore = addScore;
    }

    public Long getAddScore()
    {
        return addScore;
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
