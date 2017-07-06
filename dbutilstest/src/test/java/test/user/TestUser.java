package test.user;

import cn.bdqn.tangcco.command.pageresult.PageResult;
import cn.bdqn.tangcco.entity.Tbuser;
import cn.bdqn.tangcco.user.dao.UserDao;
import cn.bdqn.tangcco.user.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/27.
 */
public class TestUser {
    private UserDao userDao;

    @Before
    public void init() {
        this.userDao = new UserDaoImpl();
    }

    @Test
    public void testUpdate() {
        System.out.println(this.userDao.updateUser(new Tbuser(17, "tangcco1", "5678", "04", "唐城和信")));

    }

    @Test
    public void testAdd() {
        System.out.println(this.userDao.addUser(new Tbuser("tangcco", "1234", "03", "唐城集团")));

    }
    @Test
    public void testDetail(){
        System.out.println(this.userDao.queryUserById(1));
    }

    @Test
    public void testCount() {
        System.out.println(this.userDao.queryCountUser(new Tbuser()));
    }

    @Test
    public void testQueryAll() {
        PageResult pages = new PageResult(1, 5);
        Tbuser users = new Tbuser();
        users.setUsername("a");
        users.setUserroles("04");
        for (Tbuser tbuser : this.userDao.queryAllUser(users,pages)) {
            System.out.println(tbuser);
        }
        System.out.println(this.userDao.queryCountUser(users));
    }

    @Test
    public void testQueryUserByUsername() {
        System.out.println(this.userDao.queryUserByUsername("admin"));
    }
    @Test
    public void testDelete() {
        System.out.println(this.userDao.deleteUser(17));
    }

    @Test
    public void testLogin() {
        System.out.println(this.userDao.login(new Tbuser("admin", "12345")));
    }
}
