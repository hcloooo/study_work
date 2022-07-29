package com.proj.project.system.book.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 学术著作业绩奖励对象 t_perf_rate_book
 * 
 * @author admin
 * @date 2021-04-20
 */
public class PerfRateBook extends BaseEntity
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

    /** 著作名称 */
    @Excel(name = "著作名称")
    private String bookName;

    /** 出版时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出版时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishDate;

    /** 出版社 */
    @Excel(name = "出版社")
    private String press;

    /** 出版社ISBN号 */
    @Excel(name = "出版社ISBN号")
    private String edition;

    /** 著作类别 */
    @Excel(name = "著作类别")
    private String bookType;

    /** 执笔字数 */
    @Excel(name = "执笔字数")
    private Integer penNums;

    /** 奖励金额 */
    @Excel(name = "奖励金额")
    private BigDecimal priceAmount;
    private String projName;

    public String getProjName() {
        return this.bookName;
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
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getBookName()
    {
        return bookName;
    }
    public void setPublishDate(Date publishDate)
    {
        this.publishDate = publishDate;
    }

    public Date getPublishDate()
    {
        return publishDate;
    }
    public void setPress(String press)
    {
        this.press = press;
    }

    public String getPress()
    {
        return press;
    }
    public void setEdition(String edition)
    {
        this.edition = edition;
    }

    public String getEdition()
    {
        return edition;
    }
    public void setBookType(String bookType)
    {
        this.bookType = bookType;
    }

    public String getBookType()
    {
        return bookType;
    }
    public void setPenNums(Integer penNums)
    {
        this.penNums = penNums;
    }

    public Integer getPenNums()
    {
        return penNums;
    }
    public void setPriceAmount(BigDecimal priceAmount)
    {
        this.priceAmount = priceAmount;
    }

    public BigDecimal getPriceAmount()
    {
        return priceAmount;
    }
}
