package com.yys.controller; /**
 * @author Sigy
 * @date 2020/6/30 17:44
 */

import com.yys.common.MsgConstants;
import com.yys.dao.Pray;
import com.yys.exception.HgtcException;
import com.yys.page.BasePage;
import com.yys.request.PrayRequest;
import com.yys.response.GenericResponse;
import com.yys.service.PrayService;
import com.yys.utils.ResponseUtils;
import com.yys.utils.SessionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 17:44
 */
@Slf4j
@RestController
@RequestMapping("pray")
@Api(value = "祈愿相关接口",tags = "祈愿相关接口")
public class PrayController {

   @Autowired
    private PrayService prayService;

  /*   @ApiOperation(value = "新增个人碎片信息", notes = "新增个人碎片信息")
    @PostMapping("/addPray")
    public GenericResponse add(HttpServletRequest request, @RequestBody PrayRequest prayRequest) {
        if (CollectionUtils.isEmpty(prayRequest.getOwnList()) || CollectionUtils.isEmpty(prayRequest.getWishList())) {
            throw new HgtcException(MsgConstants.MSG_NOT_NULL, "碎片");
        }
        prayRequest.setMemberId(Integer.valueOf(SessionUtils.getUserId(request.getSession())));
        int i = prayService.add(prayRequest);
        return i == 1 ? ResponseUtils.genSuccessResponse() : ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }

    @ApiOperation(value = "更新个人碎片信息", notes = "更新个人碎片信息")
    @PostMapping("update")
    public GenericResponse update(HttpServletRequest request, @RequestBody PrayRequest prayRequest) {
        if (CollectionUtils.isEmpty(prayRequest.getOwnList()) || CollectionUtils.isEmpty(prayRequest.getWishList())) {
            throw new HgtcException(MsgConstants.MSG_NOT_NULL, "碎片");
        }
        int i = prayService.update(prayRequest);
        return i == 1 ? ResponseUtils.genSuccessResponse() : ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }*/

    @ApiOperation(value = "查询个人碎片信息", notes = "查询个人碎片信息")
    @PostMapping("selectByMemberId")
    public GenericResponse selectByMemberId(HttpServletRequest request,PrayRequest prayRequest) {
        if (StringUtils.isBlank(prayRequest.getFragmentType())) {
            return ResponseUtils.genErrorResponse("请选择“可提供/祈愿”");
        }
        if (StringUtils.isBlank(prayRequest.getPrayType())) {
            return ResponseUtils.genErrorResponse("请选择碎片类型联动/SP/SSR");
        }
        prayRequest.setMemberId(1);
        return ResponseUtils.genSuccessResponse(prayService.selectByCondition(prayRequest));
//        return ResponseUtils.genSuccessResponse(prayService.selectByMemberId(Integer.valueOf(SessionUtils.getUserId(request.getSession()))));
    }

    @ApiOperation(value = "分页查询寮成员的碎片信息",notes = "分页查询寮成员的碎片信息")
    @GetMapping("showList")
    public GenericResponse showList(@RequestBody BasePage basePage){
        return ResponseUtils.genSuccessResponse(prayService.showListByPage(basePage));
    }

    @ApiOperation(value = "快速匹配出交易对象",notes = "快速匹配出交易对象")
    @GetMapping("quickMatch")
    public GenericResponse quickMath(HttpServletRequest requesst){
        String userId = SessionUtils.getUserId(requesst.getSession());
        return ResponseUtils.genSuccessResponse(prayService.quickMatch(Integer.valueOf(userId)));
    }
}
