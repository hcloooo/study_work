package com.proj.project.system.practice.domain;

import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 实践教学工作对象 t_practice
 * 
 * @author admin
 * @date 2021-04-15
 */
public class Practice extends BaseEntity
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

    /** 指导老师 */
    @Excel(name = "指导老师")
    private String userName;

    /** 上课班级 */
    @Excel(name = "上课班级")
    private String className;

    /** 班级人数 */
    @Excel(name = "班级人数")
    private Integer classPerson;

    /** 学时 */
    @Excel(name = "学时")
    private Integer planNum;

    /** 系数 */
    @Excel(name = "系数")
    private Integer groupNum;

    /** $column.columnComment */
//    @Excel(name = "系数")
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
    public void setPlanNum(Integer planNum)
    {
        this.planNum = planNum;
    }

    public Integer getPlanNum()
    {
        return planNum;
    }
    public void setGroupNum(Integer groupNum)
    {
        this.groupNum = groupNum;
    }

    public Integer getGroupNum()
    {
        return groupNum;
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
