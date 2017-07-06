package test.grade;

import cn.bdqn.tangcco.entity.Grade;
import cn.bdqn.tangcco.entity.Student;
import cn.bdqn.tangcco.grade.dao.GradeDao;
import cn.bdqn.tangcco.grade.dao.impl.GradeDaoImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Administrator on 2017/6/29.
 */
public class TestGrade {
    private GradeDao gradeDao;

    @Before
    public void init() {
        gradeDao = new GradeDaoImpl();
    }


    @Test
    public void testQueryGradeById() {
        Grade grade = this.gradeDao.queryGradeById(1);
        for (Student student : grade.getStudents()) {
            System.out.println(grade.getGradename()+"\t"+student.getStuname());
        }
    }
}
