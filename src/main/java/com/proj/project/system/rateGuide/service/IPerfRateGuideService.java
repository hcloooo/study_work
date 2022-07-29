package com.proj.project.system.rateGuide.service;

import java.util.List;
import com.proj.project.system.rateGuide.domain.PerfRateGuide;

/**
 * 教科研业绩及额定Service接口
 * 
 * @author admin
 * @date 2021-04-20
 */
public interface IPerfRateGuideService 
{
    /**
     * 查询教科研业绩及额定
     * 
     * @param id 教科研业绩及额定ID
     * @return 教科研业绩及额定
     */
    public PerfRateGuide selectPerfRateGuideById(Long id);

    /**
     * 查询教科研业绩及额定列表
     * 
     * @param perfRateGuide 教科研业绩及额定
     * @return 教科研业绩及额定集合
     */
    public List<PerfRateGuide> selectPerfRateGuideList(PerfRateGuide perfRateGuide);

    /**
     * 新增教科研业绩及额定
     * 
     * @param perfRateGuide 教科研业绩及额定
     * @return 结果
     */
    public int insertPerfRateGuide(PerfRateGuide perfRateGuide);

    /**
     * 修改教科研业绩及额定
     * 
     * @param perfRateGuide 教科研业绩及额定
     * @return 结果
     */
    public int updatePerfRateGuide(PerfRateGuide perfRateGuide);

    /**
     * 批量删除教科研业绩及额定
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePerfRateGuideByIds(String ids);

    /**
     * 删除教科研业绩及额定信息
     * 
     * @param id 教科研业绩及额定ID
     * @return 结果
     */
    public int deletePerfRateGuideById(Long id);
}
