package test.services;

import cn.bdqn.tangcco.user.services.UserServices;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/6/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestUserServices {
    @Inject
    private UserServices userServices;

    @Test
    public void testSayHello() {
        userServices.sayHello();
    }
}
