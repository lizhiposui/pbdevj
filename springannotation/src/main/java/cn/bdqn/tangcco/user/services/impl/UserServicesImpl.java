package cn.bdqn.tangcco.user.services.impl;

import cn.bdqn.tangcco.user.dao.UserDao;
import cn.bdqn.tangcco.user.services.UserServices;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/6/26.
 */
@Service
public class UserServicesImpl implements UserServices{
    @Inject
    private UserDao userDao;
    @Override
    public void sayHello() {
        System.out.println("这里是service");
        this.userDao.sayHello();
    }
}
