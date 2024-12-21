package vn.edu.hcmuaf.fit.demo7.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.edu.hcmuaf.fit.demo7.models.User;
import vn.edu.hcmuaf.fit.demo7.services.IUserService;
import vn.edu.hcmuaf.fit.demo7.services.impl.UserServiceImpl;
import vn.edu.hcmuaf.fit.demo7.utils.Constant;

import java.io.IOException;

@WebServlet(urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    // lấy toàn bộ hàm xử lý trong service
    IUserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lấy tham số từ view
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");

        //  kiểm tra tham số
        boolean isRememberMe = false;
        if("on".equals(rememberMe)) {
            isRememberMe = true;
        }
        String alertMsg = "";
        if(username.isEmpty() || password.isEmpty()) {
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        // xứ lý logic bài toán
        User user = userService.login(username, password);
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("account", user);

            // lưu cookie nếu cần ghi nhớ
            if (isRememberMe) {
                saveRememberMe(response, username);
            }
            // chuyển hướng sau khi đăng nhập thành công
            response.sendRedirect(request.getContextPath() + "/waiting");
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu sai";
            request.setAttribute("alert", alertMsg);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    private void saveRememberMe(HttpServletResponse response, String username) {
        // lưu thông tin trên trình duyệt của ai đó, dùng Cookie
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30*60);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }

}
