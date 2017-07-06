package cn.bdqn.tangcco.command.base.dao.impl;

import cn.bdqn.tangcco.command.base.dao.BaseDao;
import cn.bdqn.tangcco.command.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private QueryRunner queryRunner;
    private Class<T> clazz;


    public BaseDaoImpl() {
        this.queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Type type = this.getClass().getGenericSuperclass();

        clazz = (Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
    }

    @Override
    public List<T> queryAllEntity(String sql, Object[] objs) {
        try {
            return this.queryRunner.query(sql, new BeanListHandler<>(clazz), objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
