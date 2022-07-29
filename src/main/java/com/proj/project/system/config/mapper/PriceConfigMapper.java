package com.proj.project.system.config.mapper;

import java.util.List;
import com.proj.project.system.config.domain.PriceConfig;

/**
 * 奖励参数Mapper接口
 * 
 * @author admin
 * @date 2021-04-19
 */
public interface PriceConfigMapper 
{
    /**
     * 查询奖励参数
     * 
     * @param id 奖励参数ID
     * @return 奖励参数
     */
    public PriceConfig selectPriceConfigById(Long id);

    /**
     * 查询奖励参数列表
     * 
     * @param priceConfig 奖励参数
     * @return 奖励参数集合
     */
    public List<PriceConfig> selectPriceConfigList(PriceConfig priceConfig);

    /**
     * 新增奖励参数
     * 
     * @param priceConfig 奖励参数
     * @return 结果
     */
    public int insertPriceConfig(PriceConfig priceConfig);

    /**
     * 修改奖励参数
     * 
     * @param priceConfig 奖励参数
     * @return 结果
     */
    public int updatePriceConfig(PriceConfig priceConfig);

    /**
     * 删除奖励参数
     * 
     * @param id 奖励参数ID
     * @return 结果
     */
    public int deletePriceConfigById(Long id);

    /**
     * 批量删除奖励参数
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePriceConfigByIds(String[] ids);
}
