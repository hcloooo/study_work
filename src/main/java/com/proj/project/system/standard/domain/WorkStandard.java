package com.proj.project.system.standard.domain;

import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 工作、业绩发放标准对象 t_work_standard
 * 
 * @author admin
 * @date 2021-04-26
 */
public class WorkStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 职称名称 */
    @Excel(name = "职称名称")
    private String workName;

    /** 教学工作量发放标准 */
    @Excel(name = "教学工作量发放标准")
    private String work;

    /** 教科研业绩点发放标准 */
    @Excel(name = "教科研业绩点发放标准")
    private String total;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setWorkName(String workName)
    {
        this.workName = workName;
    }

    public String getWorkName()
    {
        return workName;
    }
    public void setWork(String work)
    {
        this.work = work;
    }

    public String getWork()
    {
        return work;
    }
    public void setTotal(String total)
    {
        this.total = total;
    }

    public String getTotal()
    {
        return total;
    }
}
