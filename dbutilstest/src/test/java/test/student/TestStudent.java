package test.student;

import cn.bdqn.tangcco.command.pageresult.PageResult;
import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.student.dao.StudentDao;
import cn.bdqn.tangcco.student.dao.impl.StudentDaoImpl;
import cn.bdqn.tangcco.vo.StudentVO;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/28.
 */
public class TestStudent {
    private StudentDao studentDao;

    @Before
    public void init() {
        studentDao = new StudentDaoImpl();
    }
    @Test
    public  void testQueryStudentById() {
        Student student = this.studentDao.queryStudentById(1);
        System.out.println(student.getGrade().getGradename()+"\t"+student.getStuname());
    }

    @Test
    public void testQueryAllStudent() {
        for (StudentVO vo : this.studentDao.queryAllStudent(new PageResult(1, 5))) {
            System.out.println(vo);
        }
    }














}
