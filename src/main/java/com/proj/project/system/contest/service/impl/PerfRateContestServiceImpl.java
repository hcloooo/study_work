package com.proj.project.system.contest.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.book.domain.PerfRateBook;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.contest.mapper.PerfRateContestMapper;
import com.proj.project.system.contest.domain.PerfRateContest;
import com.proj.project.system.contest.service.IPerfRateContestService;
import com.proj.common.utils.text.Convert;

/**
 * 教学-竞赛业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateContestServiceImpl implements IPerfRateContestService 
{
    @Autowired
    private PerfRateContestMapper perfRateContestMapper;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询教学-竞赛业绩奖励
     * 
     * @param id 教学-竞赛业绩奖励ID
     * @return 教学-竞赛业绩奖励
     */
    @Override
    public PerfRateContest selectPerfRateContestById(Long id)
    {
        return perfRateContestMapper.selectPerfRateContestById(id);
    }

    /**
     * 查询教学-竞赛业绩奖励列表
     * 
     * @param perfRateContest 教学-竞赛业绩奖励
     * @return 教学-竞赛业绩奖励
     */
    @Override
    public List<PerfRateContest> selectPerfRateContestList(PerfRateContest perfRateContest)
    {
        return perfRateContestMapper.selectPerfRateContestList(perfRateContest);
    }

    /**
     * 新增教学-竞赛业绩奖励
     * 
     * @param perfRateContest 教学-竞赛业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateContest(PerfRateContest perfRateContest)
    {
        perfRateContest.setCreateTime(DateUtils.getNowDate());
        return perfRateContestMapper.insertPerfRateContest(perfRateContest);
    }

    /**
     * 修改教学-竞赛业绩奖励
     * 
     * @param perfRateContest 教学-竞赛业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateContest(PerfRateContest perfRateContest)
    {
        return perfRateContestMapper.updatePerfRateContest(perfRateContest);
    }

    /**
     * 删除教学-竞赛业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateContestByIds(String ids)
    {
        return perfRateContestMapper.deletePerfRateContestByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除教学-竞赛业绩奖励信息
     * 
     * @param id 教学-竞赛业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateContestById(Long id)
    {
        return perfRateContestMapper.deletePerfRateContestById(id);
    }
    @Override
    public int importList(List<PerfRateContest> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateContest item : list) {
            Dept dept = new Dept();
            dept.setDeptName(item.getDeptName());
            dept.setDelFlag("0");
            dept.setStatus("0");
            List<Dept> depts = deptService.selectDeptList(dept);
            if(depts.size() > 0){
                item.setDeptId(depts.get(0).getDeptId());
                rows += perfRateContestMapper.insertPerfRateContest(item);
            }
        }
        return rows;
    }
}
