package com.yys.service;

import com.github.pagehelper.PageInfo;
import com.yys.core.BaseService;
import com.yys.dao.Pray;
import com.yys.page.BasePage;
import com.yys.request.PrayRequest;
import com.yys.response.PrayResponse;

import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 17:55
 */
public interface PrayService extends BaseService<Pray> {
//    int add(PrayRequest prayRequest);

//    int update(PrayRequest prayRequest);

    Pray selectByMemberId(Integer memberId);

    PageInfo<Pray> showListByPage(BasePage basePage);

    List<PrayResponse> quickMatch(Integer memberId);

    List<PrayResponse> selectByCondition(PrayRequest prayRequest);
}
