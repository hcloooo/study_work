package com.proj.project.system.rateGuide.controller;

import java.util.List;
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
import com.proj.project.system.rateGuide.domain.PerfRateGuide;
import com.proj.project.system.rateGuide.service.IPerfRateGuideService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;

/**
 * 教科研业绩及额定Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/rateGuide")
public class PerfRateGuideController extends BaseController
{
    private String prefix = "system/rateGuide";

    @Autowired
    private IPerfRateGuideService perfRateGuideService;

    @RequiresPermissions("system:rateGuide:view")
    @GetMapping()
    public String rateGuide()
    {
        return prefix + "/rateGuide";
    }

    /**
     * 查询教科研业绩及额定列表
     */
    @RequiresPermissions("system:rateGuide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateGuide perfRateGuide)
    {
        startPage();
        List<PerfRateGuide> list = perfRateGuideService.selectPerfRateGuideList(perfRateGuide);
        return getDataTable(list);
    }

    /**
     * 导出教科研业绩及额定列表
     */
    @RequiresPermissions("system:rateGuide:export")
    @Log(title = "教科研业绩及额定", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateGuide perfRateGuide)
    {
        List<PerfRateGuide> list = perfRateGuideService.selectPerfRateGuideList(perfRateGuide);
        ExcelUtil<PerfRateGuide> util = new ExcelUtil<PerfRateGuide>(PerfRateGuide.class);
        return util.exportExcel(list, "教科研业绩及额定数据");
    }

    /**
     * 新增教科研业绩及额定
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教科研业绩及额定
     */
    @RequiresPermissions("system:rateGuide:add")
    @Log(title = "教科研业绩及额定", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateGuide perfRateGuide)
    {
        return toAjax(perfRateGuideService.insertPerfRateGuide(perfRateGuide));
    }

    /**
     * 修改教科研业绩及额定
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateGuide perfRateGuide = perfRateGuideService.selectPerfRateGuideById(id);
        mmap.put("perfRateGuide", perfRateGuide);
        return prefix + "/edit";
    }

    /**
     * 修改保存教科研业绩及额定
     */
    @RequiresPermissions("system:rateGuide:edit")
    @Log(title = "教科研业绩及额定", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateGuide perfRateGuide)
    {
        return toAjax(perfRateGuideService.updatePerfRateGuide(perfRateGuide));
    }

    /**
     * 删除教科研业绩及额定
     */
    @RequiresPermissions("system:rateGuide:remove")
    @Log(title = "教科研业绩及额定", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateGuideService.deletePerfRateGuideByIds(ids));
    }
}
