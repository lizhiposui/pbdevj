package cn.bdqn.tangcco.command.singleton;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Administrator on 2017/7/4.
 */
public class DBProperties {

    private static Properties properties;
    private static DBProperties dbProperties = new DBProperties();

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static DBProperties getInstance() {
        return dbProperties;
    }


    private  DBProperties() {
        properties = new Properties();
        try {
            properties.load(DBProperties.class.getClass().getResourceAsStream("/c3p0.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
