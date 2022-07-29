package com.proj.project.system.plat.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import com.proj.project.system.skill.domain.PerfRateSkill;
import com.proj.project.system.skill.mapper.PerfRateSkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.plat.mapper.PerfRatePlatMapper;
import com.proj.project.system.plat.domain.PerfRatePlat;
import com.proj.project.system.plat.service.IPerfRatePlatService;
import com.proj.common.utils.text.Convert;

/**
 * 平台业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRatePlatServiceImpl implements IPerfRatePlatService 
{
    @Autowired
    private PerfRatePlatMapper perfRatePlatMapper;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询平台业绩奖励
     * 
     * @param id 平台业绩奖励ID
     * @return 平台业绩奖励
     */
    @Override
    public PerfRatePlat selectPerfRatePlatById(Long id)
    {
        return perfRatePlatMapper.selectPerfRatePlatById(id);
    }

    /**
     * 查询平台业绩奖励列表
     * 
     * @param perfRatePlat 平台业绩奖励
     * @return 平台业绩奖励
     */
    @Override
    public List<PerfRatePlat> selectPerfRatePlatList(PerfRatePlat perfRatePlat)
    {
        return perfRatePlatMapper.selectPerfRatePlatList(perfRatePlat);
    }

    /**
     * 新增平台业绩奖励
     * 
     * @param perfRatePlat 平台业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRatePlat(PerfRatePlat perfRatePlat)
    {
        perfRatePlat.setCreateTime(DateUtils.getNowDate());
        return perfRatePlatMapper.insertPerfRatePlat(perfRatePlat);
    }

    /**
     * 修改平台业绩奖励
     * 
     * @param perfRatePlat 平台业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRatePlat(PerfRatePlat perfRatePlat)
    {
        return perfRatePlatMapper.updatePerfRatePlat(perfRatePlat);
    }

    /**
     * 删除平台业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRatePlatByIds(String ids)
    {
        return perfRatePlatMapper.deletePerfRatePlatByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除平台业绩奖励信息
     * 
     * @param id 平台业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRatePlatById(Long id)
    {
        return perfRatePlatMapper.deletePerfRatePlatById(id);
    }

    @Override
    public int importList(List<PerfRatePlat> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRatePlat item : list) {
            Dept dept = new Dept();
            dept.setDeptName(item.getDeptName());
            dept.setDelFlag("0");
            dept.setStatus("0");
            List<Dept> depts = deptService.selectDeptList(dept);
            if(depts.size() > 0){
                item.setDeptId(depts.get(0).getDeptId());
                rows += perfRatePlatMapper.insertPerfRatePlat(item);
            }
        }
        return rows;
    }
}
