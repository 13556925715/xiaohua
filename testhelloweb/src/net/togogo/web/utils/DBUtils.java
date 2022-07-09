package net.togogo.web.utils;

import java.sql.*;

public class DBUtils {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        DBUtils utils = new DBUtils();
        //utils.insert();
        utils.select();
    }

    void insert() throws ClassNotFoundException, SQLException {
        //1.加载 MySQL驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.提供用户名、密码、连接信息
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        //3.创建的MySQL的连接
        Connection conn = DriverManager.getConnection(url,username,password);

        //4.编写一条查询语句
        String sql = "insert into t_student(stu_no,stu_name,password,age) values (20210901,'张三','123456',19)";
        //String sql = "insert into t_student(stu_no,stu_name,password,age) values (20210902,'李四','123456',20)";
        //修改
        //String sql = " update t_student t set stu_name='ZHang3' where stu_no=20210901 ";
        //删除
        //String sql = "delete from t_student where stu_no =20210901 ";

        //5.输出查询结果
        Statement  stm =  conn.createStatement();
        boolean flag = stm.execute(sql);

        //6.关闭连接
        stm.close();
        conn.close();
    }

    void select() throws ClassNotFoundException, SQLException {
        //1.加载 MySQL驱动类
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.提供用户名、密码、连接信息
        String username = "root";
        String password = "123456";
        String url = "jdbc:mysql://127.0.0.1:3306/test";
        //3.创建的MySQL的连接
        Connection conn = DriverManager.getConnection(url,username,password);

        //4.编写一条查询语句
        String sql = "select * from t_student ";

        //5.输出查询结果
        Statement  stm =  conn.createStatement();
        ResultSet  rs =  stm.executeQuery(sql);
        while (rs.next()){
            System.out.println(rs.getString(1)+","+rs.getString(2)+" ,"+rs.getString(3)+" ,"+rs.getString(4));
        }
        //6.关闭连接
        rs.close();
        stm.close();
        conn.close();
    }


}
