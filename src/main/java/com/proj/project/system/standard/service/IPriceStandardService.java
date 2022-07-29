package com.proj.project.system.standard.service;

import java.util.List;
import com.proj.project.system.standard.domain.PriceStandard;

/**
 * 奖惩类型Service接口
 * 
 * @author admin
 * @date 2021-04-19
 */
public interface IPriceStandardService 
{
    /**
     * 查询奖惩类型
     * 
     * @param id 奖惩类型ID
     * @return 奖惩类型
     */
    public PriceStandard selectPriceStandardById(Long id);

    /**
     * 查询奖惩类型列表
     * 
     * @param priceStandard 奖惩类型
     * @return 奖惩类型集合
     */
    public List<PriceStandard> selectPriceStandardList(PriceStandard priceStandard);

    /**
     * 新增奖惩类型
     * 
     * @param priceStandard 奖惩类型
     * @return 结果
     */
    public int insertPriceStandard(PriceStandard priceStandard);

    /**
     * 修改奖惩类型
     * 
     * @param priceStandard 奖惩类型
     * @return 结果
     */
    public int updatePriceStandard(PriceStandard priceStandard);

    /**
     * 批量删除奖惩类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePriceStandardByIds(String ids);

    /**
     * 删除奖惩类型信息
     * 
     * @param id 奖惩类型ID
     * @return 结果
     */
    public int deletePriceStandardById(Long id);
}
