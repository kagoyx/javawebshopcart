<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Submit.jsp</title>
<link rel="stylesheet" href="./css/common.css">
<link rel="stylesheet" href="./css/index.css">
    <style>
        .login-container{
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        .form-login{
            width: 40%;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
        }
        .form-login .item{
            display: flex;
            align-items: center;
            width: 100%;
            margin-top: 8px;
        }
        .form-login .login-btn{
            width: 100%;
            height: 32px;
            background: green;
            border: none;
            color: white;
            user-select: none;
            outline: none;
        }
        .form-login .item>img{
            margin-right: 8px;
            width: 32px;
            height: 32px;
        }
        .form-login .item>input{
            flex: 1;
            width: 0;
            height: 32px;
        }

    </style>
</head>
<body>
<script type="text/javascript">
(function remSetting (win) {
    const doc = win.document
    const docEl = doc.documentElement
    let timer
    const refreshRem = function refreshRem () {
      let width = docEl.getBoundingClientRect().width
      if (width > 750) {
        width = 750
      } else if (width < 320) {
        width = 320
      }
      const rem = width / 7.5
      docEl.style.fontSize = rem + 'px'
    }
  
    win.addEventListener('resize', () => {
      clearTimeout(timer)
      timer = setTimeout(refreshRem, 300)
    }, false)
  
    win.addEventListener('pageshow', (e) => {
      if (e.persisted) {
        clearTimeout(timer)
        timer = setTimeout(refreshRem, 300)
      }
    }, false)
  
    if (doc.readyState === 'complete') {
      doc.body.style.fontSize = '12px'
    } else {
      doc.addEventListener('DOMContentLoaded', () => {
        doc.body.style.fontSize = '12px'
      }, false)
    }
  
    refreshRem()
  }(window))
 </script>
 <script type="text/javascript">
function validate(){
	if(loginForm.account.value==""){
		alert("账号不能为空！");
		return;
	}
	if(loginForm.password.value==""){
		alert("密码不能为空！");
		return;
	}
	loginForm.submit();
}
 </script>
 <script type="text/javascript">
 function refresh(){
	 var d = new Date();
	 loginForm.imgValidate.src = 'CodeServlet?t='+d.toString(38);
 }
 
 </script>
  

<div class="login-container">
    <form name="loginForm" class="form-login" id="formLogin" action="SubmitResult">
        <h2>Login</h2>
        <br>
        <div class="item">
            <img src="./img/user.png">
            <input name="account" type="text" placeholder="Please enter phone number" id="phone">
        </div>
        <div class="item">
            <img src="./img/pwd.png">
            <input name="password" type="password" placeholder="Please enter 6-16 digit password" minlength="6" maxlength="16" id="pwd">
        </div>
        <div class="item">
            <img style="width: 96px !important;" name="imgValidate" src="CodeServlet" border=0 onclick="refresh()">
            <input name="code" type="text" placeholder="Please enter validate code" length="4" id="code">
        </div>
        <br>
        <button type="button" class="login-btn" id="login" onClick="validate()">Sign in</button>
    </form>
</div>

</body>
</html>