package test.conn;

import cn.bdqn.tangcco.command.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/27.
 */
public class TestConn {

    private Connection connection;

    @Test
    public void testConn() {
        try {
            this.connection = JDBCUtils.getDataSource().getConnection();
            if (connection != null) {
                System.out.println(connection);
            }else{
                System.out.println("failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
