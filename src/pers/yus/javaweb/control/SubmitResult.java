package pers.yus.javaweb.control;

import pers.yus.javaweb.dao.DBUtils;
import pers.yus.javaweb.datasource.DataSourceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@WebServlet("/SubmitResult")
public class SubmitResult extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        PrintWriter out = response.getWriter();
        if (!code.equals(randStr)) {
            System.out.println("code.equals(randStr)");
            out.print("<script> alert(\"验证码错误! \");</script>");
            response.setHeader("refresh", "2,url=/javawebeclipseshopcart/Submit.jsp");
        } else {
//            String username = "123456";
//            String pwd = "654321";
            String admin = "admin";
            String adminPwd = "admin";
            String getUsername = request.getParameter("account");
            String getPassword = request.getParameter("password");
            System.out.println("username:" + getUsername);
            System.out.println("pwd:" + getPassword);

            if(isVaild(getUsername,getPassword)){
                response.getWriter().print("<p>Signing in</p>");
                response.setHeader("refresh", "1,url=/javawebeclipseshopcart/DoGet");
            }
//            if (username.equals(getUsername) && pwd.equals(getPassword)) {
//                response.getWriter().print("<p>Signing in</p>");
//                response.setHeader("refresh", "1,url=/javawebeclipseshopcart/DoGet");
//            }
            else if (admin.equals(getUsername) && adminPwd.equals(getPassword)) {

                response.setHeader("refresh", "1,url=/javawebeclipseshopcart/bookStorage.jsp");
            } else {
                response.getWriter().print("<script> alert(\"账号或密码错误! \");</script>");
                response.setHeader("refresh", "1,url=/javawebeclipseshopcart/Submit.jsp");
            }
        }
    }

    public boolean isVaild(String username, String password) {
        //String sql = "select * from user where username='"+this.username+"' and password='"+this.password+"'";
        String sql = "select * from users where username=? and password = ?";
//		System.out.println(sql);
        Connection conn = DataSourceUtil.initConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

//			stmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);
            pstmt.setObject(1, username);
            pstmt.setObject(2, password);
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


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
