package vn.edu.hcmuaf.fit.demo7.services;

import vn.edu.hcmuaf.fit.demo7.models.User;

public interface IUserService {
    User login(String username, String password);
    User findByUsername(String username);
}
