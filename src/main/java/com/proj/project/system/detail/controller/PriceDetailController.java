package com.proj.project.system.detail.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.proj.project.system.base.domain.PerfRateBase;
import com.proj.project.system.base.service.IPerfRateBaseService;
import com.proj.project.system.book.domain.PerfRateBook;
import com.proj.project.system.book.service.IPerfRateBookService;
import com.proj.project.system.config.domain.PriceConfig;
import com.proj.project.system.config.service.IPriceConfigService;
import com.proj.project.system.contest.domain.PerfRateContest;
import com.proj.project.system.contest.service.IPerfRateContestService;
import com.proj.project.system.other.domain.PerfRateOther;
import com.proj.project.system.other.service.IPerfRateOtherService;
import com.proj.project.system.plat.domain.PerfRatePlat;
import com.proj.project.system.plat.service.IPerfRatePlatService;
import com.proj.project.system.skill.domain.PerfRateSkill;
import com.proj.project.system.skill.service.IPerfRateSkillService;
import com.proj.project.system.textbook.domain.PerfRateTextbook;
import com.proj.project.system.textbook.service.IPerfRateTextbookService;
import com.proj.project.system.vert.domain.PerfRateVert;
import com.proj.project.system.vert.service.IPerfRateVertService;
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
import com.proj.project.system.detail.domain.PriceDetail;
import com.proj.project.system.detail.service.IPriceDetailService;
import com.proj.framework.web.controller.BaseController;
import com.proj.framework.web.domain.AjaxResult;
import com.proj.common.utils.poi.ExcelUtil;
import com.proj.framework.web.page.TableDataInfo;

/**
 * 奖励分配Controller
 * 
 * @author admin
 * @date 2021-04-21
 */
@Controller
@RequestMapping("/system/detail")
public class PriceDetailController extends BaseController
{
    private String prefix = "system/detail";

    @Autowired
    private IPriceDetailService priceDetailService;
    @Autowired
    private IPerfRateSkillService skillService;
    @Autowired
    private IPerfRateOtherService otherService;
    @Autowired
    private IPerfRatePlatService platService;
    @Autowired
    private IPerfRateTextbookService textbookService;
    @Autowired
    private IPerfRateVertService perfRateVertService;
    @Autowired
    private IPriceConfigService priceConfigService;
    @Autowired
    private IPerfRateContestService perfRateContestService;
    @Autowired
    private IPerfRateBookService perfRateBookService;
    @Autowired
    private IPerfRateBaseService perfRateBaseService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail(ModelMap map, PriceDetail priceDetail)
    {
        return prefix + "/detail";
    }

    @RequiresPermissions("system:detail:view")
    @GetMapping("detail_add")
    public String detailAdd(ModelMap map, PriceDetail priceDetail)
    {
        List<PriceConfig> priceConfigs = priceConfigService.selectPriceConfigList(null);
        map.put("types", priceConfigs);
        map.put("projType", priceDetail.getProjType());
        if(priceDetail.getProjType() == 1){
            //学术业绩奖励
            PerfRateSkill perfRateSkill = skillService.selectPerfRateSkillById(priceDetail.getProjId());
            map.put("data", perfRateSkill);
        }
        if(priceDetail.getProjType() == 2){
            //成果、其他业绩奖
            PerfRateOther perfRateOther = otherService.selectPerfRateOtherById(priceDetail.getProjId());
            map.put("data", perfRateOther);
        }
        if(priceDetail.getProjType() == 3){
            //平台业绩将
            PerfRatePlat perfRatePlat = platService.selectPerfRatePlatById(priceDetail.getProjId());
            map.put("data", perfRatePlat);
        }
        if(priceDetail.getProjType() == 4){
            //教学-教材业绩奖励
            PerfRateTextbook perfRateTextbook = textbookService.selectPerfRateTextbookById(priceDetail.getProjId());
            map.put("data", perfRateTextbook);
        }
        if(priceDetail.getProjType() == 5){
            //纵横向业绩奖励
            PerfRateVert perfRateVert = perfRateVertService.selectPerfRateVertById(priceDetail.getProjId());
            map.put("data", perfRateVert);
        }
        if(priceDetail.getProjType() == 6){
            //学术著作业绩奖励
            PerfRateBook perfRateBook = perfRateBookService.selectPerfRateBookById(priceDetail.getProjId());
            map.put("data", perfRateBook);
        }
        if(priceDetail.getProjType() == 7){
            //教学-竞赛业绩奖励
            PerfRateContest perfRateContest = perfRateContestService.selectPerfRateContestById(priceDetail.getProjId());
            map.put("data", perfRateContest);
        }
        if(priceDetail.getProjType() == 8){
            //教学-基础业绩奖励
            PerfRateBase perfRateBase = perfRateBaseService.selectPerfRateBaseById(priceDetail.getProjId());
            map.put("data", perfRateBase);
        }
        return prefix + "/detail_add";
    }

