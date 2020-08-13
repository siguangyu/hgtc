package com.yys.service.impl; /**
 * @author Sigy
 * @date 2020/6/30 17:55
 */

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yys.core.BaseService;
import com.yys.core.impl.BaseServiceImpl;
import com.yys.core.mapper.BaseMapper;
import com.yys.dao.House;
import com.yys.dao.Member;
import com.yys.dao.Pray;
import com.yys.mapper.PrayMapper;
import com.yys.page.BasePage;
import com.yys.request.FragmentUtil;
import com.yys.request.PrayRequest;
import com.yys.response.PrayResponse;
import com.yys.service.HouseService;
import com.yys.service.MemberService;
import com.yys.service.PrayService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 17:55
 */
@Service
public class PrayServiceImpl extends BaseServiceImpl<Pray> implements PrayService {
    @Autowired
    private PrayMapper mapper;

    @Autowired
    private MemberService memberService;
    @Autowired
    private HouseService houseService;
    @Override
    public BaseMapper<Pray> getMapper() {
        return mapper;
    }


/*    @Override
    public int add(PrayRequest prayRequest) {
        List<FragmentUtil> ownList = prayRequest.getOwnList();
        Pray pray = new Pray();
        pray.setMemberId(prayRequest.getMemberId());
        if (CollectionUtils.isNotEmpty(ownList)) {
            pray.setOwnFragment(JSONObject.toJSONString(ownList));
        }
        List<FragmentUtil> wishList = prayRequest.getWishList();
        if (CollectionUtils.isNotEmpty(wishList)) {
            pray.setWishFragment(JSONObject.toJSONString(wishList));
        }
        pray.setCreateTime(new Date());
        return insert(pray);
    }

    @Override
    public int update(PrayRequest prayRequest) {
        List<FragmentUtil> ownList = prayRequest.getOwnList();
        Pray pray = new Pray();
        BeanUtils.copyProperties(prayRequest, pray);
        if (CollectionUtils.isNotEmpty(ownList)) {
            pray.setOwnFragment(JSONObject.toJSONString(ownList));
        }
        List<FragmentUtil> wishList = prayRequest.getWishList();
        if (CollectionUtils.isNotEmpty(wishList)) {
            pray.setWishFragment(JSONObject.toJSONString(wishList));
        }
        pray.setUpdateTime(new Date());
        return updateNotNull(pray);
    }*/

    @Override
    public Pray selectByMemberId(Integer memberId) {
        Pray pray = new Pray();
        pray.setMemberId(memberId);
        List<Pray> list = mapper.select(pray);
        return list.get(0);
    }

    @Override
    public PageInfo<Pray> showListByPage(BasePage basePage) {
        PageHelper.startPage(basePage.getPageNum(), basePage.getPageSize(), basePage.getOrderAndSort());
        List<Pray> list = selectAll();
        return new PageInfo<>(list);
    }

    @Override
    public List<PrayResponse> quickMatch(Integer memberId) {
        Pray pray = selectByMemberId(memberId);
        List<PrayResponse> resultList = new ArrayList();

     /*   List<FragmentUtil> wishFragmentUtils = JSONObject.parseArray(pray.getWishFragment(), FragmentUtil.class);
        List<FragmentUtil> ownFragmentUtils = JSONObject.parseArray(pray.getOwnFragment(), FragmentUtil.class);

        //遍历自己祈愿的碎片
        for (FragmentUtil wishFragmentUtil : wishFragmentUtils) {
            List<Pray> matchWishList = mapper.matchWishFragment(wishFragmentUtil.getName(), memberId);
            if (CollectionUtils.isNotEmpty(matchWishList)) {
                for (Pray matchWish : matchWishList) {
                    List<FragmentUtil> fragmentUtils = JSONObject.parseArray(matchWish.getWishFragment(), FragmentUtil.class);
                    for (FragmentUtil fragmentUtil : fragmentUtils) {
                        if (ownFragmentUtils.contains(fragmentUtil.getName())) {
                            PrayResponse prayResponse = new PrayResponse();
                            BeanUtils.copyProperties(matchWish, prayResponse);
                            //获取寮成员名字和阴阳寮名字
                            Member member = memberService.selectByPrimaryKey(matchWish.getMemberId());
                            prayResponse.setMemberName(member.getYysName());
                            House house = houseService.selectByPrimaryKey(member.getYysHouseId());
                            prayResponse.setHouseName(house.getName());
                            prayResponse.setHouseArea(house.getArea());
                            resultList.add(prayResponse);
                            //有一个式神碎片符合即可
                            break;
                        }
                    }
                }
            }
        }*/
        return resultList;
    }

    @Override
    public List<PrayResponse> selectByCondition(PrayRequest prayRequest) {
        return mapper.selectByCondition(prayRequest);
    }
}
