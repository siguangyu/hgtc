package com.yys.service.impl; /**
 * @author Sigy
 * @date 2020/6/30 14:28
 */

import com.yys.core.impl.BaseServiceImpl;
import com.yys.core.mapper.BaseMapper;
import com.yys.dao.House;
import com.yys.mapper.HouseMapper;
import com.yys.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Sigy
 * @date 2020/6/30 14:28
 */
@Service
public class HouseServiceImpl extends BaseServiceImpl<House> implements HouseService {

    @Autowired
    private HouseMapper mapper;

    @Override
    public BaseMapper<House> getMapper() {
        return mapper;
    }

    @Override
    public int add(House house) {
        return mapper.insert(house);
    }
}
