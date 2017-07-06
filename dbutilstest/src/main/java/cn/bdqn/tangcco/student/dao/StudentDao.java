package cn.bdqn.tangcco.student.dao;

import cn.bdqn.tangcco.command.pageresult.PageResult;
import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.vo.StudentVO;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public interface StudentDao {
    Student queryStudentById(int id);
    List<StudentVO> queryAllStudent(PageResult pageResult);
    int deleteStudentByGradeid(int id);
}
