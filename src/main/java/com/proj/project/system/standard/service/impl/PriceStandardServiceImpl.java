package com.proj.project.system.standard.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.standard.mapper.PriceStandardMapper;
import com.proj.project.system.standard.domain.PriceStandard;
import com.proj.project.system.standard.service.IPriceStandardService;
import com.proj.common.utils.text.Convert;

/**
 * 奖惩类型Service业务层处理
 * 
 * @author admin
 * @date 2021-04-19
 */
@Service
public class PriceStandardServiceImpl implements IPriceStandardService 
{
    @Autowired
    private PriceStandardMapper priceStandardMapper;

    /**
     * 查询奖惩类型
     * 
     * @param id 奖惩类型ID
     * @return 奖惩类型
     */
    @Override
    public PriceStandard selectPriceStandardById(Long id)
    {
        return priceStandardMapper.selectPriceStandardById(id);
    }

    /**
     * 查询奖惩类型列表
     * 
     * @param priceStandard 奖惩类型
     * @return 奖惩类型
     */
    @Override
    public List<PriceStandard> selectPriceStandardList(PriceStandard priceStandard)
    {
        return priceStandardMapper.selectPriceStandardList(priceStandard);
    }

    /**
     * 新增奖惩类型
     * 
     * @param priceStandard 奖惩类型
     * @return 结果
     */
    @Override
    public int insertPriceStandard(PriceStandard priceStandard)
    {
        return priceStandardMapper.insertPriceStandard(priceStandard);
    }

    /**
     * 修改奖惩类型
     * 
     * @param priceStandard 奖惩类型
     * @return 结果
     */
    @Override
    public int updatePriceStandard(PriceStandard priceStandard)
    {
        return priceStandardMapper.updatePriceStandard(priceStandard);
    }

    /**
     * 删除奖惩类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePriceStandardByIds(String ids)
    {
        return priceStandardMapper.deletePriceStandardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除奖惩类型信息
     * 
     * @param id 奖惩类型ID
     * @return 结果
     */
    @Override
    public int deletePriceStandardById(Long id)
    {
        return priceStandardMapper.deletePriceStandardById(id);
    }
}
