package vn.edu.hcmuaf.fit.demo7.dao.impl;

import vn.edu.hcmuaf.fit.demo7.configs.DBConnect;
import vn.edu.hcmuaf.fit.demo7.dao.IUserDao;
import vn.edu.hcmuaf.fit.demo7.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends DBConnect implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;

    @Override
    public List<User> findAll() {
        String sql = "select * from users";

        // List để truyền dữ liệu
        List<User> list = new ArrayList<>();

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            // next từng dòng đến cuối bảng
            while(rs.next()) {
                list.add(new User(rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("fullname"),
                        rs.getString("avatar"),
                        rs.getInt("roleid"),
                        rs.getString("phone"),
                        rs.getDate("createdDate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public User findById(int id) {
        String sql = "select * from users where id = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();

            if(rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("fullname"), rs.getString("avatar"),
                        rs.getInt("roleid"), rs.getString("phone"),
                        rs.getDate("createDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "insert into users(id, username, password, email, fullname, avatar, roleid, " +
                "phone, createDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getFullname());
            ps.setString(6, user.getAvatar());
            ps.setInt(7, user.getId());
            ps.setString(8, user.getPhone());
            ps.setDate(9, user.getCreateDate());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByUserName(String username) {
        String sql = "select * from users where username = ?";
        conn = getConnection();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);

            rs = ps.executeQuery();
            if(rs.next()) {
                return new User(rs.getInt("id"), rs.getString("username"),
                        rs.getString("password"), rs.getString("email"),
                        rs.getString("fullname"), rs.getString("avatar"),
                        rs.getInt("roleid"), rs.getString("phone"),
                        rs.getDate("createDate"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static void main(String[] args) {
        UserDaoImpl userImpl = new UserDaoImpl();

        System.out.println(userImpl.findById(2));
        System.out.println(userImpl.findByUserName("tham1"));
    }
}
