<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container d-flex justify-content-center align-items-center vh-100">
    <div class="card shadow-sm p-4" style="max-width: 400px; width: 100%;">
        <h3 class="text-center mb-4">Đăng Nhập</h3>
        <form action="login" method="POST">
            <c:if test="${alert!=null}">
                <h6 class="alert alert-danger">${alert}</h6>
            </c:if>

            <!-- Username -->
            <div class="mb-3">
                <label for="username" class="form-label">Tài khoản</label>
                <input type="text" class="form-control" id="username" name="username" placeholder="Nhập tài khoản" required>
            </div>
            <!-- Password -->
            <div class="mb-3">
                <label for="password" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Nhập mật khẩu" required>
            </div>
            <!-- Remember Me -->
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" name="rememberMe" id="rememberMe">
                <label class="form-check-label" for="rememberMe">Ghi nhớ đăng nhập</label>
            </div>
            <!-- Submit Button -->
            <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
        </form>
    </div>
</div>

<!-- Link Bootstrap JS (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

