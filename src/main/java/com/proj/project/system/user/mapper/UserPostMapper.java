package com.proj.project.system.user.mapper;

import java.util.List;
import com.proj.project.system.user.domain.UserPost;

/**
 * 用户与职称关联表 数据层
 * 
 * @author admin
 */
public interface UserPostMapper
{
    /**
     * 通过用户ID删除用户和职称关联
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public int deleteUserPostByUserId(Long userId);
    
    /**
     * 通过职称ID查询职称使用数量
     * 
     * @param postId 职称ID
     * @return 结果
     */
    public int countUserPostById(Long postId);
    
    /**
     * 批量删除用户和职称关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserPost(Long[] ids);

    /**
     * 批量新增用户职称信息
     * 
     * @param userPostList 用户角色列表
     * @return 结果
     */
    public int batchUserPost(List<UserPost> userPostList);
}