    /**
     * 获取可分配金额
     */
    @RequiresPermissions("system:detail:view")
    @GetMapping( "/price")
    @ResponseBody
    public AjaxResult price(Long priceType, Long projId, Integer projType)
    {
        if(priceType == null){
            return AjaxResult.success(BigDecimal.ZERO);
        }
        if(projType == 1) {
            //学术业绩奖励
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateSkill perfRateSkill = skillService.selectPerfRateSkillById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateSkill.getSkillName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateSkill.getPriceAmount().subtract(perfRateSkill.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 2) {
            //成果、其他业绩奖
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateOther perfRateOther = otherService.selectPerfRateOtherById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateOther.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateOther.getPriceAmount().subtract(perfRateOther.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 3) {
            //平台业绩奖
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRatePlat perfRatePlat = platService.selectPerfRatePlatById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRatePlat.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRatePlat.getPriceAmount().subtract(perfRatePlat.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 4) {
            //教学-教材业绩奖励
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateTextbook perfRateTextbook = textbookService.selectPerfRateTextbookById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateTextbook.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateTextbook.getPriceAmount().subtract(perfRateTextbook.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 5) {
            //纵横向业绩奖励
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateVert perfRateVert = perfRateVertService.selectPerfRateVertById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateVert.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateVert.getPriceAmount().subtract(perfRateVert.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 6) {
            //学术著作业绩奖励
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateBook perfRateBook = perfRateBookService.selectPerfRateBookById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateBook.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateBook.getPriceAmount().subtract(perfRateBook.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 7) {
            //教学-竞赛业绩奖励
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateContest perfRateContest = perfRateContestService.selectPerfRateContestById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateContest.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateContest.getPriceAmount().subtract(perfRateContest.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        if(projType == 8) {
            //教学-竞赛业绩奖励
            PriceConfig priceConfigs = priceConfigService.selectPriceConfigById(priceType);
            PerfRateBase perfRateBase = perfRateBaseService.selectPerfRateBaseById(projId);
            PriceDetail priceDetail = new PriceDetail();
            priceDetail.setProjName(perfRateBase.getProjName());
            List<PriceDetail> priceDetails = priceDetailService.selectPriceDetailList(priceDetail);
            BigDecimal bigDecimal = perfRateBase.getPriceAmount().subtract(perfRateBase.getPriceAmount().multiply(priceConfigs.getRate())) ;
            for (PriceDetail detail : priceDetails) {
                if(detail.getPriceAmount() != null){
                    bigDecimal = bigDecimal.subtract(detail.getPriceAmount());
                }
            }
            return AjaxResult.success(bigDecimal.setScale(2, RoundingMode.HALF_DOWN));
        }
        return AjaxResult.success(BigDecimal.ZERO);
    }

    /**
     * 查询奖励分配列表
     */
    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PriceDetail priceDetail)
    {

        startPage();
        List<PriceDetail> list = priceDetailService.selectPriceDetailList(priceDetail);
        TableDataInfo dataTable = getDataTable(list);
        return dataTable;
    }

    /**
     * 导出奖励分配列表
     */
    @RequiresPermissions("system:detail:export")
    @Log(title = "奖励分配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PriceDetail priceDetail)
    {
        List<PriceDetail> list = priceDetailService.selectPriceDetailList(priceDetail);
        ExcelUtil<PriceDetail> util = new ExcelUtil<PriceDetail>(PriceDetail.class);
        return util.exportExcel(list, "奖励分配数据");
    }

    /**
     * 新增奖励分配
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存奖励分配
     */
    @RequiresPermissions("system:detail:add")
    @Log(title = "奖励分配", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PriceDetail priceDetail)
    {
        return toAjax(priceDetailService.insertPriceDetail(priceDetail));
    }

    /**
     * 修改奖励分配
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PriceDetail priceDetail = priceDetailService.selectPriceDetailById(id);
        mmap.put("priceDetail", priceDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存奖励分配
     */
    @RequiresPermissions("system:detail:edit")
    @Log(title = "奖励分配", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PriceDetail priceDetail)
    {
        return toAjax(priceDetailService.updatePriceDetail(priceDetail));
    }

    /**
     * 删除奖励分配
     */
    @RequiresPermissions("system:detail:remove")
    @Log(title = "奖励分配", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(priceDetailService.deletePriceDetailByIds(ids));
    }
}
