package com.proj.project.system.book.controller;

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
import com.proj.project.system.book.domain.PerfRateBook;
import com.proj.project.system.book.service.IPerfRateBookService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学术著作业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/book")
public class PerfRateBookController extends BaseController
{
    private String prefix = "system/book";

    @Autowired
    private IPerfRateBookService perfRateBookService;

    @RequiresPermissions("system:book:view")
    @GetMapping()
    public String book()
    {
        return prefix + "/book";
    }

    /**
     * 查询学术著作业绩奖励列表
     */
    @RequiresPermissions("system:book:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateBook perfRateBook)
    {
        startPage();
        List<PerfRateBook> list = perfRateBookService.selectPerfRateBookList(perfRateBook);
        return getDataTable(list);
    }

    /**
     * 导出学术著作业绩奖励列表
     */
    @RequiresPermissions("system:book:export")
    @Log(title = "学术著作业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateBook perfRateBook)
    {
        List<PerfRateBook> list = perfRateBookService.selectPerfRateBookList(perfRateBook);
        ExcelUtil<PerfRateBook> util = new ExcelUtil<PerfRateBook>(PerfRateBook.class);
        return util.exportExcel(list, "学术著作业绩奖励数据");
    }

    /**
     * 导入学术著作业绩奖励模板
     */
    @RequiresPermissions("system:book:export")
    @Log(title = "平台业绩奖励", businessType = BusinessType.IMPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRateBook> util = new ExcelUtil<>(PerfRateBook.class);
        return util.importTemplateExcel("平台业绩奖励");
    }
    /**
     * 导入学术著作业绩奖励
     */
    @RequiresPermissions("system:book:export")
    @Log(title = "平台业绩奖励", businessType = BusinessType.IMPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRateBook> util = new ExcelUtil<>(PerfRateBook.class);
        List<PerfRateBook> list = util.importExcel(file.getInputStream());
        int message = perfRateBookService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }
    /**
     * 新增学术著作业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学术著作业绩奖励
     */
    @RequiresPermissions("system:book:add")
    @Log(title = "学术著作业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateBook perfRateBook)
    {
        return toAjax(perfRateBookService.insertPerfRateBook(perfRateBook));
    }

    /**
     * 修改学术著作业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateBook perfRateBook = perfRateBookService.selectPerfRateBookById(id);
        mmap.put("perfRateBook", perfRateBook);
        return prefix + "/edit";
    }


    /**
     * 修改保存学术著作业绩奖励
     */
    @RequiresPermissions("system:book:edit")
    @Log(title = "学术著作业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateBook perfRateBook)
    {
        return toAjax(perfRateBookService.updatePerfRateBook(perfRateBook));
    }

    /**
     * 删除学术著作业绩奖励
     */
    @RequiresPermissions("system:book:remove")
    @Log(title = "学术著作业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateBookService.deletePerfRateBookByIds(ids));
    }
}
