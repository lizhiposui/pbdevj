package cn.bdqn.tangcco.command.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/6/28.
 */
public class JDBCUtils {


    private static DataSource dataSource;
    private static ThreadLocal<Connection> local = new ThreadLocal<>();


    static{
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }


    public static Connection getConnection() {
        Connection connection = local.get();
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
















































}
