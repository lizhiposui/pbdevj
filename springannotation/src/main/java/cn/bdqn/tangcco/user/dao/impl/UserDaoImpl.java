package cn.bdqn.tangcco.user.dao.impl;

import cn.bdqn.tangcco.user.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/6/26.
 */
@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void sayHello() {
        System.out.println("这里是dao");
    }
}
