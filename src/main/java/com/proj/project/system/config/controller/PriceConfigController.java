package com.proj.project.system.config.controller;

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
import com.proj.project.system.config.domain.PriceConfig;
import com.proj.project.system.config.service.IPriceConfigService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 奖励参数Controller
 * 
 * @author admin
 * @date 2021-04-19
 */
@Controller
@RequestMapping("/system/price/config")
public class PriceConfigController extends BaseController
{
    private String prefix = "system/price";

    @Autowired
    private IPriceConfigService priceConfigService;

    @RequiresPermissions("system:config:view")
    @GetMapping()
    public String config()
    {
        return prefix + "/config";
    }

    /**
     * 查询奖励参数列表
     */
    @RequiresPermissions("system:config:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PriceConfig priceConfig)
    {
        startPage();
        List<PriceConfig> list = priceConfigService.selectPriceConfigList(priceConfig);
        return getDataTable(list);
    }
    /**
     * 查询奖励参数列表
     */
    @RequiresPermissions("system:config:list")
    @PostMapping("/list/all")
    @ResponseBody
    public AjaxResult listAll(PriceConfig priceConfig)
    {
        List<PriceConfig> list = priceConfigService.selectPriceConfigList(priceConfig);
        return AjaxResult.success(list);
    }

    /**
     * 导出奖励参数列表
     */
    @RequiresPermissions("system:config:export")
    @Log(title = "奖励参数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PriceConfig priceConfig)
    {
        List<PriceConfig> list = priceConfigService.selectPriceConfigList(priceConfig);
        ExcelUtil<PriceConfig> util = new ExcelUtil<PriceConfig>(PriceConfig.class);
        return util.exportExcel(list, "奖励参数数据");
    }
    /**
     * 导入奖励参数列表模板
     */
    @RequiresPermissions("system:config:export")
    @Log(title = "奖励参数", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PriceConfig> util = new ExcelUtil<>(PriceConfig.class);
        return util.importTemplateExcel("奖励参数数据");
    }
    /**
     * 导入实践教学工作工作列表
     */
    @RequiresPermissions("system:config:export")
    @Log(title = "奖励参数", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PriceConfig> util = new ExcelUtil<>(PriceConfig.class);
        List<PriceConfig> list = util.importExcel(file.getInputStream());
        int message = priceConfigService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增奖励参数
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存奖励参数
     */
    @RequiresPermissions("system:config:add")
    @Log(title = "奖励参数", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PriceConfig priceConfig)
    {
        return toAjax(priceConfigService.insertPriceConfig(priceConfig));
    }

    /**
     * 修改奖励参数
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PriceConfig priceConfig = priceConfigService.selectPriceConfigById(id);
        mmap.put("priceConfig", priceConfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存奖励参数
     */
    @RequiresPermissions("system:config:edit")
    @Log(title = "奖励参数", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PriceConfig priceConfig)
    {
        return toAjax(priceConfigService.updatePriceConfig(priceConfig));
    }

    /**
     * 删除奖励参数
     */
    @RequiresPermissions("system:config:remove")
    @Log(title = "奖励参数", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(priceConfigService.deletePriceConfigByIds(ids));
    }
}
