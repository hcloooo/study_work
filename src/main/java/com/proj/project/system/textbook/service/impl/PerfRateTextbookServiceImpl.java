package com.proj.project.system.textbook.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import com.proj.project.system.plat.domain.PerfRatePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.textbook.mapper.PerfRateTextbookMapper;
import com.proj.project.system.textbook.domain.PerfRateTextbook;
import com.proj.project.system.textbook.service.IPerfRateTextbookService;
import com.proj.common.utils.text.Convert;

/**
 * 教学-教材业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateTextbookServiceImpl implements IPerfRateTextbookService 
{
    @Autowired
    private PerfRateTextbookMapper perfRateTextbookMapper;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询教学-教材业绩奖励
     * 
     * @param id 教学-教材业绩奖励ID
     * @return 教学-教材业绩奖励
     */
    @Override
    public PerfRateTextbook selectPerfRateTextbookById(Long id)
    {
        return perfRateTextbookMapper.selectPerfRateTextbookById(id);
    }

    /**
     * 查询教学-教材业绩奖励列表
     * 
     * @param perfRateTextbook 教学-教材业绩奖励
     * @return 教学-教材业绩奖励
     */
    @Override
    public List<PerfRateTextbook> selectPerfRateTextbookList(PerfRateTextbook perfRateTextbook)
    {
        return perfRateTextbookMapper.selectPerfRateTextbookList(perfRateTextbook);
    }

    /**
     * 新增教学-教材业绩奖励
     * 
     * @param perfRateTextbook 教学-教材业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateTextbook(PerfRateTextbook perfRateTextbook)
    {
        perfRateTextbook.setCreateTime(DateUtils.getNowDate());
        return perfRateTextbookMapper.insertPerfRateTextbook(perfRateTextbook);
    }

    /**
     * 修改教学-教材业绩奖励
     * 
     * @param perfRateTextbook 教学-教材业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateTextbook(PerfRateTextbook perfRateTextbook)
    {
        return perfRateTextbookMapper.updatePerfRateTextbook(perfRateTextbook);
    }

    /**
     * 删除教学-教材业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateTextbookByIds(String ids)
    {
        return perfRateTextbookMapper.deletePerfRateTextbookByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教学-教材业绩奖励信息
     * 
     * @param id 教学-教材业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateTextbookById(Long id)
    {
        return perfRateTextbookMapper.deletePerfRateTextbookById(id);
    }

    @Override
    public int importList(List<PerfRateTextbook> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateTextbook item : list) {
            Dept dept = new Dept();
            dept.setDeptName(item.getDeptName());
            dept.setDelFlag("0");
            dept.setStatus("0");
            List<Dept> depts = deptService.selectDeptList(dept);
            if(depts.size() > 0){
                item.setDeptId(depts.get(0).getDeptId());
                rows += perfRateTextbookMapper.insertPerfRateTextbook(item);
            }
        }
        return rows;
    }
}
