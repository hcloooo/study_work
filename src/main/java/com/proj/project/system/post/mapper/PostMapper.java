package com.proj.project.system.post.mapper;

import java.util.List;
import com.proj.project.system.post.domain.Post;

/**
 * 职称信息 数据层
 * 
 * @author admin
 */
public interface PostMapper
{
    /**
     * 查询职称数据集合
     * 
     * @param post 职称信息
     * @return 职称数据集合
     */
    public List<Post> selectPostList(Post post);

    /**
     * 查询所有职称
     * 
     * @return 职称列表
     */
    public List<Post> selectPostAll();

    /**
     * 根据用户ID查询职称
     * 
     * @param userId 用户ID
     * @return 职称列表
     */
    public List<Post> selectPostsByUserId(Long userId);

    /**
     * 通过职称ID查询职称信息
     * 
     * @param postId 职称ID
     * @return 角色对象信息
     */
    public Post selectPostById(Long postId);

    /**
     * 批量删除职称信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePostByIds(Long[] ids);

    /**
     * 修改职称信息
     * 
     * @param post 职称信息
     * @return 结果
     */
    public int updatePost(Post post);

    /**
     * 新增职称信息
     * 
     * @param post 职称信息
     * @return 结果
     */
    public int insertPost(Post post);

    /**
     * 校验职称名称
     * 
     * @param postName 职称名称
     * @return 结果
     */
    public Post checkPostNameUnique(String postName);

    /**
     * 校验职称编码
     * 
     * @param postCode 职称编码
     * @return 结果
     */
    public Post checkPostCodeUnique(String postCode);
}
