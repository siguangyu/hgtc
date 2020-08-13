package com.yys.core.impl;



import com.yys.core.BaseService;
import com.yys.core.mapper.BaseMapper;

import java.util.List;

public abstract class BaseServiceImpl<Pojo> implements BaseService<Pojo> {
    public abstract BaseMapper<Pojo> getMapper();

    @Override
    public Pojo selectByPrimaryKey(Object key) {
        return this.getMapper().selectByPrimaryKey(key);
    }


    @Override
    public List<Pojo> selectByExample(Object example) {
        return this.getMapper().selectByExample(example);
    }

    @Override
    public List<Pojo> selectAll() {
        return this.getMapper().selectAll();
    }

    @Override
    public int insert(Pojo entity) {
        return this.getMapper().insert(entity);
    }

    @Override
    public int insertSelective(Pojo entity) {
        return this.getMapper().insertSelective(entity);
    }

    @Override
    public int deleteByPrimaryKey(Object key) {
        return this.getMapper().deleteByPrimaryKey(key);
    }

    @Override
    public int deleteByExample(Object example) {
        return this.getMapper().deleteByExample(example);
    }

    @Override
    public int updateByPrimaryKey(Pojo entity) {
        return this.getMapper().updateByPrimaryKey(entity);
    }

    @Override
    public int updateNotNull(Pojo entity) {
        return this.getMapper().updateByPrimaryKeySelective(entity);
    }

    @Override
    public int selectCountByExample(Object example) {
        return this.getMapper().selectCountByExample(example);
    }

    @Override
    public int insertList(List<Pojo> list) {
        return this.getMapper().insertList(list);
    }

    @Override
    public int selectCount(Pojo entity) {
        return this.getMapper().selectCount(entity);
    }

    @Override
    public Pojo selectOne(Pojo entity) {
        return this.getMapper().selectOne(entity);
    }

    @Override
    public List<Pojo> select(Pojo entity) {
        return this.getMapper().select(entity);
    }


}
