package vn.edu.hcmuaf.fit.demo7.services.impl;

import vn.edu.hcmuaf.fit.demo7.dao.IUserDao;
import vn.edu.hcmuaf.fit.demo7.dao.impl.UserDaoImpl;
import vn.edu.hcmuaf.fit.demo7.models.User;
import vn.edu.hcmuaf.fit.demo7.services.IUserService;

public class UserServiceImpl implements IUserService {
    // lấy các hàm xử lý trong Dao
    IUserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        User user = this.findByUsername(username);
        if(user != null && password.equals(user.getPassword())) {
            return user;
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUserName(username);
    }
}
