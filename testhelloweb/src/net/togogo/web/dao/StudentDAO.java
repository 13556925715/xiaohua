package net.togogo.web.dao;

import net.togogo.web.bean.Student;
import net.togogo.web.utils.DBTools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void insert(Student stu) throws SQLException, ClassNotFoundException {
        String sql = "insert into t_student(stu_no,stu_name,password,age) values("+stu.getStuNo()+",'"+stu.getStuName()+"','"+stu.getPassword()+"',"+stu.getAge()+")";
        Connection conn = DBTools.getConnection();
        Statement stm = conn.createStatement();
        stm.execute(sql);
        DBTools.close(null,stm,conn);
    }
    public void update(Student stu,Integer id) throws SQLException,ClassNotFoundException{
        String sql = "UPDATE t_student SET id="+stu.getId()+" , stu_no = "+stu.getStuNo()+" , stu_name = '"+stu.getStuName()+"' , password = '"+stu.getPassword()+"' , age = "+stu.getAge()+" WHERE id ="+id;
        Connection conn = DBTools.getConnection();
        Statement stm = conn.createStatement();
        stm.execute(sql);
        DBTools.close(null,stm,conn);
    }

    public List<Student> list(String keyword) throws SQLException, ClassNotFoundException {
        String sql = "select id ,stu_no,stu_name,password,age  from t_student where 1=1 ";
        if(null != keyword && !"".equals(keyword)){
             sql+=" and (stu_no LIKE '%"+keyword+"%'  OR stu_name LIKE '%"+keyword+"%' ) ";
        }

        System.out.println("SQL: "+sql);
        Connection conn = DBTools.getConnection();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Student> list = new ArrayList<>();
        Student student = null;
        while (rs.next()){
           int id =  rs.getInt(1);
           int stuNo = rs.getInt(2);
           String stuName= rs.getString(3);
           String password = rs.getString(4);
           int age = rs.getInt(5);
           student = new Student(id,stuNo,stuName,password,age);
           list.add(student);
        }
        DBTools.close(rs,stm,conn);
        System.out.println("StudentDAO list --->"+list);
        return list;
    }

    public void delete(Integer id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM t_student WHERE id = "+id;
        Connection conn = DBTools.getConnection();
        Statement stm = conn.createStatement();
        stm.execute(sql);
        DBTools.close(null,stm,conn);
    }
}
