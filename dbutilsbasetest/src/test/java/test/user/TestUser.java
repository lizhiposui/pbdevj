package test.user;

import cn.bdqn.tangcco.command.pagresult.PageResult;
import cn.bdqn.tangcco.entity.Tbuser;
import cn.bdqn.tangcco.user.dao.UserDao;
import cn.bdqn.tangcco.user.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/28.
 */
public class TestUser {
    private UserDao userDao;

    @Before
    public void init() {
        this.userDao = new UserDaoImpl();
    }

    @Test
    public void testQueryAllUser() {
        Tbuser tbuser = new Tbuser();
        PageResult pageResult = new PageResult();
        pageResult.setPageNumber(1);
        pageResult.setPageSize(5);
        for (Tbuser users : this.userDao.queryAllUser(tbuser,pageResult)) {
            System.out.println(users);
        }
    }
}
