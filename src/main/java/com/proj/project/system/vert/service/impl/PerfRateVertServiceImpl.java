package com.proj.project.system.vert.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import com.proj.project.system.plat.domain.PerfRatePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.vert.mapper.PerfRateVertMapper;
import com.proj.project.system.vert.domain.PerfRateVert;
import com.proj.project.system.vert.service.IPerfRateVertService;
import com.proj.common.utils.text.Convert;

/**
 * 纵横向业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateVertServiceImpl implements IPerfRateVertService 
{
    @Autowired
    private PerfRateVertMapper perfRateVertMapper;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询纵横向业绩奖励
     * 
     * @param id 纵横向业绩奖励ID
     * @return 纵横向业绩奖励
     */
    @Override
    public PerfRateVert selectPerfRateVertById(Long id)
    {
        return perfRateVertMapper.selectPerfRateVertById(id);
    }

    /**
     * 查询纵横向业绩奖励列表
     * 
     * @param perfRateVert 纵横向业绩奖励
     * @return 纵横向业绩奖励
     */
    @Override
    public List<PerfRateVert> selectPerfRateVertList(PerfRateVert perfRateVert)
    {
        return perfRateVertMapper.selectPerfRateVertList(perfRateVert);
    }

    /**
     * 新增纵横向业绩奖励
     * 
     * @param perfRateVert 纵横向业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateVert(PerfRateVert perfRateVert)
    {
        perfRateVert.setCreateTime(DateUtils.getNowDate());
        return perfRateVertMapper.insertPerfRateVert(perfRateVert);
    }

    /**
     * 修改纵横向业绩奖励
     * 
     * @param perfRateVert 纵横向业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateVert(PerfRateVert perfRateVert)
    {
        return perfRateVertMapper.updatePerfRateVert(perfRateVert);
    }

    /**
     * 删除纵横向业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateVertByIds(String ids)
    {
        return perfRateVertMapper.deletePerfRateVertByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除纵横向业绩奖励信息
     * 
     * @param id 纵横向业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateVertById(Long id)
    {
        return perfRateVertMapper.deletePerfRateVertById(id);
    }

    @Override
    public int importList(List<PerfRateVert> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateVert item : list) {
            Dept dept = new Dept();
            dept.setDeptName(item.getDeptName());
            dept.setDelFlag("0");
            dept.setStatus("0");
            List<Dept> depts = deptService.selectDeptList(dept);
            if(depts.size() > 0){
                item.setDeptId(depts.get(0).getDeptId());
                rows += perfRateVertMapper.insertPerfRateVert(item);
            }
        }
        return rows;
    }
}
