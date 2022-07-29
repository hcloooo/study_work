package com.proj.project.system.detail.mapper;

import java.util.List;
import com.proj.project.system.detail.domain.PriceDetail;

/**
 * 奖励分配Mapper接口
 * 
 * @author admin
 * @date 2021-04-21
 */
public interface PriceDetailMapper 
{
    /**
     * 查询奖励分配
     * 
     * @param id 奖励分配ID
     * @return 奖励分配
     */
    public PriceDetail selectPriceDetailById(Long id);

    /**
     * 查询奖励分配列表
     * 
     * @param priceDetail 奖励分配
     * @return 奖励分配集合
     */
    public List<PriceDetail> selectPriceDetailList(PriceDetail priceDetail);

    /**
     * 新增奖励分配
     * 
     * @param priceDetail 奖励分配
     * @return 结果
     */
    public int insertPriceDetail(PriceDetail priceDetail);

    /**
     * 修改奖励分配
     * 
     * @param priceDetail 奖励分配
     * @return 结果
     */
    public int updatePriceDetail(PriceDetail priceDetail);

    /**
     * 删除奖励分配
     * 
     * @param id 奖励分配ID
     * @return 结果
     */
    public int deletePriceDetailById(Long id);

    /**
     * 批量删除奖励分配
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePriceDetailByIds(String[] ids);
}
