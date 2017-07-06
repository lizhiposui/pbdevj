package cn.bdqn.tangcco.command.base.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface BaseDao<T> {


    List<T> queryAllEntity(String sql, Object objs[]);
}
