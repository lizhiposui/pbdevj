package test.conn;

import cn.bdqn.tangcco.command.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/28.
 */
public class TestConn {
    private Connection connection;

    @Test
    public void testConn() {
        try {
            this.connection = JDBCUtils.getDataSource().getConnection();
            if (this.connection != null) {
                System.out.println(this.connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
