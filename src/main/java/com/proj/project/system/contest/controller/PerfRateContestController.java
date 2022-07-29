package com.proj.project.system.contest.controller;

import java.util.List;

import com.proj.project.system.plat.domain.PerfRatePlat;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.proj.framework.aspectj.lang.annotation.Log;
import com.proj.framework.aspectj.lang.enums.BusinessType;
import com.proj.project.system.contest.domain.PerfRateContest;
import com.proj.project.system.contest.service.IPerfRateContestService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教学-竞赛业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/contest")
public class PerfRateContestController extends BaseController
{
    private String prefix = "system/contest";

    @Autowired
    private IPerfRateContestService perfRateContestService;

    @RequiresPermissions("system:contest:view")
    @GetMapping()
    public String contest()
    {
        return prefix + "/contest";
    }

    /**
     * 查询教学-竞赛业绩奖励列表
     */
    @RequiresPermissions("system:contest:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateContest perfRateContest)
    {
        startPage();
        List<PerfRateContest> list = perfRateContestService.selectPerfRateContestList(perfRateContest);
        return getDataTable(list);
    }

    /**
     * 导出教学-竞赛业绩奖励列表
     */
    @RequiresPermissions("system:contest:export")
    @Log(title = "教学-竞赛业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateContest perfRateContest)
    {
        List<PerfRateContest> list = perfRateContestService.selectPerfRateContestList(perfRateContest);
        ExcelUtil<PerfRateContest> util = new ExcelUtil<PerfRateContest>(PerfRateContest.class);
        return util.exportExcel(list, "教学-竞赛业绩奖励数据");
    }
    /**
     * 导入教学-竞赛业绩奖励模板
     */
    @RequiresPermissions("system:plat:export")
    @Log(title = "教学-竞赛业绩奖励", businessType = BusinessType.IMPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRateContest> util = new ExcelUtil<>(PerfRateContest.class);
        return util.importTemplateExcel("教学-竞赛业绩奖励");
    }
    /**
     * 导入教学-竞赛业绩奖励
     */
    @RequiresPermissions("system:plat:export")
    @Log(title = "教学-竞赛业绩奖励", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRateContest> util = new ExcelUtil<>(PerfRateContest.class);
        List<PerfRateContest> list = util.importExcel(file.getInputStream());
        int message = perfRateContestService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增教学-竞赛业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教学-竞赛业绩奖励
     */
    @RequiresPermissions("system:contest:add")
    @Log(title = "教学-竞赛业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateContest perfRateContest)
    {
        return toAjax(perfRateContestService.insertPerfRateContest(perfRateContest));
    }

    /**
     * 修改教学-竞赛业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateContest perfRateContest = perfRateContestService.selectPerfRateContestById(id);
        mmap.put("perfRateContest", perfRateContest);
        return prefix + "/edit";
    }

    /**
     * 修改保存教学-竞赛业绩奖励
     */
    @RequiresPermissions("system:contest:edit")
    @Log(title = "教学-竞赛业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateContest perfRateContest)
    {
        return toAjax(perfRateContestService.updatePerfRateContest(perfRateContest));
    }

    /**
     * 删除教学-竞赛业绩奖励
     */
    @RequiresPermissions("system:contest:remove")
    @Log(title = "教学-竞赛业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateContestService.deletePerfRateContestByIds(ids));
    }
}
