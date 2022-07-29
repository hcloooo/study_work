package com.proj.project.system.detail.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.config.service.IPriceConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.detail.mapper.PriceDetailMapper;
import com.proj.project.system.detail.domain.PriceDetail;
import com.proj.project.system.detail.service.IPriceDetailService;
import com.proj.common.utils.text.Convert;

/**
 * 奖励分配Service业务层处理
 * 
 * @author admin
 * @date 2021-04-21
 */
@Service
public class PriceDetailServiceImpl implements IPriceDetailService 
{
    @Autowired
    private PriceDetailMapper priceDetailMapper;
    @Autowired
    private IPriceConfigService priceConfigService;

    /**
     * 查询奖励分配
     * 
     * @param id 奖励分配ID
     * @return 奖励分配
     */
    @Override
    public PriceDetail selectPriceDetailById(Long id)
    {
        PriceDetail priceDetail = priceDetailMapper.selectPriceDetailById(id);
        priceDetail.setPriceTypeName(priceConfigService.selectPriceConfigById(Long.valueOf(priceDetail.getPriceType())).getSchoolType());
        return priceDetail;
    }

    /**
     * 查询奖励分配列表
     * 
     * @param priceDetail 奖励分配
     * @return 奖励分配
     */
    @Override
    public List<PriceDetail> selectPriceDetailList(PriceDetail priceDetail)
    {
        List<PriceDetail> priceDetails = priceDetailMapper.selectPriceDetailList(priceDetail);
        for (PriceDetail detail : priceDetails) {
            detail.setPriceTypeName(priceConfigService.selectPriceConfigById(Long.valueOf(detail.getPriceType())).getSchoolType());
        }
        return priceDetails;
    }

    /**
     * 新增奖励分配
     * 
     * @param priceDetail 奖励分配
     * @return 结果
     */
    @Override
    public int insertPriceDetail(PriceDetail priceDetail)
    {
        priceDetail.setCreateTime(DateUtils.getNowDate());
        return priceDetailMapper.insertPriceDetail(priceDetail);
    }

    /**
     * 修改奖励分配
     * 
     * @param priceDetail 奖励分配
     * @return 结果
     */
    @Override
    public int updatePriceDetail(PriceDetail priceDetail)
    {
        return priceDetailMapper.updatePriceDetail(priceDetail);
    }

    /**
     * 删除奖励分配对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePriceDetailByIds(String ids)
    {
        return priceDetailMapper.deletePriceDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除奖励分配信息
     * 
     * @param id 奖励分配ID
     * @return 结果
     */
    @Override
    public int deletePriceDetailById(Long id)
    {
        return priceDetailMapper.deletePriceDetailById(id);
    }
}
