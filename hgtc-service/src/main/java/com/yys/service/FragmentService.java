package com.yys.service;

import com.yys.core.BaseService;
import com.yys.core.impl.BaseServiceImpl;
import com.yys.dao.Fragment;

import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 11:23
 */
public interface FragmentService extends BaseService<Fragment>{
    int add(Fragment fragment);

    List<Fragment> all();
}
