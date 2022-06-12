package pers.yus.javaweb.control; /**
 * @Description: ${description}
 * @Author: kago
 * @Date: 2022/6/12 3:29 下午
 **/

import pers.yus.javaweb.datasource.DataSourceUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.PathMatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        this.doPost(request, response);
        String getUsername = request.getParameter("username");
        if(getUsername!=null) {
            if (isExist(getUsername)) {
                response.getWriter().print("<script> alert(\"login has failed,The user already exists \");</script>");
                response.setHeader("refresh", "1,url=/javawebeclipseshopcart/Register.jsp");
            } else {
                String getPassword = request.getParameter("password");
                System.out.println("username:" + getUsername);
                System.out.println("pwd:" + getPassword);
                String sql = "INSERT INTO Users values(?,?)";
                // connect database and insert data to table users;
                Connection conn = DataSourceUtil.initConn();
                try {
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, getUsername);
                    pstmt.setString(2, getPassword);
                    pstmt.executeUpdate();
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                response.getWriter().print("<script> alert(\"Successfully registered \");</script>");
                response.setHeader("refresh", "1,url=/javawebeclipseshopcart/Submit.jsp");
            }
        }else {
            response.setHeader("refresh", "1,url=/javawebeclipseshopcart/Submit.jsp");
        }
    }
    public boolean isExist(String username) {
        String sql = "select * from users where username=?";
        Connection conn = DataSourceUtil.initConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            rs = null;
            try {
                if (pstmt != null)
                    pstmt.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            pstmt = null;
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            conn = null;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
