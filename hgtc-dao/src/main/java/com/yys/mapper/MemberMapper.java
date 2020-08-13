package com.yys.mapper;

import com.yys.core.mapper.BaseMapper;
import com.yys.dao.Member;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberMapper extends BaseMapper<Member> {
}