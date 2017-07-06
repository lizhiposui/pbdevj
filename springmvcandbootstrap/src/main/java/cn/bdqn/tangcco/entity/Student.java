package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/7/5.
 */
public class Student {
    private Integer stuid;
    private Integer gradeid;
    private String stuname,stunum,gender;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", gradeid=" + gradeid +
                ", stuname='" + stuname + '\'' +
                ", stunum='" + stunum + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public Integer getGradeid() {
        return gradeid;
    }

    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStunum() {
        return stunum;
    }

    public void setStunum(String stunum) {
        this.stunum = stunum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Student(Integer stuid, Integer gradeid, String stuname, String stunum, String gender) {
        this.stuid = stuid;
        this.gradeid = gradeid;
        this.stuname = stuname;
        this.stunum = stunum;
        this.gender = gender;
    }
}
