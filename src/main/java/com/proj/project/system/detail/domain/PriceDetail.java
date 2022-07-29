package com.proj.project.system.detail.domain;

import java.math.BigDecimal;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 奖励分配对象 t_price_detail
 * 
 * @author admin
 * @date 2021-04-21
 */
public class PriceDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 工号 */
    @Excel(name = "工号")
    private Long userId;

    /** 奖金 */
    @Excel(name = "奖金")
    private BigDecimal priceAmount;

    /** 奖励类别 */
    private String priceType;
    @Excel(name = "奖励类别")
    private String priceTypeName;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projName;
    private Long projId;
    private Integer projType;

    public String getPriceTypeName() {
        return priceTypeName;
    }

    public void setPriceTypeName(String priceTypeName) {
        this.priceTypeName = priceTypeName;
    }

    public Integer getProjType() {
        return projType;
    }

    public void setProjType(Integer projType) {
        this.projType = projType;
    }

    public Long getProjId() {
        return projId;
    }

    public void setProjId(Long projId) {
        this.projId = projId;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
    public void setPriceType(String priceType)
    {
        this.priceType = priceType;
    }

    public String getPriceType()
    {
        return priceType;
    }
    public void setProjName(String projName)
    {
        this.projName = projName;
    }

    public String getProjName()
    {
        return projName;
    }
}
