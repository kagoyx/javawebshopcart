package pers.yus.javaweb.control;

import pers.yus.javaweb.beans.Book;
import pers.yus.javaweb.dao.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "Edit", value = "/Edit")
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String author = request.getParameter("Author");
        String bookCount = request.getParameter("bookCount");
        System.out.println(id);
        System.out.println(name);
        System.out.println(price);
        System.out.println(author);
        System.out.println(bookCount);

        Book book =new Book();
//        HashMap<String, Book> list2 = (HashMap<String, Book>) request.getSession().getAttribute("list2");
        book.setName(String.valueOf(name));
        book.setPrice(Double.valueOf(price));
        book.setAuthor(String.valueOf(author));
        book.setBookCount(Integer.valueOf(bookCount));
//        fortest
//        System.out.println("update tb_books set name = '"+name+"' ,price = "+price+",Author = '"+author+"' ,bookCount="+bookCount+" where id="+id+"");

        new DBUtils().updateAndDelete("update tb_books set name = '"+name+"' ,price = "+price+",Author = '"+author+"' ,bookCount="+bookCount+" where id="+id+"");
        response.getWriter().print("<p>编辑成功！</p>");
        response.setHeader("refresh", "1,url=/javawebeclipseshopcart/bookStorage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
