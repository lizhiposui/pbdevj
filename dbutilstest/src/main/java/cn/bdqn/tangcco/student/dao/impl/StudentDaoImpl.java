package cn.bdqn.tangcco.student.dao.impl;

import cn.bdqn.tangcco.command.context.ConnectionContext;
import cn.bdqn.tangcco.command.pageresult.PageResult;
import cn.bdqn.tangcco.command.util.JDBCUtils;
import cn.bdqn.tangcco.entity.Grade;
import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.student.dao.StudentDao;
import cn.bdqn.tangcco.vo.StudentVO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class StudentDaoImpl implements StudentDao {
    private QueryRunner queryRunner;

    public StudentDaoImpl() {
        this.queryRunner = new QueryRunner(JDBCUtils.getDataSource());
    }

    @Override
    public Student queryStudentById(int id) {
        String sqlStudent = "select * from student where stuid=?";
        String sqlGrade = "select * from grade where gradeid=(select gradeid from student where stuid=?)";

        try {
            Student student = this.queryRunner.query(sqlStudent, new BeanHandler<>(Student.class), id);
            Grade grade = this.queryRunner.query(sqlGrade, new BeanHandler<>(Grade.class), id);
            student.setGrade(grade);
            return student;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<StudentVO> queryAllStudent(PageResult pageResult) {
        String sql = "select s.*,g.gradename from student s,grade g where g.gradeid=s.gradeid order by s.stuid desc limit ?,?";
        try {
            return this.queryRunner.query(sql, new BeanListHandler<>(StudentVO.class),((pageResult.getPageNumber()-1)*pageResult.getPageSize()),pageResult.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteStudentByGradeid(int id) {
        String sql = "delete from student where gradeid=?";
        try {
            return this.queryRunner.update(ConnectionContext.getInstance().getConnection(),sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
