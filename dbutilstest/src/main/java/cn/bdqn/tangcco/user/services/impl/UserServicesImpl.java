package cn.bdqn.tangcco.user.services.impl;

import cn.bdqn.tangcco.entity.Tbuser;
import cn.bdqn.tangcco.user.dao.UserDao;
import cn.bdqn.tangcco.user.dao.impl.UserDaoImpl;
import cn.bdqn.tangcco.user.services.UserServices;

/**
 * Created by Administrator on 2017/6/30.
 */
public class UserServicesImpl implements UserServices {
    private UserDao userDao;

    public UserServicesImpl() {
        this.userDao = new UserDaoImpl();
    }

    @Override
    public Tbuser login(Tbuser tbuser) {
        return this.userDao.login(tbuser);
    }
}
