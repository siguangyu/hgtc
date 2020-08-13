package com.yys.service.impl; /**
 * @author Sigy
 * @date 2020/6/30 14:55
 */

import com.yys.common.MsgConstants;
import com.yys.core.impl.BaseServiceImpl;
import com.yys.core.mapper.BaseMapper;
import com.yys.dao.House;
import com.yys.dao.Member;
import com.yys.exception.HgtcException;
import com.yys.mapper.MemberMapper;
import com.yys.service.HouseService;
import com.yys.service.MemberService;
import com.yys.utils.CryptoUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 14:55
 */
@Service
public class MemberServiceImpl extends BaseServiceImpl<Member> implements MemberService {

    @Autowired
    private MemberMapper mapper;

    @Autowired
    private HouseService houseService;

    @Override
    public BaseMapper<Member> getMapper() {
        return mapper;
    }

    @Override
    public int register(Member member) {
        member.setPassword(CryptoUtils.encode(member.getPassword()));
        return insert(member);
    }

    @Override
    public int updatePassword(Member member) {
        member.setPassword(CryptoUtils.encode(member.getPassword()));
        return updateNotNull(member);
    }

    @Override
    public int updateInfo(Member member) {
        //阴阳寮验证
      /*  House house = houseService.selectByPrimaryKey(member.getYysHouseId());
        if (house == null) {
            throw new HgtcException(MsgConstants.MSG_FILE_NOT_EXIST);
        }*/
        return updateNotNull(member);
    }



    @Override
    public Member selectByPhone(String phone) {
        Member member = new Member();
        member.setPhone(phone);
        List<Member> list = select(member);
        if (CollectionUtils.isNotEmpty(list) && list.size() > 1) {
            throw new HgtcException(MsgConstants.MSG_SYSTEM_ERR);
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
