package vn.edu.hcmuaf.fit.demo7.dao;

import vn.edu.hcmuaf.fit.demo7.models.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();

    User findById(int id);

    void insert(User user);

    User findByUserName(String username);
}
