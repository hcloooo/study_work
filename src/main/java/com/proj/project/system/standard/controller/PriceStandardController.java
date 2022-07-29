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
import com.proj.project.system.standard.domain.PriceStandard;
import com.proj.project.system.standard.service.IPriceStandardService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;

/**
 * 奖惩类型Controller
 * 
 * @author admin
 * @date 2021-04-19
 */
@Controller
@RequestMapping("/system/standard")
public class PriceStandardController extends BaseController
{
    private String prefix = "system/standard";

    @Autowired
    private IPriceStandardService priceStandardService;

    @RequiresPermissions("system:standard:view")
    @GetMapping()
    public String standard()
    {
        return prefix + "/standard";
    }

    /**
     * 查询奖惩类型列表
     */
    @RequiresPermissions("system:standard:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PriceStandard priceStandard)
    {
        startPage();
        List<PriceStandard> list = priceStandardService.selectPriceStandardList(priceStandard);
        return getDataTable(list);
    }

    /**
     * 导出奖惩类型列表
     */
    @RequiresPermissions("system:standard:export")
    @Log(title = "奖惩类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PriceStandard priceStandard)
    {
        List<PriceStandard> list = priceStandardService.selectPriceStandardList(priceStandard);
        ExcelUtil<PriceStandard> util = new ExcelUtil<PriceStandard>(PriceStandard.class);
        return util.exportExcel(list, "奖惩类型数据");
    }

    /**
     * 新增奖惩类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存奖惩类型
     */
    @RequiresPermissions("system:standard:add")
    @Log(title = "奖惩类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PriceStandard priceStandard)
    {
        return toAjax(priceStandardService.insertPriceStandard(priceStandard));
    }

    /**
     * 修改奖惩类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PriceStandard priceStandard = priceStandardService.selectPriceStandardById(id);
        mmap.put("priceStandard", priceStandard);
        return prefix + "/edit";
    }

    /**
     * 修改保存奖惩类型
     */
    @RequiresPermissions("system:standard:edit")
    @Log(title = "奖惩类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PriceStandard priceStandard)
    {
        return toAjax(priceStandardService.updatePriceStandard(priceStandard));
    }

    /**
     * 删除奖惩类型
     */
    @RequiresPermissions("system:standard:remove")
    @Log(title = "奖惩类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(priceStandardService.deletePriceStandardByIds(ids));
    }
}
