package cn.bdqn.tangcco.entity;

/**
 * Created by Administrator on 2017/6/28.
 */
public class Tbuser {
    private Integer userid;
    private String username,password,userroles,nickname;

    public Tbuser() {
    }

    public Tbuser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Tbuser(String username, String password, String userroles, String nickname) {
        this.username = username;
        this.password = password;
        this.userroles = userroles;
        this.nickname = nickname;
    }

    public Tbuser(Integer userid, String username, String password, String userroles, String nickname) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.userroles = userroles;
        this.nickname = nickname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserroles() {
        return userroles;
    }

    public void setUserroles(String userroles) {
        this.userroles = userroles;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Tbuser{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userroles='" + userroles + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
