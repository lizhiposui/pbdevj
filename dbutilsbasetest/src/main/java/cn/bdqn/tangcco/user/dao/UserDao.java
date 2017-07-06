package cn.bdqn.tangcco.user.dao;

import cn.bdqn.tangcco.command.pagresult.PageResult;
import cn.bdqn.tangcco.entity.Tbuser;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface UserDao {
    List<Tbuser> queryAllUser(Tbuser users, PageResult pages);
}
