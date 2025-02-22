<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .password-container {
                position: relative;
                width: 100%;
            }

            .toggle-password {
                position: absolute;
                left:  140px;
                top: 50%;
                transform: translateY(-50%);
                cursor: pointer;
                font-size: 18px;
                color: #666; /* Màu xám nhẹ */
            }

        </style>
    </head>
    <body>
        <div id="login-frame">
            <h2>Login</h2>
            <form action="Login" method="POST" id="login-form">
                <p>
                    <label for="txtUserName">Username or Email</label><br>
                    <input type="text" id="txtUserName" name="txtUserName" placeholder="Enter Username or Email">
                </p>
                <h7 style="color: red">${requestScope.msg}</h7>
                <p>
                    <label for="txtPassword">Password</label><br>
                <div class="password-container">
                    <input type="password" id="txtPassword" name="txtPassword" placeholder="Enter Your Password">
                    <span class="toggle-password" onclick="togglePassword()">👁️</span>
                </div>
                </p>
                <button type="submit" name="btnAction" value="Login">Login</button>
            </form>
        </div>
        <script>
            function togglePassword() {
                let passwordField = document.getElementById("txtPassword");
                let toggleIcon = document.querySelector(".toggle-password");
                if (passwordField.type === "password") {
                    passwordField.type = "text";
                    toggleIcon.textContent = "🙈"; // Biểu tượng ẩn mật khẩu
                } else {
                    passwordField.type = "password";
                    toggleIcon.textContent = "👁️"; // Biểu tượng hiển thị mật khẩu
                }
            }
        </script>
    </body>
</html>
