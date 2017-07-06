package cn.bdqn.tangcco.command.context;

import java.sql.Connection;

/**
 * Created by Administrator on 2017/6/30.
 */
public class ConnectionContext {
    private static ConnectionContext context = new ConnectionContext();

    private ConnectionContext() {
    }

    public static ConnectionContext getInstance(){
        return context;
    }
    private ThreadLocal<Connection> local = new ThreadLocal<>();
    public void bind(Connection connection) {
        local.set(connection);
    }
    public Connection getConnection() {
        return local.get();
    }
    public void remove() {
        local.remove();
    }

}
