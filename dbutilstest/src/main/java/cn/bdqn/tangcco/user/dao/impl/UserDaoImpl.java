package cn.bdqn.tangcco.user.dao.impl;

import cn.bdqn.tangcco.command.pageresult.PageResult;
import cn.bdqn.tangcco.command.util.JDBCUtils;
import cn.bdqn.tangcco.entity.Tbuser;
import cn.bdqn.tangcco.user.dao.UserDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/27.
 */
public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner;

    public UserDaoImpl() {
        this.queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    }

    @Override
    public Tbuser login(Tbuser users) {
        String sql = "select * from tbuser where username=? and password=?";
        Object objs[] = new Object[]{users.getUsername(),users.getPassword()};

        try {
            return this.queryRunner.query(sql,new BeanHandler<>(Tbuser.class),objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Tbuser> queryAllUser(Tbuser users,PageResult pages) {
        String sql = "select * from tbuser  where 1=1 ";
        SQLFragment SQLFragment = new SQLFragment(users, pages, sql,true).invoke();
        sql = SQLFragment.getSql();
        Object[] objs = SQLFragment.getObjs();
        try {
            return this.queryRunner.query(sql, new BeanListHandler<>(Tbuser.class), objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int queryCountUser(Tbuser users) {
        String sql = "select count(*) from tbuser where 1=1 ";
        SQLFragment sqlFragment = new SQLFragment(users, null, sql, false).invoke();
        sql = sqlFragment.getSql();
        System.out.println(sql);
        Object objs[] = sqlFragment.getObjs();

        try {
            return this.queryRunner.query(sql, new ScalarHandler<Long>(),objs).intValue();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Tbuser queryUserById(int id) {
        String sql = "select * from tbuser where userid=?";
        try {
            return this.queryRunner.query(sql, new BeanHandler<>(Tbuser.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Tbuser queryUserByUsername(String username) {
        String sql = "select * from tbuser where username=?";
        try {
            return this.queryRunner.query(sql, new BeanHandler<>(Tbuser.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addUser(Tbuser users) {
        String sql = "insert into tbuser values (null,?,?,?,?)";
        Object objs[] = new Object[]{users.getUsername(), users.getPassword(), users.getUserroles(), users.getNickname()};
        try {
            return this.queryRunner.update(sql, objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateUser(Tbuser users) {
        String sql = "update tbuser set userroles=?,nickname=? where userid=?";
        Object objs[] = new Object[]{users.getUserroles(), users.getNickname(), users.getUserid()};
        try {
            return this.queryRunner.update(sql, objs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from tbuser where userid=?";
        try {
            return this.queryRunner.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private class SQLFragment {
        private Tbuser users;
        private PageResult pages;
        private String sql;
        private Object[] objs;
        private boolean flag;

        public SQLFragment(Tbuser users, PageResult pages, String sql,boolean flag) {
            this.users = users;
            this.pages = pages;
            this.sql = sql;
            this.flag = flag;
        }

        public String getSql() {
            return sql;
        }

        public Object[] getObjs() {
            return objs;
        }

        public SQLFragment invoke() {
            StringBuffer sb = new StringBuffer();
            List<Object> list = new java.util.ArrayList<>();
            sb.append(sql);
            if (users.getUsername() != null && !"".equals(users.getUsername())) {
                sb.append(" and username like ?");
                list.add("%" + users.getUsername() + "%");
            }
            if (users.getUserroles() != null && !"".equals(users.getUserroles())) {
                sb.append(" and userroles=?");
                list.add(users.getUserroles());
            }
            if(flag){
                sb.append(" order by userid desc limit ?,?");
                list.add((pages.getPageNumber() - 1) * pages.getPageSize());
                list.add(pages.getPageSize());

            }
            sql = sb.toString();

            objs = list.toArray(new Object[list.size()]);
            return this;
        }
    }
}
