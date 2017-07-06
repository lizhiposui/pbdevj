package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Student {
    private Integer stuid, age;
    private String stuname, stunum, gender;

    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Student() {
    }


    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
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


    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", age=" + age +
                ", stuname='" + stuname + '\'' +
                ", stunum='" + stunum + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
