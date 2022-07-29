package com.proj.project.system.skill.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.skill.mapper.PerfRateSkillMapper;
import com.proj.project.system.skill.domain.PerfRateSkill;
import com.proj.project.system.skill.service.IPerfRateSkillService;
import com.proj.common.utils.text.Convert;

/**
 * 学术业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateSkillServiceImpl implements IPerfRateSkillService 
{
    @Autowired
    private PerfRateSkillMapper perfRateSkillMapper;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询学术业绩奖励
     * 
     * @param id 学术业绩奖励ID
     * @return 学术业绩奖励
     */
    @Override
    public PerfRateSkill selectPerfRateSkillById(Long id)
    {
        return perfRateSkillMapper.selectPerfRateSkillById(id);
    }

    /**
     * 查询学术业绩奖励列表
     * 
     * @param perfRateSkill 学术业绩奖励
     * @return 学术业绩奖励
     */
    @Override
    public List<PerfRateSkill> selectPerfRateSkillList(PerfRateSkill perfRateSkill)
    {
        return perfRateSkillMapper.selectPerfRateSkillList(perfRateSkill);
    }

    /**
     * 新增学术业绩奖励
     * 
     * @param perfRateSkill 学术业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateSkill(PerfRateSkill perfRateSkill)
    {
        perfRateSkill.setCreateTime(DateUtils.getNowDate());
        return perfRateSkillMapper.insertPerfRateSkill(perfRateSkill);
    }

    /**
     * 修改学术业绩奖励
     * 
     * @param perfRateSkill 学术业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateSkill(PerfRateSkill perfRateSkill)
    {
        return perfRateSkillMapper.updatePerfRateSkill(perfRateSkill);
    }

    /**
     * 删除学术业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateSkillByIds(String ids)
    {
        return perfRateSkillMapper.deletePerfRateSkillByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学术业绩奖励信息
     * 
     * @param id 学术业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateSkillById(Long id)
    {
        return perfRateSkillMapper.deletePerfRateSkillById(id);
    }

    @Override
    public int importList(List<PerfRateSkill> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateSkill perfRateSkill : list) {
            Dept dept = new Dept();
            dept.setDeptName(perfRateSkill.getDeptName());
            dept.setDelFlag("0");
            dept.setStatus("0");
            List<Dept> depts = deptService.selectDeptList(dept);
            if(depts.size() > 0){
                perfRateSkill.setDeptId(depts.get(0).getDeptId());
                rows += perfRateSkillMapper.insertPerfRateSkill(perfRateSkill);
            }
        }
        return rows;
    }
}
