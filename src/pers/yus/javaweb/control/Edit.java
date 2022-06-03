package pers.yus.javaweb.control; /**
 * @Description: ${description}
 * @Author: kago
 * @Date: 2022/6/3 4:16 下午
 **/

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
        String prize = request.getParameter("prize");
        String author = request.getParameter("Author");
        System.out.println(name);
        System.out.println(prize);
        System.out.println(author);

        HashMap<String, Book> list2 = (HashMap<String, Book>) request.getSession().getAttribute("list2");
        list2.get(id).setName(String.valueOf(name));
        list2.get(id).setPrice(Integer.valueOf(prize));
        list2.get(id).setAuthor(String.valueOf(author));

        new DBUtils().updateAndDelete("update tb_books set name='"+name+"',set prize = '"+prize+"',set Author = '"+author+"' where id='"+id+"'");
        response.getWriter().print("<p>编辑成功！</p>");
        response.setHeader("refresh", "1,url=/javawebeclipseshopcart/bookStorage.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
