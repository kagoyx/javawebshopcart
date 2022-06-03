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
    width: 150px;
    height: 200px;
    margin: 50px auto;
}
.p{
    width: 150px;
    height: 50px;
}
    </style>
</head>
<div class="wrapper">
    <div class="header">
        <div class="htitle">
            <h2>BookInfo</h2>
        </div>
    </div>
    <body align="center">
    <p>书名：${param.name }</p>
    <p>价格： ${param.price }</p>
    <p>作者： ${param.author }</p>
    <p>库存： ${param.bookCount }</p>

    <form action="showBook.jsp" method="post" onsubmit="return check(this)">
        <input type="hidden" name="start" value="1">
        <input type="submit" class="back" value="Back">
    </form>
    </body>
</div>

</html>