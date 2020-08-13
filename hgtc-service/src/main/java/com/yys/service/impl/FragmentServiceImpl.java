package com.yys.service.impl; /**
 * @author Sigy
 * @date 2020/6/30 11:24
 */

import com.yys.core.impl.BaseServiceImpl;
import com.yys.core.mapper.BaseMapper;
import com.yys.dao.Fragment;
import com.yys.mapper.FragmentMapper;
import com.yys.service.FragmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Sigy
 * @date 2020/6/30 11:24
 */
@Service
public class FragmentServiceImpl extends BaseServiceImpl<Fragment> implements FragmentService {

    @Autowired
    private FragmentMapper mapper;

    @Override
    public BaseMapper<Fragment> getMapper() {
        return mapper;
    }

    @Override
    public int add(Fragment fragment) {
        return mapper.insert(fragment);
    }

    @Override
    public List<Fragment> all() {
        return mapper.selectAll();
    }
}
