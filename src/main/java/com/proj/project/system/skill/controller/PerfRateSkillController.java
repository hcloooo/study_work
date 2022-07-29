package com.proj.project.system.skill.controller;

import java.util.List;

import com.proj.project.system.guide.domain.Guide;
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
import com.proj.project.system.skill.domain.PerfRateSkill;
import com.proj.project.system.skill.service.IPerfRateSkillService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学术业绩奖励Controller
 * 
 * @author admin
 * @date 2021-04-20
 */
@Controller
@RequestMapping("/system/skill")
public class PerfRateSkillController extends BaseController
{
    private String prefix = "system/skill";

    @Autowired
    private IPerfRateSkillService perfRateSkillService;

    @RequiresPermissions("system:skill:view")
    @GetMapping()
    public String skill()
    {
        return prefix + "/skill";
    }

    /**
     * 查询学术业绩奖励列表
     */
    @RequiresPermissions("system:skill:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PerfRateSkill perfRateSkill)
    {
        startPage();
        List<PerfRateSkill> list = perfRateSkillService.selectPerfRateSkillList(perfRateSkill);
        return getDataTable(list);
    }

    /**
     * 导出学术业绩奖励列表
     */
    @RequiresPermissions("system:skill:export")
    @Log(title = "学术业绩奖励", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PerfRateSkill perfRateSkill)
    {
        List<PerfRateSkill> list = perfRateSkillService.selectPerfRateSkillList(perfRateSkill);
        ExcelUtil<PerfRateSkill> util = new ExcelUtil<PerfRateSkill>(PerfRateSkill.class);
        return util.exportExcel(list, "学术业绩奖励数据");
    }
    /**
     * 导入学科竞赛指导工作量模板
     */
    @RequiresPermissions("system:skill:export")
    @Log(title = "学术业绩奖励数据", businessType = BusinessType.EXPORT)
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<PerfRateSkill> util = new ExcelUtil<>(PerfRateSkill.class);
        return util.importTemplateExcel("学科竞赛指导工作量");
    }
    /**
     * 导入学科竞赛指导工作量
     */
    @RequiresPermissions("system:skill:export")
    @Log(title = "学术业绩奖励数据", businessType = BusinessType.EXPORT)
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception {
        ExcelUtil<PerfRateSkill> util = new ExcelUtil<>(PerfRateSkill.class);
        List<PerfRateSkill> list = util.importExcel(file.getInputStream());
        int message = perfRateSkillService.importList(list, updateSupport);
        return AjaxResult.success(message);
    }

    /**
     * 新增学术业绩奖励
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存学术业绩奖励
     */
    @RequiresPermissions("system:skill:add")
    @Log(title = "学术业绩奖励", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PerfRateSkill perfRateSkill)
    {
        return toAjax(perfRateSkillService.insertPerfRateSkill(perfRateSkill));
    }

    /**
     * 修改学术业绩奖励
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PerfRateSkill perfRateSkill = perfRateSkillService.selectPerfRateSkillById(id);
        mmap.put("perfRateSkill", perfRateSkill);
        return prefix + "/edit";
    }

    /**
     * 修改保存学术业绩奖励
     */
    @RequiresPermissions("system:skill:edit")
    @Log(title = "学术业绩奖励", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PerfRateSkill perfRateSkill)
    {
        return toAjax(perfRateSkillService.updatePerfRateSkill(perfRateSkill));
    }

    /**
     * 删除学术业绩奖励
     */
    @RequiresPermissions("system:skill:remove")
    @Log(title = "学术业绩奖励", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(perfRateSkillService.deletePerfRateSkillByIds(ids));
    }
}
