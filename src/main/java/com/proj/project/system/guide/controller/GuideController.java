package com.proj.project.system.guide.controller;

import java.util.List;

import com.proj.project.system.practice.domain.Practice;
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
import com.proj.project.system.guide.domain.Guide;
import com.proj.project.system.guide.service.IGuideService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学科竞赛指导工作量Controller
 * 
 * @author admin
 * @date 2021-04-15
 */
@Controller
@RequestMapping("/system/guide")
public class GuideController extends BaseController
{
    private String prefix = "system/guide";

    @Autowired
    private IGuideService guideService;

    @RequiresPermissions("system:guide:view")
    @GetMapping()
    public String guide()
    {
        return prefix + "/guide";
    }

    /**
     * 查询学科竞赛指导工作量列表
     */
    @RequiresPermissions("system:guide:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Guide guide)
    {
        startPage();
        List<Guide> list = guideService.selectGuideList(guide);
        return getDataTable(list);
    }

    /**
     * 导出学科竞赛指导工作量列表
     */
    @RequiresPermissions("system:guide:export")
    @Log(title = "学科竞赛指导工作量", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Guide guide)
    {
        List<Guide> list = guideService.selectGuideList(guide);
        ExcelUtil<Guide> util = new ExcelUtil<Guide>(Guide.class);
        return util.exportExcel(list, "学科竞赛指导工作量数据");
    }

    /**
     * 导入学科竞赛指导工作量模板
     */
    @RequiresPermissions("system:guide:export")
    @Log(title = "学科竞赛指导工作量", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Guide> util = new ExcelUtil<>(Guide.class);
        return util.importTemplateExcel("学科竞赛指导工作量");
    }
    /**
     * 导入学科竞赛指导工作量
     */
    @RequiresPermissions("system:guide:export")
    @Log(title = "学科竞赛指导工作量", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<Guide> util = new ExcelUtil<>(Guide.class);
        List<Guide> list = util.importExcel(file.getInputStream());
        int message = guideService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 新增学科竞赛指导工作量
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学科竞赛指导工作量
     */
    @RequiresPermissions("system:guide:add")
    @Log(title = "学科竞赛指导工作量", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Guide guide)
    {
        return toAjax(guideService.insertGuide(guide));
    }

    /**
     * 修改学科竞赛指导工作量
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Guide guide = guideService.selectGuideById(id);
        mmap.put("guide", guide);
        return prefix + "/edit";
    }

    /**
     * 修改保存学科竞赛指导工作量
     */
    @RequiresPermissions("system:guide:edit")
    @Log(title = "学科竞赛指导工作量", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Guide guide)
    {
        return toAjax(guideService.updateGuide(guide));
    }

    /**
     * 删除学科竞赛指导工作量
     */
    @RequiresPermissions("system:guide:remove")
    @Log(title = "学科竞赛指导工作量", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(guideService.deleteGuideByIds(ids));
    }
}
