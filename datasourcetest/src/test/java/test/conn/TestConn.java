package test.conn;

import cn.bdqn.tangcco.command.conn.ConnectionManager;
import org.junit.Test;

/**
 * Created by Administrator on 2017/7/4.
 */
public class TestConn {

    @Test
    public void testConn() {
        System.out.println(ConnectionManager.getConnection());
    }
}
