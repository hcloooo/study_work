package com.proj.project.system.applyconfig.controller;

import java.util.List;

import com.proj.project.system.config.domain.PriceConfig;
import com.proj.project.system.role.domain.Role;
import com.proj.project.system.role.service.IRoleService;
import com.proj.project.system.standard.domain.PriceStandard;
import com.proj.project.system.standard.service.IPriceStandardService;
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
import com.proj.project.system.applyconfig.domain.Applyconfig;
import com.proj.project.system.applyconfig.service.IApplyconfigService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;

/**
 * 审批流程Controller
 * 
 * @author admin
 * @date 2021-04-26
 */
@Controller
@RequestMapping("/system/applyconfig")
public class ApplyconfigController extends BaseController
{
    private String prefix = "system/applyconfig";

    @Autowired
    private IApplyconfigService applyconfigService;
    @Autowired
    private IPriceStandardService priceStandardService;
    @Autowired
    private IRoleService roleService;

    @RequiresPermissions("system:applyconfig:view")
    @GetMapping()
    public String applyconfig(ModelMap map)
    {
        List<PriceStandard> priceStandards = priceStandardService.selectPriceStandardList(null);
        map.put("types", priceStandards);
        return prefix + "/applyconfig";
    }

    /**
     * 查询审批流程列表
     */
    @RequiresPermissions("system:applyconfig:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Applyconfig applyconfig)
    {
        startPage();
        List<Applyconfig> list = applyconfigService.selectApplyconfigList(applyconfig);
        return getDataTable(list);
    }

    /**
     * 导出审批流程列表
     */
    @RequiresPermissions("system:applyconfig:export")
    @Log(title = "审批流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Applyconfig applyconfig)
    {
        List<Applyconfig> list = applyconfigService.selectApplyconfigList(applyconfig);
        ExcelUtil<Applyconfig> util = new ExcelUtil<Applyconfig>(Applyconfig.class);
        return util.exportExcel(list, "审批流程数据");
    }

    /**
     * 新增审批流程
     */
    @GetMapping("/add")
    public String add(ModelMap map)
    {
        List<PriceStandard> priceStandards = priceStandardService.selectPriceStandardList(null);
        map.put("types", priceStandards);
        List<Role> roles = roleService.selectRoleAll();
        map.put("roles", roles);

        return prefix + "/add";
    }

    /**
     * 新增保存审批流程
     */
    @RequiresPermissions("system:applyconfig:add")
    @Log(title = "审批流程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Applyconfig applyconfig)
    {
        return toAjax(applyconfigService.insertApplyconfig(applyconfig));
    }

    /**
     * 修改审批流程
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap map)
    {
        List<PriceStandard> priceStandards = priceStandardService.selectPriceStandardList(null);
        map.put("types", priceStandards);
        List<Role> roles = roleService.selectRoleAll();
        map.put("roles", roles);
        Applyconfig applyconfig = applyconfigService.selectApplyconfigById(id);
        map.put("applyconfig", applyconfig);
        return prefix + "/edit";
    }

    /**
     * 修改保存审批流程
     */
    @RequiresPermissions("system:applyconfig:edit")
    @Log(title = "审批流程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Applyconfig applyconfig)
    {
        return toAjax(applyconfigService.updateApplyconfig(applyconfig));
    }

    /**
     * 删除审批流程
     */
    @RequiresPermissions("system:applyconfig:remove")
    @Log(title = "审批流程", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(applyconfigService.deleteApplyconfigByIds(ids));
    }
}
