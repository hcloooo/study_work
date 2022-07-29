package com.proj.project.system.textbook.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 教学-教材业绩奖励对象 t_perf_rate_textbook
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateTextbook extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 院系 */
    @Excel(name = "院系")
    private Long deptId;
    private String deptName;

    /** 姓名 */
    @Excel(name = "姓名")
    private Long userId;

    /** 教材名称 */
    @Excel(name = "教材名称")
    private String textbookName;

    /** 出版社 */
    @Excel(name = "出版社")
    private String press;

    /** 参编情况 */
    @Excel(name = "参编情况")
    private String descr;

    /** 版次 */
    @Excel(name = "版次")
    private String edition;

    /** 出版时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出版时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishDate;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal priceAmount;

    /** 发文单位 */
    @Excel(name = "发文单位")
    private String publishUnit;

    /** 奖励证书 */
    @Excel(name = "奖励证书")
    private String priceCert;

    /** 公章 */
    @Excel(name = "公章")
    private String seal;
    private String projName;

    public String getProjName() {
        return this.textbookName;
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
    public void setTextbookName(String textbookName)
    {
        this.textbookName = textbookName;
    }

    public String getTextbookName()
    {
        return textbookName;
    }
    public void setPress(String press)
    {
        this.press = press;
    }

    public String getPress()
    {
        return press;
    }
    public void setDescr(String descr)
    {
        this.descr = descr;
    }

    public String getDescr()
    {
        return descr;
    }
    public void setEdition(String edition)
    {
        this.edition = edition;
    }

    public String getEdition()
    {
        return edition;
    }
    public void setPublishDate(Date publishDate)
    {
        this.publishDate = publishDate;
    }

    public Date getPublishDate()
    {
        return publishDate;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
    public void setPublishUnit(String publishUnit)
    {
        this.publishUnit = publishUnit;
    }

    public String getPublishUnit()
    {
        return publishUnit;
    }
    public void setPriceCert(String priceCert)
    {
        this.priceCert = priceCert;
    }

    public String getPriceCert()
    {
        return priceCert;
    }
    public void setSeal(String seal)
    {
        this.seal = seal;
    }

    public String getSeal()
    {
        return seal;
    }
}
