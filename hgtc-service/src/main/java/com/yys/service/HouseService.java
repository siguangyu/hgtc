package com.yys.service;

import com.yys.core.BaseService;
import com.yys.dao.House;

/**
 * @author Sigy
 * @date 2020/6/30 14:27
 */
public interface HouseService extends BaseService<House>{
    int add(House house);
}
