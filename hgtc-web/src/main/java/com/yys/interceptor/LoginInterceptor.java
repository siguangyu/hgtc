package com.yys.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Throwables;
import com.yys.common.CommonConstants;
import com.yys.common.MsgConstants;
import com.yys.response.GenericResponse;
import com.yys.service.MemberService;
import com.yys.utils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Objects;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("页面登陆拦截器begin：{}", request.getRequestURI());
        HttpSession session = request.getSession();
        session.setAttribute(CommonConstants.SESSION_ACCESS_TOKEN, "1240caf77ad51597220883568");
        session.setAttribute(CommonConstants.USER_ID, 1);
        session.setAttribute(CommonConstants.HOUSE_ID, null);

       /* String accessToken = request.getHeader(CommonConstants.HGTC_ACCESS_TOKEN);
        if (StringUtils.isBlank(accessToken)) {
            // access token 必须传入，否则报错
            outputErrorMsg(response, MsgConstants.MSG_USER_VERIFY_ERR);
            return false;
        }
        // 1. 检查两个前台传递的token和服务器保存的token是否相等
        String cacheToken = (String) session.getAttribute(CommonConstants.SESSION_ACCESS_TOKEN);
        if (!Objects.equals(cacheToken, accessToken)) {
            //token校验异常 报错
            outputErrorMsg(response, MsgConstants.MSG_USER_VERIFY_ERR);
            return false;
        }
        String userId = String.valueOf(session.getAttribute(CommonConstants.USER_ID));
        if (StringUtils.isBlank(userId)) {
            outputErrorMsg(response, MsgConstants.NO_BELONG_HOUSE);
            return false;
        }*/

        log.debug("页面登陆拦截器end ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // TODO Auto-generated method stub
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 返回错误信息
     *
     * @param response
     * @param code     错误码
     * @param args     错误参数
     */
    private void outputErrorMsg(HttpServletResponse response, String code, String... args) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        GenericResponse genericResponse = ResponseUtils.genErrorResponse(code, args);
        try (PrintWriter out = response.getWriter()) {
            out.write(JSONObject.toJSONString(genericResponse));
            out.flush();
        } catch (Exception e) {
            log.error("LoginInterceptor.preHandle" + Throwables.getStackTraceAsString(e));
        }
    }
}
