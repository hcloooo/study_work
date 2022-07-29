package com.proj.project.system.base.controller;

import java.util.List;

import com.proj.project.system.other.domain.PerfRateOther;
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
import com.proj.project.system.base.domain.PerfRateBase;
import com.proj.project.system.base.service.IPerfRateBaseService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教学-基本业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/base")
public class PerfRateBaseController extends BaseController
{
    private String prefix = "system/base";

    @Autowired
    private IPerfRateBaseService perfRateBaseService;

    @RequiresPermissions("system:base:view")
    @GetMapping()
    public String base()
    {
        return prefix + "/base";
    }

    /**
     * 查询教学-基本业绩奖励列表
     */
    @RequiresPermissions("system:base:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateBase perfRateBase)
    {
        startPage();
        List<PerfRateBase> list = perfRateBaseService.selectPerfRateBaseList(perfRateBase);
        return getDataTable(list);
    }

    /**
     * 导出教学-基本业绩奖励列表
     */
    @RequiresPermissions("system:base:export")
    @Log(title = "教学-基本业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateBase perfRateBase)
    {
        List<PerfRateBase> list = perfRateBaseService.selectPerfRateBaseList(perfRateBase);
        ExcelUtil<PerfRateBase> util = new ExcelUtil<PerfRateBase>(PerfRateBase.class);
        return util.exportExcel(list, "教学-基本业绩奖励数据");
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
        ExcelUtil<PerfRateBase> util = new ExcelUtil<>(PerfRateBase.class);
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
        ExcelUtil<PerfRateBase> util = new ExcelUtil<>(PerfRateBase.class);
        List<PerfRateBase> list = util.importExcel(file.getInputStream());
        int message = perfRateBaseService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增教学-基本业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教学-基本业绩奖励
     */
    @RequiresPermissions("system:base:add")
    @Log(title = "教学-基本业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateBase perfRateBase)
    {
        return toAjax(perfRateBaseService.insertPerfRateBase(perfRateBase));
    }

    /**
     * 修改教学-基本业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateBase perfRateBase = perfRateBaseService.selectPerfRateBaseById(id);
        mmap.put("perfRateBase", perfRateBase);
        return prefix + "/edit";
    }

    /**
     * 修改保存教学-基本业绩奖励
     */
    @RequiresPermissions("system:base:edit")
    @Log(title = "教学-基本业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateBase perfRateBase)
    {
        return toAjax(perfRateBaseService.updatePerfRateBase(perfRateBase));
    }

    /**
     * 删除教学-基本业绩奖励
     */
    @RequiresPermissions("system:base:remove")
    @Log(title = "教学-基本业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateBaseService.deletePerfRateBaseByIds(ids));
    }
}
