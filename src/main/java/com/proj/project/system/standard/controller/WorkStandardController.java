package com.proj.project.system.standard.controller;

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
import com.proj.project.system.standard.domain.WorkStandard;
import com.proj.project.system.standard.service.IWorkStandardService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;

/**
 * 工作、业绩发放标准Controller
 * 
 * @author admin
 * @date 2021-04-26
 */
@Controller
@RequestMapping("/system/work/standard")
public class WorkStandardController extends BaseController
{
    private String prefix = "system/workStandard";

    @Autowired
    private IWorkStandardService workStandardService;

    @RequiresPermissions("system:standard:view")
    @GetMapping()
    public String standard()
    {
        return prefix + "/standard";
    }

    /**
     * 查询工作、业绩发放标准列表
     */
    @RequiresPermissions("system:standard:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkStandard workStandard)
    {
        startPage();
        List<WorkStandard> list = workStandardService.selectWorkStandardList(workStandard);
        return getDataTable(list);
    }

    /**
     * 导出工作、业绩发放标准列表
     */
    @RequiresPermissions("system:standard:export")
    @Log(title = "工作、业绩发放标准", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkStandard workStandard)
    {
        List<WorkStandard> list = workStandardService.selectWorkStandardList(workStandard);
        ExcelUtil<WorkStandard> util = new ExcelUtil<WorkStandard>(WorkStandard.class);
        return util.exportExcel(list, "工作、业绩发放标准数据");
    }

    /**
     * 新增工作、业绩发放标准
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存工作、业绩发放标准
     */
    @RequiresPermissions("system:standard:add")
    @Log(title = "工作、业绩发放标准", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkStandard workStandard)
    {
        return toAjax(workStandardService.insertWorkStandard(workStandard));
    }

    /**
     * 修改工作、业绩发放标准
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WorkStandard workStandard = workStandardService.selectWorkStandardById(id);
        mmap.put("workStandard", workStandard);
        return prefix + "/edit";
    }

    /**
     * 修改保存工作、业绩发放标准
     */
    @RequiresPermissions("system:standard:edit")
    @Log(title = "工作、业绩发放标准", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkStandard workStandard)
    {
        return toAjax(workStandardService.updateWorkStandard(workStandard));
    }

    /**
     * 删除工作、业绩发放标准
     */
    @RequiresPermissions("system:standard:remove")
    @Log(title = "工作、业绩发放标准", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(workStandardService.deleteWorkStandardByIds(ids));
    }
}
