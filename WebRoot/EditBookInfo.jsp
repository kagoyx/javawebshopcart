<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EditBookInfo.jsp</title>
    <style>
.wrapper{

}
.header{
    height: 120px;
}
.htitle{
    width: 400px;
    margin: 50px auto;
}
li{
    height: 40px;
    list-style-type: none;
    margin: 0 auto;

}
p{
    font-size: 1.75em;
}
p input{
    height: 30px;
}
.submit{
    background: #32bd40;
    color: #fff;
    font-size: 1.25em;
    width:50%;
    line-height:1.5em;
    outline: none;border: none;
}
.back{
    background: #32bd40;
    color: #fff;
    font-size: 1.25em;
    width:50%;
    line-height:1.5em;
    outline: none;border: none;
}
    </style>
</head>
<div class="wrapper">
    <div class="header">
        <div class="htitle">
            <h2 style="font-size: 4.5em;color:#006633;letter-spacing: 8px">Edit</h2>
        </div>
    </div>
    <body align="center">

<form action="Edit">
    <input type="hidden" name="id" value="${param.id }">
    <li><p>书名：<input type="text" value="${param.name}" name="name"></p></li>
    <li><p>价格：<input type="text" value="${param.price}" name="price"></p></li>
    <li><p>作者：<input type="text" value="${param.author}" name="Author"></p></li>
    <li><p>库存：<input type="text" value="${param.bookCount}" name="bookCount"></p></li>
    </br>
    </br>
    <input type="hidden" name="start" value="1">
    <input type="submit" class="submit" value="Submit">
</form>

<form action="bookStorage.jsp" method="post" onsubmit="return check(this)" style="margin-top: 50px">
    <input type="hidden" name="start" value="1">
    <input type="submit" class="back" value="Back">
</form>
    </body>
</div>

</html>