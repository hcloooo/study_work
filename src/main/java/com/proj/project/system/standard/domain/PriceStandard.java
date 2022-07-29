package com.proj.project.system.standard.domain;

import java.math.BigDecimal;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 奖惩类型对象 t_price_standard
 * 
 * @author admin
 * @date 2021-04-19
 */
public class PriceStandard extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 奖惩类型 */
    @Excel(name = "奖惩类型")
    private String priceType;

    /** 奖惩标准 */
    @Excel(name = "奖惩标准")
    private BigDecimal standard;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setPriceType(String priceType)
    {
        this.priceType = priceType;
    }

    public String getPriceType()
    {
        return priceType;
    }
    public void setStandard(BigDecimal standard)
    {
        this.standard = standard;
    }

    public BigDecimal getStandard()
    {
        return standard;
    }
}
