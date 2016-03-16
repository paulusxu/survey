package eccrm.base.employee.web;


import com.ycrl.base.common.JspAccessType;
import com.ycrl.core.pager.PageVo;
import com.ycrl.core.web.BaseController;
import com.ycrl.utils.gson.GsonUtils;
import eccrm.base.employee.bo.BlankListBo;
import eccrm.base.employee.domain.BlankList;
import eccrm.base.employee.service.BlankListService;
import eccrm.base.employee.vo.BlankListVo;
import eccrm.base.employee.vo.EmployeeVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Generated by liuxq on 2014-10-22.
 */

@Controller
@RequestMapping(value = {"/mass/blanklist"})
public class BlankListCtrl extends BaseController {
    @Resource
    private BlankListService blankListService;

    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public String toList() {
        return "blanklist/list/blanklist_list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String toAdd(HttpServletRequest request) {
        request.setAttribute(JspAccessType.PAGE_TYPE, JspAccessType.ADD);
        return "mass/blankList/edit/blankList_edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void save(HttpServletRequest request, HttpServletResponse response) {
        BlankList blankList = GsonUtils.wrapDataToEntity(request, BlankList.class);
        blankListService.save(blankList);
        GsonUtils.printSuccess(response);
    }

    @RequestMapping(value = "/modify", params = {"id"}, method = RequestMethod.GET)
    public String toModify(@RequestParam String id, HttpServletRequest request) {
        request.setAttribute(JspAccessType.PAGE_TYPE, JspAccessType.MODIFY);
        request.setAttribute("id", id);
        return "mass/blankList/edit/blankList_edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public void update(HttpServletRequest request, HttpServletResponse response) {
        BlankList blankList = GsonUtils.wrapDataToEntity(request, BlankList.class);
        blankListService.update(blankList);
        GsonUtils.printSuccess(response);
    }


    @RequestMapping(value = {"/detail"}, params = {"id"}, method = RequestMethod.GET)
    public String toDetail(@RequestParam String id, HttpServletRequest request) {
        request.setAttribute(JspAccessType.PAGE_TYPE, JspAccessType.DETAIL);
        request.setAttribute("id", id);
        return "mass/blankList/edit/blankList_edit";
    }

    @ResponseBody
    @RequestMapping(value = "/get", params = {"id"}, method = RequestMethod.GET)
    public void findById(@RequestParam String id, HttpServletResponse response) {
        BlankListVo vo = blankListService.findById(id);
        GsonUtils.printData(response, vo);
    }


    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public void query(HttpServletRequest request, HttpServletResponse response) {
        BlankListBo bo = GsonUtils.wrapDataToEntity(request, BlankListBo.class);
        PageVo pageVo = blankListService.query(bo);
        GsonUtils.printData(response, pageVo);
    }

    @ResponseBody
    @RequestMapping(value = "/queryEmployees", method = RequestMethod.POST)
    public void queryEmployees(HttpServletRequest request, HttpServletResponse response) {
        BlankListBo bo = GsonUtils.wrapDataToEntity(request, BlankListBo.class);
        List<EmployeeVo> vos = blankListService.queryEmployees(bo);
        GsonUtils.printData(response, vos);
    }

    /**
     * 分页查询符合条件的白名单员工信息
     * 查询条件以流的方式（json）传递
     */
    @ResponseBody
    @RequestMapping(value = "/pageQueryEmployees", method = RequestMethod.POST)
    public void pageQueryEmployees(HttpServletRequest request, HttpServletResponse response) {
        BlankListBo bo = GsonUtils.wrapDataToEntity(request, BlankListBo.class);
        PageVo pageVo = blankListService.pageQueryEmployees(bo);
        GsonUtils.printData(response, pageVo);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", params = {"ids"}, method = RequestMethod.DELETE)
    public void deleteByIds(@RequestParam String ids, HttpServletResponse response) {
        String[] idArr = ids.split(",");
        blankListService.deleteByIds(idArr);
        GsonUtils.printSuccess(response);
    }

}