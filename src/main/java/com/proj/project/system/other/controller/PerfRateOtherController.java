package com.proj.project.system.other.controller;

import java.util.List;

import com.proj.project.system.skill.domain.PerfRateSkill;
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
import com.proj.project.system.other.domain.PerfRateOther;
import com.proj.project.system.other.service.IPerfRateOtherService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 成果、其他业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/other")
public class PerfRateOtherController extends BaseController
{
    private String prefix = "system/other";

    @Autowired
    private IPerfRateOtherService perfRateOtherService;

    @RequiresPermissions("system:other:view")
    @GetMapping()
    public String other()
    {
        return prefix + "/other";
    }

    /**
     * 查询成果、其他业绩奖励列表
     */
    @RequiresPermissions("system:other:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateOther perfRateOther)
    {
        startPage();
        List<PerfRateOther> list = perfRateOtherService.selectPerfRateOtherList(perfRateOther);
        return getDataTable(list);
    }

    /**
     * 导出成果、其他业绩奖励列表
     */
    @RequiresPermissions("system:other:export")
    @Log(title = "成果、其他业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateOther perfRateOther)
    {
        List<PerfRateOther> list = perfRateOtherService.selectPerfRateOtherList(perfRateOther);
        ExcelUtil<PerfRateOther> util = new ExcelUtil<PerfRateOther>(PerfRateOther.class);
        return util.exportExcel(list, "成果、其他业绩奖励数据");
    }
    /**
     * 导入成果、其他业绩奖励数据模板
     */
    @RequiresPermissions("system:other:export")
    @Log(title = "成果、其他业绩奖励数据", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRateOther> util = new ExcelUtil<>(PerfRateOther.class);
        return util.importTemplateExcel("成果、其他业绩奖励数据");
    }
    /**
     * 导入成果、其他业绩奖励数据
     */
    @RequiresPermissions("system:other:export")
    @Log(title = "成果、其他业绩奖励数据", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRateOther> util = new ExcelUtil<>(PerfRateOther.class);
        List<PerfRateOther> list = util.importExcel(file.getInputStream());
        int message = perfRateOtherService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增成果、其他业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存成果、其他业绩奖励
     */
    @RequiresPermissions("system:other:add")
    @Log(title = "成果、其他业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateOther perfRateOther)
    {
        return toAjax(perfRateOtherService.insertPerfRateOther(perfRateOther));
    }

    /**
     * 修改成果、其他业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateOther perfRateOther = perfRateOtherService.selectPerfRateOtherById(id);
        mmap.put("perfRateOther", perfRateOther);
        return prefix + "/edit";
    }

    /**
     * 修改保存成果、其他业绩奖励
     */
    @RequiresPermissions("system:other:edit")
    @Log(title = "成果、其他业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateOther perfRateOther)
    {
        return toAjax(perfRateOtherService.updatePerfRateOther(perfRateOther));
    }

    /**
     * 删除成果、其他业绩奖励
     */
    @RequiresPermissions("system:other:remove")
    @Log(title = "成果、其他业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateOtherService.deletePerfRateOtherByIds(ids));
    }
}
