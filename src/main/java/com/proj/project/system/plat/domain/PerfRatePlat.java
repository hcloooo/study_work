package com.proj.project.system.plat.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 平台业绩奖励对象 t_perf_rate_plat
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRatePlat extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private String organizer;

    /** 立项时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "立项时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date projTime;

    /** 院系 */
    @Excel(name = "院系")
    private Long deptId;
    private String deptName;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long userId;

    /** 立项部门 */
    @Excel(name = "立项部门")
    private String projDept;

    /** 拟奖励额 */
    @Excel(name = "拟奖励额")
    private BigDecimal priceAmount;

    private String projName;

    public String getProjName() {
        return this.organizer;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setOrganizer(String organizer)
    {
        this.organizer = organizer;
    }

    public String getOrganizer()
    {
        return organizer;
    }
    public void setProjTime(Date projTime)
    {
        this.projTime = projTime;
    }

    public Date getProjTime()
    {
        return projTime;
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
    public void setProjDept(String projDept)
    {
        this.projDept = projDept;
    }

    public String getProjDept()
    {
        return projDept;
    }

    public BigDecimal getPriceAmount() {
        return priceAmount;
    }

    public void setPriceAmount(BigDecimal priceAmount) {
        this.priceAmount = priceAmount;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
