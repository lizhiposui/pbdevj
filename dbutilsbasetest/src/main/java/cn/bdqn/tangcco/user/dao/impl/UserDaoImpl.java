package cn.bdqn.tangcco.user.dao.impl;

import cn.bdqn.tangcco.command.base.dao.impl.BaseDaoImpl;
import cn.bdqn.tangcco.command.pagresult.PageResult;
import cn.bdqn.tangcco.entity.Tbuser;
import cn.bdqn.tangcco.user.dao.UserDao;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class UserDaoImpl extends BaseDaoImpl<Tbuser> implements UserDao  {
    @Override
    public List<Tbuser> queryAllUser(Tbuser users, PageResult pages) {
        String sql = "select * from tbuser order by userid desc limit ?,?";
        List<Object> list = new java.util.ArrayList<>();

        list.add((pages.getPageNumber()-1)*pages.getPageSize());
        list.add(pages.getPageSize());
        Object objs[] = list.toArray(new Object[list.size()]);

        return this.queryAllEntity(sql,objs);

    }
}
