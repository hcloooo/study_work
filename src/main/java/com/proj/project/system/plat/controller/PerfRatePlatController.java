package com.proj.project.system.plat.controller;

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
import com.proj.project.system.plat.domain.PerfRatePlat;
import com.proj.project.system.plat.service.IPerfRatePlatService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 平台业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/plat")
public class PerfRatePlatController extends BaseController
{
    private String prefix = "system/plat";

    @Autowired
    private IPerfRatePlatService perfRatePlatService;

    @RequiresPermissions("system:plat:view")
    @GetMapping()
    public String plat()
    {
        return prefix + "/plat";
    }

    /**
     * 查询平台业绩奖励列表
     */
    @RequiresPermissions("system:plat:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRatePlat perfRatePlat)
    {
        startPage();
        List<PerfRatePlat> list = perfRatePlatService.selectPerfRatePlatList(perfRatePlat);
        return getDataTable(list);
    }

    /**
     * 导出平台业绩奖励列表
     */
    @RequiresPermissions("system:plat:export")
    @Log(title = "平台业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRatePlat perfRatePlat)
    {
        List<PerfRatePlat> list = perfRatePlatService.selectPerfRatePlatList(perfRatePlat);
        ExcelUtil<PerfRatePlat> util = new ExcelUtil<PerfRatePlat>(PerfRatePlat.class);
        return util.exportExcel(list, "平台业绩奖励数据");
    }
    /**
     * 导入平台业绩奖励列表模板
     */
    @RequiresPermissions("system:plat:export")
    @Log(title = "平台业绩奖励", businessType = BusinessType.IMPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRatePlat> util = new ExcelUtil<>(PerfRatePlat.class);
        return util.importTemplateExcel("平台业绩奖励");
    }
    /**
     * 导入平台业绩奖励列表
     */
    @RequiresPermissions("system:plat:export")
    @Log(title = "平台业绩奖励", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRatePlat> util = new ExcelUtil<>(PerfRatePlat.class);
        List<PerfRatePlat> list = util.importExcel(file.getInputStream());
        int message = perfRatePlatService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增平台业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存平台业绩奖励
     */
    @RequiresPermissions("system:plat:add")
    @Log(title = "平台业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRatePlat perfRatePlat)
    {
        return toAjax(perfRatePlatService.insertPerfRatePlat(perfRatePlat));
    }

    /**
     * 修改平台业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRatePlat perfRatePlat = perfRatePlatService.selectPerfRatePlatById(id);
        mmap.put("perfRatePlat", perfRatePlat);
        return prefix + "/edit";
    }

    /**
     * 修改保存平台业绩奖励
     */
    @RequiresPermissions("system:plat:edit")
    @Log(title = "平台业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRatePlat perfRatePlat)
    {
        return toAjax(perfRatePlatService.updatePerfRatePlat(perfRatePlat));
    }

    /**
     * 删除平台业绩奖励
     */
    @RequiresPermissions("system:plat:remove")
    @Log(title = "平台业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRatePlatService.deletePerfRatePlatByIds(ids));
    }
}
