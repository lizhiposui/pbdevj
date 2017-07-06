package cn.bdqn.tangcco.grade.action;

import cn.bdqn.tangcco.grade.services.GradeServices;
import cn.bdqn.tangcco.grade.services.impl.GradeServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2017/6/30.
 */
@WebServlet(name = "DoDeleteGradeServlet", urlPatterns = "/doDeleteGrade.action")
public class DoDeleteGradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strGradeid = request.getParameter("gradeid");
        int gradeid = 0;
        if (strGradeid != null&&!"".equals(strGradeid)) {
            gradeid = Integer.parseInt(strGradeid);
        }
        GradeServices gradeServices = new GradeServicesImpl();
        try {
            int rows = gradeServices.deleteGrade(gradeid);
            response.sendRedirect("doListGrade.action");
        } catch (Exception e) {
            e.printStackTrace();
            //注意：调用service层的方法出异常之后，继续将异常抛出，
            //这样在TransactionFilter就能捕获到抛出的异常，继而执行事务回滚操作
            throw new RuntimeException();
        }
    }
}
