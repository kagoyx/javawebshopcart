package pers.yus.javaweb.testjdbcutil;

import pers.yus.javaweb.datasource.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description:
 * @Author: kago
 * @Date: 2022/5/22 9:04 下午
 **/
public class test {
    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM tb_books";
        Connection conn = DataSourceUtil.initConn();
        System.out.println(conn);
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

//        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            String name = resultSet.getString("name");
            System.out.println("name = " + name);
        }
        conn.close();
    }

}
