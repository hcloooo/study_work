package com.proj.project.system.vert.controller;

import java.util.List;

import com.proj.project.system.plat.domain.PerfRatePlat;
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
import com.proj.project.system.vert.domain.PerfRateVert;
import com.proj.project.system.vert.service.IPerfRateVertService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 纵横向业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/vert")
public class PerfRateVertController extends BaseController
{
    private String prefix = "system/vert";

    @Autowired
    private IPerfRateVertService perfRateVertService;

    @RequiresPermissions("system:vert:view")
    @GetMapping()
    public String vert()
    {
        return prefix + "/vert";
    }

    /**
     * 查询纵横向业绩奖励列表
     */
    @RequiresPermissions("system:vert:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateVert perfRateVert)
    {
        startPage();
        List<PerfRateVert> list = perfRateVertService.selectPerfRateVertList(perfRateVert);
        return getDataTable(list);
    }

    /**
     * 导出纵横向业绩奖励列表
     */
    @RequiresPermissions("system:vert:export")
    @Log(title = "纵横向业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateVert perfRateVert)
    {
        List<PerfRateVert> list = perfRateVertService.selectPerfRateVertList(perfRateVert);
        ExcelUtil<PerfRateVert> util = new ExcelUtil<PerfRateVert>(PerfRateVert.class);
        return util.exportExcel(list, "纵横向业绩奖励数据");
    }
    /**
     * 导入纵横向业绩奖励
     */
    @RequiresPermissions("system:vert:export")
    @Log(title = "纵横向业绩奖励", businessType = BusinessType.IMPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRateVert> util = new ExcelUtil<>(PerfRateVert.class);
        return util.importTemplateExcel("纵横向业绩奖励");
    }
    /**
     * 导入纵横向业绩奖励
     */
    @RequiresPermissions("system:vert:export")
    @Log(title = "纵横向业绩奖励", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRateVert> util = new ExcelUtil<>(PerfRateVert.class);
        List<PerfRateVert> list = util.importExcel(file.getInputStream());
        int message = perfRateVertService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增纵横向业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存纵横向业绩奖励
     */
    @RequiresPermissions("system:vert:add")
    @Log(title = "纵横向业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateVert perfRateVert)
    {
        return toAjax(perfRateVertService.insertPerfRateVert(perfRateVert));
    }

    /**
     * 修改纵横向业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateVert perfRateVert = perfRateVertService.selectPerfRateVertById(id);
        mmap.put("perfRateVert", perfRateVert);
        return prefix + "/edit";
    }

    /**
     * 修改保存纵横向业绩奖励
     */
    @RequiresPermissions("system:vert:edit")
    @Log(title = "纵横向业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateVert perfRateVert)
    {
        return toAjax(perfRateVertService.updatePerfRateVert(perfRateVert));
    }

    /**
     * 删除纵横向业绩奖励
     */
    @RequiresPermissions("system:vert:remove")
    @Log(title = "纵横向业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateVertService.deletePerfRateVertByIds(ids));
    }
}
