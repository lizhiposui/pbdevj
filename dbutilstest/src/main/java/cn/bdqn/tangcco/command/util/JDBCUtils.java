package cn.bdqn.tangcco.command.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.xml.internal.messaging.saaj.util.FinalArrayList;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/**
 * Created by Administrator on 2017/6/27.
 */
public class JDBCUtils {

    private static DataSource dataSource;
    private static ThreadLocal<Connection> local = new ThreadLocal<>();


    static {
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

    //开启事务，关闭自动提交
    public static void startTransaction() {
        Connection connection = getConnection();
        try {
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //操作成功，提交事务
    public static void commitTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //操作失败，回滚事务
    public static void rollBackTransaction() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭数据库连接
    public static void closeConnection() {
        Connection connection = getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                //一定要在当前线程中移出连接
                local.remove();
            }
        }

    }




}
