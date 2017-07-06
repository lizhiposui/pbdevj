package test.grade.services;

import cn.bdqn.tangcco.grade.services.GradeServices;
import cn.bdqn.tangcco.grade.services.impl.GradeServicesImpl;
import org.junit.Before;
import org.junit.Test;
/**
 * Created by Administrator on 2017/6/30.
 */
public class TestGradeServices {

    private GradeServices gradeServices;

    @Before
    public void init() {
        this.gradeServices = new GradeServicesImpl();
    }

    @Test
    public void testDeleteGradeById() throws Exception {
        System.out.println(this.gradeServices.deleteGrade(14));
    }


}
