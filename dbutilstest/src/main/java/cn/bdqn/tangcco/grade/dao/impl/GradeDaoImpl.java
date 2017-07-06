package cn.bdqn.tangcco.grade.dao.impl;

import cn.bdqn.tangcco.command.context.ConnectionContext;
import cn.bdqn.tangcco.command.util.JDBCUtils;
import cn.bdqn.tangcco.entity.Grade;
import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.grade.dao.GradeDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/29.
 */
public class GradeDaoImpl implements GradeDao {
    private QueryRunner queryRunner;

    public GradeDaoImpl() {
        this.queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    }

    @Override
    public Grade queryGradeById(int id) {
        String sqlGrade = "select * from grade where gradeid=?";
        String sqlStudent = "select * from student where gradeid=?";
        try {
            Grade grade = this.queryRunner.query(sqlGrade, new BeanHandler<>(Grade.class), id);
            List<Student> students = this.queryRunner.query(sqlStudent, new BeanListHandler<>(Student.class), id);
            grade.setStudents(students);

            return grade;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    public int deleteGrade(int id) {
        String sql = "delete from grade where gradeid=?";
        try {
            return this.queryRunner.update(ConnectionContext.getInstance().getConnection(),sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
