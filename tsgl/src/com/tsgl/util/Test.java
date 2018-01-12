package com.tsgl.util;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;  
  

import com.microsoft.sqlserver.jdbc.*;  

public class Test {
    public static Connection getConn() {
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url = "jdbc:oracle:thin:@127.0.0.1:1521:pdbmyoracle";// 设置连接字符串
        String url = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=tsgl";
        String username = "sa";// 用户名
        String password = "123456";// 密码
        Connection conn = null; // 创建数据库连接对象
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    private static void query() {
        Connection conn = getConn();
        String sql = "select * from T_USER";
        PreparedStatement pstmt;
        try {
            pstmt = conn.prepareStatement(sql);
            // 建立一个结果集,用来保存查询出来的结果

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("USERNAME");
                System.out.println(username);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        
        try
        {
           Connection conn = Test.getConn();
           if(conn!=null)
           {
               System.out.println("数据库连接正常！");
           }
           else
           {
               System.out.println("数据库连接异常！");
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
    

}