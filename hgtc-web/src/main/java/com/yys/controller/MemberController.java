package com.yys.controller;

import com.yys.common.CommonConstants;
import com.yys.common.MsgConstants;
import com.yys.dao.Member;
import com.yys.exception.HgtcException;
import com.yys.response.GenericResponse;
import com.yys.response.MemberResponse;
import com.yys.service.MemberService;
import com.yys.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Sigy
 * @date 2020/6/29 14:13
 */
@Slf4j
@RestController
@RequestMapping("member")
@Api(value = "用户接口相关", tags = "用户接口相关")
public class MemberController {

    @Autowired
    private MemberService service;


    @ApiOperation(value = "快速注册")
    @PostMapping("register")
    public GenericResponse register(@RequestBody Member member) {
        if (StringUtils.isBlank(member.getYysName())) {
//            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "阴阳师昵称");
            //随机分配一个昵称
            member.setYysName("未输入游戏昵称_"+NameUtils.randomName(true,3));

        }
        if (StringUtils.isBlank(member.getPassword())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "密码");
        }
        if (!CheckUtils.isMobile(member.getPhone())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_FORMAT_ERR, "手机号/登录账号", "184312345678");
        }
        if (service.selectByPhone(member.getPhone()) != null) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_DATA_ALREADY_EXISTS, "手机号");
        }

        int i = service.register(member);
        return i == 1 ? ResponseUtils.genSuccessResponse() : ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }

    @ApiOperation(value = "修改个人资料")
    @PostMapping("updateInfo")
    public GenericResponse updateInfo(@RequestBody Member member) {
        if (StringUtils.isBlank(member.getPhone())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "手机号/登录账号");
        }
        if (!CheckUtils.isMobile(member.getPhone())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_FORMAT_ERR, "手机号手机号/登录账号", "184312345678");
        }
       /* if (service.selectByPhone(member.getPhone()) != null) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_DATA_ALREADY_EXISTS, "手机号");
        }*/
        if (StringUtils.isBlank(member.getYysName())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "游戏内名字");
        }
        member.setPassword(null);
        int i = service.updateInfo(member);
        return i == 1 ? ResponseUtils.genSuccessResponse() : ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }

    @ApiOperation(value = "查询个人信息")
    @GetMapping("getInfo")
    public GenericResponse getInfo(HttpServletRequest request) {
        String userId = SessionUtils.getUserId(request.getSession());
        return ResponseUtils.genSuccessResponse(service.selectByPrimaryKey(userId));
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("updatePassword")
    public GenericResponse updatePassword(HttpServletRequest request, @RequestParam String password) {
        String userId = SessionUtils.getUserId(request.getSession());
        Member member = new Member();
        member.setId(Integer.valueOf(userId));
        if (StringUtils.isBlank(password)) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "密码");
        }
        member.setPassword(password);
        int i = service.updatePassword(member);
        return i == 1 ? ResponseUtils.genSuccessResponse() : ResponseUtils.genErrorResponse(MsgConstants.MSG_SYSTEM_ERR);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("login")
    public GenericResponse login(HttpServletRequest request, @RequestBody Member member) {
        if (StringUtils.isBlank(member.getPhone())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "手机号");
        }
        if (StringUtils.isBlank(member.getPassword())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_NOT_NULL, "密码");
        }

        Member m = service.selectByPhone(member.getPhone());
        if (m == null) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_ACCOUNT_NOT_EXISTS);
        }

        if (!CryptoUtils.matches(member.getPassword(), m.getPassword())) {
            return ResponseUtils.genErrorResponse(MsgConstants.MSG_FAIL_LOGIN);
        }
        String accessToken = UniqueIdUtils.createUniqueId();
        request.getSession().setAttribute(CommonConstants.SESSION_ACCESS_TOKEN, accessToken);
        request.getSession().setAttribute(CommonConstants.USER_ID, m.getId());
        request.getSession().setAttribute(CommonConstants.HOUSE_ID, m.getYysHouseId());
        MemberResponse memberResponse = new MemberResponse();
        memberResponse.setId(m.getId());
        memberResponse.setYysName(m.getYysName());
        memberResponse.setToken(accessToken);
        return ResponseUtils.genSuccessResponse(memberResponse);


    }


}
