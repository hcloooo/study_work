package com.proj.project.system.book.service.impl;

import java.util.List;
import com.proj.common.utils.DateUtils;
import com.proj.project.system.dept.domain.Dept;
import com.proj.project.system.dept.service.IDeptService;
import com.proj.project.system.plat.domain.PerfRatePlat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proj.project.system.book.mapper.PerfRateBookMapper;
import com.proj.project.system.book.domain.PerfRateBook;
import com.proj.project.system.book.service.IPerfRateBookService;
import com.proj.common.utils.text.Convert;

/**
 * 学术著作业绩奖励Service业务层处理
 * 
 * @author admin
 * @date 2021-04-20
 */
@Service
public class PerfRateBookServiceImpl implements IPerfRateBookService 
{
    @Autowired
    private PerfRateBookMapper perfRateBookMapper;
    @Autowired
    private IDeptService deptService;

    /**
     * 查询学术著作业绩奖励
     * 
     * @param id 学术著作业绩奖励ID
     * @return 学术著作业绩奖励
     */
    @Override
    public PerfRateBook selectPerfRateBookById(Long id)
    {
        return perfRateBookMapper.selectPerfRateBookById(id);
    }

    /**
     * 查询学术著作业绩奖励列表
     * 
     * @param perfRateBook 学术著作业绩奖励
     * @return 学术著作业绩奖励
     */
    @Override
    public List<PerfRateBook> selectPerfRateBookList(PerfRateBook perfRateBook)
    {
        return perfRateBookMapper.selectPerfRateBookList(perfRateBook);
    }

    /**
     * 新增学术著作业绩奖励
     * 
     * @param perfRateBook 学术著作业绩奖励
     * @return 结果
     */
    @Override
    public int insertPerfRateBook(PerfRateBook perfRateBook)
    {
        perfRateBook.setCreateTime(DateUtils.getNowDate());
        return perfRateBookMapper.insertPerfRateBook(perfRateBook);
    }

    /**
     * 修改学术著作业绩奖励
     * 
     * @param perfRateBook 学术著作业绩奖励
     * @return 结果
     */
    @Override
    public int updatePerfRateBook(PerfRateBook perfRateBook)
    {
        return perfRateBookMapper.updatePerfRateBook(perfRateBook);
    }

    /**
     * 删除学术著作业绩奖励对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePerfRateBookByIds(String ids)
    {
        return perfRateBookMapper.deletePerfRateBookByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学术著作业绩奖励信息
     * 
     * @param id 学术著作业绩奖励ID
     * @return 结果
     */
    @Override
    public int deletePerfRateBookById(Long id)
    {
        return perfRateBookMapper.deletePerfRateBookById(id);
    }


    @Override
    public int importList(List<PerfRateBook> list, boolean updateSupport) {
        int rows = 0;
        for (PerfRateBook item : list) {
            Dept dept = new Dept();
            dept.setDeptName(item.getDeptName());
            dept.setDelFlag("0");
            dept.setStatus("0");
            List<Dept> depts = deptService.selectDeptList(dept);
            if(depts.size() > 0){
                item.setDeptId(depts.get(0).getDeptId());
                rows += perfRateBookMapper.insertPerfRateBook(item);
            }
        }
        return rows;
    }
}
