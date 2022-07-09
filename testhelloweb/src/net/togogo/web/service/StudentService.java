package net.togogo.web.service;

import net.togogo.web.bean.Student;
import net.togogo.web.dao.StudentDAO;

import java.util.List;

public class StudentService {

    private StudentDAO studentDAO  = new StudentDAO();

    public void update(Student stu,Integer id){
        try {
            studentDAO.update(stu,id);
        }
        catch (Exception e){

        }
    }

    public void insert(Student stu){
        try {
            studentDAO.insert(stu);
        }catch (Exception e){
            e.printStackTrace();
            //写日志
        }
    }

    public List<Student> list(String keyword){
        try {
            return  studentDAO.list(keyword);
        }catch (Exception e){
            e.printStackTrace();
            //写日志
        }
        return null;
    }

    public void delete(Integer id){
        try {
            studentDAO.delete(id);
        }catch (Exception e){
            e.printStackTrace();
            //写日志
        }
    }
}
