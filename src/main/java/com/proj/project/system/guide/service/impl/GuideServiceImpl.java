package com.proj.project.system.guide.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.common.utils.security.ShiroUtils;
import com.proj.project.system.practice.domain.Practice;
import com.proj.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.guide.mapper.GuideMapper;
import com.proj.project.system.guide.domain.Guide;
import com.proj.project.system.guide.service.IGuideService;
import com.proj.common.utils.text.Convert;

/**
 * 学科竞赛指导工作量Service业务层处理
 * 
 * @author admin
 * @date 2021-04-15
 */
@Service
public class GuideServiceImpl implements IGuideService 
{
    @Autowired
    private GuideMapper guideMapper;

    /**
     * 查询学科竞赛指导工作量
     * 
     * @param id 学科竞赛指导工作量ID
     * @return 学科竞赛指导工作量
     */
    @Override
    public Guide selectGuideById(Long id)
    {
        return guideMapper.selectGuideById(id);
    }

    /**
     * 查询学科竞赛指导工作量列表
     * 
     * @param guide 学科竞赛指导工作量
     * @return 学科竞赛指导工作量
     */
    @Override
    public List<Guide> selectGuideList(Guide guide)
    {
        return guideMapper.selectGuideList(guide);
    }

    /**
     * 新增学科竞赛指导工作量
     * 
     * @param guide 学科竞赛指导工作量
     * @return 结果
     */
    @Override
    public int insertGuide(Guide guide)
    {
        guide.setCreateTime(DateUtils.getNowDate());
        return guideMapper.insertGuide(guide);
    }

    /**
     * 修改学科竞赛指导工作量
     * 
     * @param guide 学科竞赛指导工作量
     * @return 结果
     */
    @Override
    public int updateGuide(Guide guide)
    {
        return guideMapper.updateGuide(guide);
    }

    /**
     * 删除学科竞赛指导工作量对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteGuideByIds(String ids)
    {
        return guideMapper.deleteGuideByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学科竞赛指导工作量信息
     * 
     * @param id 学科竞赛指导工作量ID
     * @return 结果
     */
    @Override
    public int deleteGuideById(Long id)
    {
        return guideMapper.deleteGuideById(id);
    }

    @Override
    public int importList(List<Guide> list, boolean updateSupport) {
        int rows = 1;
        User sysUser = ShiroUtils.getSysUser();
        for (Guide guide : list) {
            guide.setCreateUser(sysUser.getUserId().intValue());
            rows += guideMapper.insertGuide(guide);
        }
        return rows;
    }
}
