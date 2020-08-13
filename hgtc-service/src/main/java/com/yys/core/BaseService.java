package com.yys.core;


import java.util.List;

public interface BaseService<Pojo>{

    Pojo selectByPrimaryKey(Object key);

    Pojo selectOne(Pojo pojo);

    List<Pojo> selectByExample(Object example);

    List<Pojo> selectAll();

    int insert(Pojo entity);

    int insertSelective(Pojo entity);

    int deleteByPrimaryKey(Object key);

    int deleteByExample(Object example);

    int updateByPrimaryKey(Pojo entity);

    int updateNotNull(Pojo entity);

//    public Pojo selectOneByExample(Pojo example);

    public int selectCountByExample(Object example);

    public int insertList(List<Pojo> list);

    public int selectCount(Pojo entity);

    public List<Pojo> select(Pojo entity);
}
