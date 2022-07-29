package com.proj.project.system.apply.controller;

import java.util.List;

import com.proj.common.utils.security.ShiroUtils;
import com.proj.project.system.applyconfig.domain.Applyconfig;
import com.proj.project.system.applyconfig.service.IApplyconfigService;
import com.proj.project.system.standard.domain.PriceStandard;
import com.proj.project.system.standard.service.IPriceStandardService;
import com.proj.project.system.user.domain.User;
import org.apache.shiro.SecurityUtils;
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
import com.proj.project.system.apply.domain.Apply;
import com.proj.project.system.apply.service.IApplyService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;

/**
 * 上报申请奖励信息Controller
 *
 * @author admin
 * @date 2021-04-26
 */
@Controller
@RequestMapping("/system/apply")
public class ApplyController extends BaseController {
    private String prefix = "system/apply";

    @Autowired
    private IApplyService applyService;
    @Autowired
    private IApplyconfigService applyconfigService;
    @Autowired
    private IPriceStandardService priceStandardService;

    @RequiresPermissions("system:apply:view")
    @GetMapping()
    public String apply() {
        return prefix + "/apply";
    }

    /**
     * 查询上报申请奖励信息列表
     */
    @RequiresPermissions("system:apply:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Apply apply) {
        startPage();
        List<Apply> list = applyService.selectApplyList(apply);
        return getDataTable(list);
    }

    /**
     * 导出上报申请奖励信息列表
     */
    @RequiresPermissions("system:apply:export")
    @Log(title = "上报申请奖励信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Apply apply) {
        List<Apply> list = applyService.selectApplyList(apply);
        ExcelUtil<Apply> util = new ExcelUtil<Apply>(Apply.class);
        return util.exportExcel(list, "上报申请奖励信息数据");
    }

    /**
     * 新增上报申请奖励信息
     */
    @GetMapping("/add")
    public String add(ModelMap map) {
        List<PriceStandard> priceStandards = priceStandardService.selectPriceStandardList(null);
        map.put("types", priceStandards);
        return prefix + "/add";
    }

    /**
     * 新增保存上报申请奖励信息
     */
    @RequiresPermissions("system:apply:add")
    @Log(title = "上报申请奖励信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Apply apply) {
        User sysUser = ShiroUtils.getSysUser();
        if (sysUser.getRoles().size() == 0) {
            return AjaxResult.error("无权限申请，请查看角色");
        }
        Applyconfig applyconfig = new Applyconfig();
        applyconfig.setPriceId(apply.getPriceId());
        List<Applyconfig> applyconfigs = applyconfigService.selectApplyconfigList(applyconfig);
        if (applyconfigs.size() == 0) {
            return AjaxResult.error("请设置审批流程");
        } else if (applyconfigs.size() == 1 && applyconfigs.get(0).getRoleId().equals(sysUser.getRoles().get(0).getRoleId())) {
            apply.setApplyStatus(3);
            apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
        } else {
            apply.setApplyStatus(2);
        }
        return toAjax(applyService.insertApply(apply));
    }

    /**
     * 修改上报申请奖励信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        List<PriceStandard> priceStandards = priceStandardService.selectPriceStandardList(null);
        mmap.put("types", priceStandards);
        Apply apply = applyService.selectApplyById(id);
        mmap.put("apply", apply);
        return prefix + "/edit";
    }

    /**
     * 修改保存上报申请奖励信息
     */
    @RequiresPermissions("system:apply:edit")
    @Log(title = "上报申请奖励信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Apply apply) {
        return toAjax(applyService.updateApply(apply));
    }
    /**
     * 审核
     */
    @RequiresPermissions("system:apply:edit")
    @Log(title = "审核申请奖励信息", businessType = BusinessType.UPDATE)
    @PostMapping("/apply")
    @ResponseBody
    public AjaxResult apply(Apply apply) {User sysUser = ShiroUtils.getSysUser();
        if (sysUser.getRoles().size() == 0) {
            return AjaxResult.error("无权限申请，请查看角色");
        }
        Applyconfig applyconfig = new Applyconfig();
        applyconfig.setPriceId(apply.getPriceId());
        List<Applyconfig> applyconfigs = applyconfigService.selectApplyconfigList(applyconfig);
        if (applyconfigs.size() == 0) {
            return AjaxResult.error("请设置审批流程");
        }
        Apply old = applyService.selectApplyById(apply.getId());
        if(old.getApplyRoleId() == null
                && applyconfigs.size() == 1
                && applyconfigs.get(0).getRoleId().equals(sysUser.getRoles().get(0).getRoleId())
                && !apply.getApplyStatus().equals(1)){
            apply.setApplyStatus(3);
            apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
        }else if(old.getApplyRoleId() == null
                && applyconfigs.size() == 1
                && applyconfigs.get(0).getRoleId().equals(sysUser.getRoles().get(0).getRoleId())
                && apply.getApplyStatus().equals(1)){
            apply.setApplyStatus(1);
            apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
        }else if(old.getApplyRoleId() == null
                && applyconfigs.size() > 1
                && applyconfigs.get(0).getRoleId().equals(sysUser.getRoles().get(0).getRoleId())){
            apply.setApplyStatus(2);
            apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
        }else {
            Integer index = null;
            for (int i = 0; i < applyconfigs.size(); i++) {
                if(applyconfigs.get(i).getRoleId().equals(old.getApplyRoleId())){
                    index = i + 1;
                    break;
                }
            }
            if(index != null
                    && index + 1 <= applyconfigs.size()
                    && applyconfigs.get(index).getRoleId().equals(sysUser.getRoles().get(0).getRoleId())){
                if(apply.getApplyStatus().equals(1)){
                    apply.setApplyStatus(1);
                    apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
                } else if(index + 1 < applyconfigs.size()){
                    apply.setApplyStatus(2);
                    apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
                }else {
                    apply.setApplyStatus(3);
                    apply.setApplyRoleId(sysUser.getRoles().get(0).getRoleId());
                }
            }else {
                return AjaxResult.error("无权限申请，请查看角色");
            }
        }
        return toAjax(applyService.updateApply(apply));
    }

    /**
     * 删除上报申请奖励信息
     */
    @RequiresPermissions("system:apply:remove")
    @Log(title = "上报申请奖励信息", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(applyService.deleteApplyByIds(ids));
    }
}
