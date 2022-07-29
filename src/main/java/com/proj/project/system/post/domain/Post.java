package com.proj.project.system.post.domain;

import javax.validation.constraints.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.proj.framework.aspectj.lang.annotation.Excel;
import com.proj.framework.aspectj.lang.annotation.Excel.ColumnType;
import com.proj.framework.web.domain.BaseEntity;

/**
 * 职称表 sys_post
 * 
 * @author admin
 */
public class Post extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职称序号 */
    @Excel(name = "职称序号", cellType = ColumnType.NUMERIC)
    private Long postId;

    /** 职称编码 */
    @Excel(name = "职称编码")
    private String postCode;

    /** 职称名称 */
    @Excel(name = "职称名称")
    private String postName;

    /** 职称排序 */
    @Excel(name = "职称排序")
    private String postSort;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 用户是否存在此职称标识 默认不存在 */
    private boolean flag = false;

    public Long getPostId()
    {
        return postId;
    }

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    @NotBlank(message = "职称编码不能为空")
    @Size(min = 0, max = 64, message = "职称编码长度不能超过64个字符")
    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    @NotBlank(message = "职称名称不能为空")
    @Size(min = 0, max = 50, message = "职称名称长度不能超过50个字符")
    public String getPostName()
    {
        return postName;
    }

    public void setPostName(String postName)
    {
        this.postName = postName;
    }

    @NotBlank(message = "显示顺序不能为空")
    public String getPostSort()
    {
        return postSort;
    }

    public void setPostSort(String postSort)
    {
        this.postSort = postSort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
