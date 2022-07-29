package com.proj.project.system.textbook.controller;

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
import com.proj.project.system.textbook.domain.PerfRateTextbook;
import com.proj.project.system.textbook.service.IPerfRateTextbookService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 教学-教材业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/textbook")
public class PerfRateTextbookController extends BaseController
{
    private String prefix = "system/textbook";

    @Autowired
    private IPerfRateTextbookService perfRateTextbookService;

    @RequiresPermissions("system:textbook:view")
    @GetMapping()
    public String textbook()
    {
        return prefix + "/textbook";
    }

    /**
     * 查询教学-教材业绩奖励列表
     */
    @RequiresPermissions("system:textbook:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateTextbook perfRateTextbook)
    {
        startPage();
        List<PerfRateTextbook> list = perfRateTextbookService.selectPerfRateTextbookList(perfRateTextbook);
        return getDataTable(list);
    }

    /**
     * 导出教学-教材业绩奖励列表
     */
    @RequiresPermissions("system:textbook:export")
    @Log(title = "教学-教材业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateTextbook perfRateTextbook)
    {
        List<PerfRateTextbook> list = perfRateTextbookService.selectPerfRateTextbookList(perfRateTextbook);
        ExcelUtil<PerfRateTextbook> util = new ExcelUtil<PerfRateTextbook>(PerfRateTextbook.class);
        return util.exportExcel(list, "教学-教材业绩奖励数据");
    }
    /**
     * 导入平台业绩奖励列表模板
     */
    @RequiresPermissions("system:textbook:export")
    @Log(title = "教学-教材业绩奖励", businessType = BusinessType.IMPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRateTextbook> util = new ExcelUtil<>(PerfRateTextbook.class);
        return util.importTemplateExcel("教学-教材业绩奖励");
    }
    /**
     * 导入平台业绩奖励列表
     */
    @RequiresPermissions("system:textbook:export")
    @Log(title = "教学-教材业绩奖励", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRateTextbook> util = new ExcelUtil<>(PerfRateTextbook.class);
        List<PerfRateTextbook> list = util.importExcel(file.getInputStream());
        int message = perfRateTextbookService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增教学-教材业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教学-教材业绩奖励
     */
    @RequiresPermissions("system:textbook:add")
    @Log(title = "教学-教材业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateTextbook perfRateTextbook)
    {
        return toAjax(perfRateTextbookService.insertPerfRateTextbook(perfRateTextbook));
    }

    /**
     * 修改教学-教材业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateTextbook perfRateTextbook = perfRateTextbookService.selectPerfRateTextbookById(id);
        mmap.put("perfRateTextbook", perfRateTextbook);
        return prefix + "/edit";
    }

    /**
     * 修改保存教学-教材业绩奖励
     */
    @RequiresPermissions("system:textbook:edit")
    @Log(title = "教学-教材业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateTextbook perfRateTextbook)
    {
        return toAjax(perfRateTextbookService.updatePerfRateTextbook(perfRateTextbook));
    }

    /**
     * 删除教学-教材业绩奖励
     */
    @RequiresPermissions("system:textbook:remove")
    @Log(title = "教学-教材业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateTextbookService.deletePerfRateTextbookByIds(ids));
    }
}
