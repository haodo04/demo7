package vn.edu.hcmuaf.fit.demo7.models;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String avatar;
    private int roleid;
    private String phone;
    private Date createDate;

    public User(int id, String username, String password, String email, String fullname, String avatar, int roleid, String phone, Date createDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.avatar = avatar;
        this.roleid = roleid;
        this.phone = phone;
        this.createDate = createDate;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roleid=" + roleid +
                ", phone='" + phone + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}