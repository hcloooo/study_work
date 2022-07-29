package com.proj.project.system.config.service.impl;

import java.util.List;

import com.proj.common.utils.security.ShiroUtils;
import com.proj.project.system.practice.domain.Practice;
import com.proj.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.config.mapper.PriceConfigMapper;
import com.proj.project.system.config.domain.PriceConfig;
import com.proj.project.system.config.service.IPriceConfigService;
import com.proj.common.utils.text.Convert;

/**
 * 奖励参数Service业务层处理
 * 
 * @author admin
 * @date 2021-04-19
 */
@Service
public class PriceConfigServiceImpl implements IPriceConfigService 
{
    @Autowired
    private PriceConfigMapper priceConfigMapper;

    /**
     * 查询奖励参数
     * 
     * @param id 奖励参数ID
     * @return 奖励参数
     */
    @Override
    public PriceConfig selectPriceConfigById(Long id)
    {
        return priceConfigMapper.selectPriceConfigById(id);
    }

    /**
     * 查询奖励参数列表
     * 
     * @param priceConfig 奖励参数
     * @return 奖励参数
     */
    @Override
    public List<PriceConfig> selectPriceConfigList(PriceConfig priceConfig)
    {
        return priceConfigMapper.selectPriceConfigList(priceConfig);
    }

    /**
     * 新增奖励参数
     * 
     * @param priceConfig 奖励参数
     * @return 结果
     */
    @Override
    public int insertPriceConfig(PriceConfig priceConfig)
    {
        return priceConfigMapper.insertPriceConfig(priceConfig);
    }

    /**
     * 修改奖励参数
     * 
     * @param priceConfig 奖励参数
     * @return 结果
     */
    @Override
    public int updatePriceConfig(PriceConfig priceConfig)
    {
        return priceConfigMapper.updatePriceConfig(priceConfig);
    }

    /**
     * 删除奖励参数对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePriceConfigByIds(String ids)
    {
        return priceConfigMapper.deletePriceConfigByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除奖励参数信息
     * 
     * @param id 奖励参数ID
     * @return 结果
     */
    @Override
    public int deletePriceConfigById(Long id)
    {
        return priceConfigMapper.deletePriceConfigById(id);
    }

    @Override
    public int importList(List<PriceConfig> list, boolean updateSupport) {
        int rows = 1;
        for (PriceConfig config : list) {
            rows += priceConfigMapper.insertPriceConfig(config);
        }
        return rows;
    }
}
