package cn.bdqn.tangcco.user.dao;

import cn.bdqn.tangcco.command.pageresult.PageResult;
import cn.bdqn.tangcco.entity.Tbuser;

import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public interface UserDao {
    Tbuser login(Tbuser users);

    List<Tbuser> queryAllUser(Tbuser users,PageResult pages);

    int queryCountUser(Tbuser users);

    Tbuser queryUserById(int id);

    Tbuser queryUserByUsername(String username);

    int addUser(Tbuser users);

    int updateUser(Tbuser users);

    int deleteUser(int id);
}
