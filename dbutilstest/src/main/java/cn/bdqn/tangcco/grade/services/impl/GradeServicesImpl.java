package cn.bdqn.tangcco.grade.services.impl;

import cn.bdqn.tangcco.grade.dao.GradeDao;
import cn.bdqn.tangcco.grade.dao.impl.GradeDaoImpl;
import cn.bdqn.tangcco.grade.services.GradeServices;
import cn.bdqn.tangcco.student.dao.StudentDao;
import cn.bdqn.tangcco.student.dao.impl.StudentDaoImpl;



/**
 * Created by Administrator on 2017/6/30.
 */
public class GradeServicesImpl implements GradeServices {
    private GradeDao gradeDao;
    private StudentDao studentDao;

    public GradeServicesImpl() {
        gradeDao = new GradeDaoImpl();
        studentDao = new StudentDaoImpl();
    }

    @Override
    public int deleteGrade(int id) throws Exception {
        studentDao.deleteStudentByGradeid(id);
        int rows = gradeDao.deleteGrade(id);
        if(rows>0){
            return rows;
        }
        return 0;
    }
}
