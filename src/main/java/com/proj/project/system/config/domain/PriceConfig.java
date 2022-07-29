package com.proj.project.system.config.domain;

import java.math.BigDecimal;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 奖励参数对象 t_price_config
 * 
 * @author admin
 * @date 2021-04-19
 */
public class PriceConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 校级奖励类型 */
    @Excel(name = "校级奖励类型")
    private String schoolType;

    /** 留存比例 */
    @Excel(name = "留存比例")
    private BigDecimal rate;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setSchoolType(String schoolType)
    {
        this.schoolType = schoolType;
    }

    public String getSchoolType()
    {
        return schoolType;
    }
    public void setRate(BigDecimal rate)
    {
        this.rate = rate;
    }

    public BigDecimal getRate()
    {
        return rate;
    }
}
