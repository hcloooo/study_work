package com.proj.project.system.teach.controller;

import java.io.IOException;
import java.util.List;

import com.proj.project.system.user.domain.User;
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
import com.proj.project.system.teach.domain.TheoryTeach;
import com.proj.project.system.teach.service.ITheoryTeachService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 理论教学工作Controller
 * 
 * @author admin
 * @date 2021-04-14
 */
@Controller
@RequestMapping("/system/teach")
public class TheoryTeachController extends BaseController
{
    private String prefix = "system/teach";

    @Autowired
    private ITheoryTeachService theoryTeachService;

    @RequiresPermissions("system:teach:view")
    @GetMapping()
    public String teach()
    {
        return prefix + "/teach";
    }

    /**
     * 查询理论教学工作列表
     */
    @RequiresPermissions("system:teach:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TheoryTeach theoryTeach)
    {
        startPage();
        List<TheoryTeach> list = theoryTeachService.selectTheoryTeachList(theoryTeach);
        return getDataTable(list);
    }

    /**
     * 导出理论教学工作列表
     */
    @RequiresPermissions("system:teach:export")
    @Log(title = "理论教学工作", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TheoryTeach theoryTeach)
    {
        List<TheoryTeach> list = theoryTeachService.selectTheoryTeachList(theoryTeach);
        ExcelUtil<TheoryTeach> util = new ExcelUtil<TheoryTeach>(TheoryTeach.class);
        return util.exportExcel(list, "理论教学工作数据");
    }
    /**
     * 导入理论教学工作列表模板
     */
    @RequiresPermissions("system:teach:import")
    @Log(title = "理论教学工作", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<TheoryTeach> util = new ExcelUtil<>(TheoryTeach.class);
        return util.importTemplateExcel("理论教学工作数据");
    }
    /**
     * 导入理论教学工作列表
     */
    @RequiresPermissions("system:teach:import")
    @Log(title = "理论教学工作", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<TheoryTeach> util = new ExcelUtil<>(TheoryTeach.class);
        List<TheoryTeach> list = util.importExcel(file.getInputStream());
        int message = theoryTeachService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增理论教学工作
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存理论教学工作
     */
    @RequiresPermissions("system:teach:add")
    @Log(title = "理论教学工作", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TheoryTeach theoryTeach)
    {
        return toAjax(theoryTeachService.insertTheoryTeach(theoryTeach));
    }

    /**
     * 修改理论教学工作
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TheoryTeach theoryTeach = theoryTeachService.selectTheoryTeachById(id);
        mmap.put("theoryTeach", theoryTeach);
        return prefix + "/edit";
    }

    /**
     * 修改保存理论教学工作
     */
    @RequiresPermissions("system:teach:edit")
    @Log(title = "理论教学工作", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TheoryTeach theoryTeach)
    {
        return toAjax(theoryTeachService.updateTheoryTeach(theoryTeach));
    }

    /**
     * 删除理论教学工作
     */
    @RequiresPermissions("system:teach:remove")
    @Log(title = "理论教学工作", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(theoryTeachService.deleteTheoryTeachByIds(ids));
    }
}
