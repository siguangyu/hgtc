package com.yys.mapper;

import com.yys.core.mapper.BaseMapper;
import com.yys.dao.Pray;
import com.yys.request.PrayRequest;
import com.yys.response.PrayResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PrayMapper extends BaseMapper<Pray> {

    List<Pray> matchWishFragment(String name,Integer memberId);


    List<PrayResponse> selectByCondition(PrayRequest prayRequest);
}