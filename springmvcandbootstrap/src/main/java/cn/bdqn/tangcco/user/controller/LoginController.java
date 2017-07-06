package cn.bdqn.tangcco.user.controller;

import cn.bdqn.tangcco.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class LoginController {


    @RequestMapping(value = "loginController", method = RequestMethod.GET)
    @ResponseBody
    public Student login() {
        String sql = "";

        String json = "";
        System.out.println("hello world");
        Map<String, Object> map = new HashMap<>();
        return new Student(10086,12306,"杨凯","9527","01");
    }
}
