package net.togogo.web.utils;


import java.sql.*;

public class DBTools {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "123456";
    private static String url = "jdbc:mysql://127.0.0.1:3306/test";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //1.加载 MySQL驱动类
        Class.forName(driver);
        //3.创建的MySQL的连接
        Connection conn = DriverManager.getConnection(url,username,password);
        return  conn;
    }

    public static void close(ResultSet rs, Statement stm ,Connection conn) throws SQLException {
        if(rs != null){
            rs.close();
        }
        if(stm != null){
            stm.close();
        }
        if(conn != null){
            conn.close();
        }
    }
}
