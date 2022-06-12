<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2022/6/11
  Time: 9:18 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" language="java" pageEncoding="UTF-8" %>
<!doctype html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
    .form-register{
        width: 40%;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        margin: 0 auto;
    }
    .form-register .item {
        display: flex;
        align-items: center;
        width: 100%;
        margin-top: 8px;
        margin-bottom: 10px;
    }
    .form-register .item>img {
        margin-right: 8px;
        width: 32px;
        height: 32px;
    }
    .item input{
        width: 100%;
        height: 32px;
        margin-left: 10px;
    }
    .register-btn{
        width: 100%;
        height: 32px;
        background: green;
        border: none;
        color: white;
        user-select: none;
        outline: none;
    }
    .back{
        width: 40%;
        height: 32px;
        background: green;
        border: none;
        color: white;
        user-select: none;
        outline: none;
        margin-top: 10px;
    }
    </style>
    <script type="text/javascript">
        function validate(){
            if(RegisterForm.username.value==""){
                alert("username can't be empty！");
                return;
            }
            if(RegisterForm.password.value==""){
                alert("password can't be empty！");
                return;
            }
            RegisterForm.submit();
        }
    </script>

</head>
<body>
<div style="text-align: center">
    <form  name="RegisterForm" action="RegisterServlet" class="form-register" id="formRegister"  method="post">
        <h2>Register</h2>
        <br>
        <div class="item">
            <img src="./img/user.png">
            <input name="username" type="text" placeholder="Please enter username" id="username">
            <span>${msg}</span>
        </div>
        <div class="item">
            <img src="./img/pwd.png">
            <input name="password" type="password" placeholder="Please enter 6-16 digit password" minlength="6" maxlength="16" id="password">
        </div>
        <br>
        <button type="button" class="register-btn" id="Register" onClick="validate()">Register</button>
    </form>
    <form action="Submit.jsp" method="post"><input type="submit" class="back" value="Back"></form>
</div>
</body>
</html>


