package com.yys.service;

import com.yys.core.BaseService;
import com.yys.dao.Member;

public interface MemberService extends BaseService<Member>{
    int register(Member member);

    int updatePassword(Member member);

    int updateInfo(Member member);


    Member selectByPhone(String phone);
}
