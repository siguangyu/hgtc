package com.yys.utils; /**
 * @author Sigy
 * @date 2020/6/30 17:24
 */

import com.yys.common.CommonConstants;

import javax.servlet.http.HttpSession;

/**
 * @author Sigy
 * @date 2020/6/30 17:24
 */
public class SessionUtils {

    public static String getUserId(HttpSession session) {
        return String.valueOf(session.getAttribute(CommonConstants.USER_ID));
    }

    public static void setUserId(HttpSession session, String userId) {
        session.setAttribute(CommonConstants.USER_ID,userId);
    }



    public static String getToken(HttpSession session) {
        return (String) session.getAttribute(CommonConstants.SESSION_ACCESS_TOKEN);
    }

    public static void setToken(HttpSession session, String uuid) {
        session.setAttribute(CommonConstants.SESSION_ACCESS_TOKEN,uuid);
    }

}
