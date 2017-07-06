package cn.bdqn.tangcco.command.conn;


import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/7/4.
 */
public class ConnectionManager {
    private static DataSource dataSource;
    private static ThreadLocal<Connection> local = new ThreadLocal<>();

    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        Connection connection = null;
        connection = local.get();
        if (connection == null) {
            try {
                connection = dataSource.getConnection();
                local.set(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;

    }

    public static void closeConnection(PreparedStatement pstmt, ResultSet rs) {
        Connection connection = getConnection();


        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //一定从当前线程中移出connection对象
            local.remove();
        }


    }
}
