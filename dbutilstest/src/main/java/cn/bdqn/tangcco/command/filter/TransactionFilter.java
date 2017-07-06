package cn.bdqn.tangcco.command.filter;

import cn.bdqn.tangcco.command.context.ConnectionContext;
import cn.bdqn.tangcco.command.util.JDBCUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Administrator on 2017/6/30.
 */
@WebFilter(filterName = "/transactionFilter",urlPatterns = "*.action")
public class TransactionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            //开启事务
            JDBCUtils.startTransaction();
            //把数据库连接绑定到当前线程池
            ConnectionContext.getInstance().bind(connection);
            //把当前请求转发给给目标Servlet
            chain.doFilter(request,response);
            //提交事务
            JDBCUtils.commitTransaction();
        } catch (Exception e) {
            JDBCUtils.rollBackTransaction();
            e.printStackTrace();
            //重定向到错误页面
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse reps = (HttpServletResponse) response;
            String forward = req.getContextPath()+"/error.jsp";
            System.out.println(forward);
            reps.sendRedirect(req.getContextPath()+"/error.jsp");
        }finally {
            //解除当前线程池绑定Connection对象
            ConnectionContext.getInstance().remove();
            //关闭数据库连接
            JDBCUtils.closeConnection();
        }
    }

    @Override
    public void destroy() {

    }
}
