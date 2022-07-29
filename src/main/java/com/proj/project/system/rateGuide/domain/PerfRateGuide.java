package com.proj.project.system.rateGuide.domain;

import java.math.BigDecimal;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 教科研业绩及额定对象 t_perf_rate_guide
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateGuide extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 工号 */
    @Excel(name = "工号")
    private String userNo;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 教科研额定工作量 */
    @Excel(name = "教科研额定工作量")
    private BigDecimal guideWork;

    /** 教学额定工作量 */
    @Excel(name = "教学额定工作量")
    private BigDecimal techWork;

    /** 教科研业绩点合计 */
    @Excel(name = "教科研业绩点合计")
    private BigDecimal guideTotal;

    /** 教学业绩点合计 */
    @Excel(name = "教学业绩点合计")
    private BigDecimal techTotal;

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
    public void setGuideWork(BigDecimal guideWork)
    {
        this.guideWork = guideWork;
    }

    public BigDecimal getGuideWork()
    {
        return guideWork;
    }
    public void setTechWork(BigDecimal techWork)
    {
        this.techWork = techWork;
    }

    public BigDecimal getTechWork()
    {
        return techWork;
    }
    public void setGuideTotal(BigDecimal guideTotal)
    {
        this.guideTotal = guideTotal;
    }

    public BigDecimal getGuideTotal()
    {
        return guideTotal;
    }
    public void setTechTotal(BigDecimal techTotal)
    {
        this.techTotal = techTotal;
    }

    public BigDecimal getTechTotal()
    {
        return techTotal;
    }
}
