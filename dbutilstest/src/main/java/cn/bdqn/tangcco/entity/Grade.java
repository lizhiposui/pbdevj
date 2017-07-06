package cn.bdqn.tangcco.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Grade {
    private Integer gradeid;
    private String gradename;
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Grade() {
    }

    public Grade(String gradename) {
        this.gradename = gradename;
    }

    public Grade(Integer gradeid, String gradename) {
        this.gradeid = gradeid;
        this.gradename = gradename;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeid=" + gradeid +
                ", gradename='" + gradename + '\'' +
                '}';
    }
}
