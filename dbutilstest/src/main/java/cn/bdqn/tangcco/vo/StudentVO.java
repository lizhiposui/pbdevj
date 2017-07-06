package cn.bdqn.tangcco.vo;

/**
 * Created by Administrator on 2017/6/28.
 */
public class StudentVO {
    private Integer stuid,gradeid,age;
    private String stuname,stunum,gender,gradename;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename;
    }

    @Override
    public String toString() {
        return "StudentVO{" +
                "stuid=" + stuid +
                ", gradeid=" + gradeid +
                ", age=" + age +
                ", stuname='" + stuname + '\'' +
                ", stunum='" + stunum + '\'' +
                ", gender='" + gender + '\'' +
                ", gradename='" + gradename + '\'' +
                '}';
    }
}
