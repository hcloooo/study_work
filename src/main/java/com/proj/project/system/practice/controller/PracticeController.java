package com.proj.project.system.practice.controller;

import java.util.List;

import com.proj.project.system.teach.domain.TheoryTeach;
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
import com.proj.project.system.practice.domain.Practice;
import com.proj.project.system.practice.service.IPracticeService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 实践教学工作Controller
 * 
 * @author admin
 * @date 2021-04-15
 */
@Controller
@RequestMapping("/system/practice")
public class PracticeController extends BaseController
{
    private String prefix = "system/practice";

    @Autowired
    private IPracticeService practiceService;

    @RequiresPermissions("system:practice:view")
    @GetMapping()
    public String practice()
    {
        return prefix + "/practice";
    }

    /**
     * 查询实践教学工作列表
     */
    @RequiresPermissions("system:practice:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Practice practice)
    {
        startPage();
        List<Practice> list = practiceService.selectPracticeList(practice);
        return getDataTable(list);
    }

    /**
     * 导出实践教学工作列表
     */
    @RequiresPermissions("system:practice:export")
    @Log(title = "实践教学工作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Practice practice)
    {
        List<Practice> list = practiceService.selectPracticeList(practice);
        ExcelUtil<Practice> util = new ExcelUtil<Practice>(Practice.class);
        return util.exportExcel(list, "实践教学工作数据");
    }
    /**
     * 导入实践教学工作工作列表模板
     */
    @RequiresPermissions("system:practice:export")
    @Log(title = "实践教学工作", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Practice> util = new ExcelUtil<>(Practice.class);
        return util.importTemplateExcel("实践教学工作数据");
    }
    /**
     * 导入实践教学工作工作列表
     */
    @RequiresPermissions("system:practice:export")
    @Log(title = "实践教学工作", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Practice> util = new ExcelUtil<>(Practice.class);
        List<Practice> list = util.importExcel(file.getInputStream());
        int message = practiceService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增实践教学工作
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存实践教学工作
     */
    @RequiresPermissions("system:practice:add")
    @Log(title = "实践教学工作", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Practice practice)
    {
        return toAjax(practiceService.insertPractice(practice));
    }

    /**
     * 修改实践教学工作
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Practice practice = practiceService.selectPracticeById(id);
        mmap.put("practice", practice);
        return prefix + "/edit";
    }

    /**
     * 修改保存实践教学工作
     */
    @RequiresPermissions("system:practice:edit")
    @Log(title = "实践教学工作", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Practice practice)
    {
        return toAjax(practiceService.updatePractice(practice));
    }

    /**
     * 删除实践教学工作
     */
    @RequiresPermissions("system:practice:remove")
    @Log(title = "实践教学工作", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(practiceService.deletePracticeByIds(ids));
    }
}
