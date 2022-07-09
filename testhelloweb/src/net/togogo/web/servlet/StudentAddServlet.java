package net.togogo.web.servlet;

import net.togogo.web.bean.Student;
import net.togogo.web.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stuAdd")
public class StudentAddServlet extends HttpServlet {

    private StudentService studentService = new StudentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String stuNO = req.getParameter("stuNo");
        String stuName = req.getParameter("stuName");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        Student student = new Student(Integer.parseInt(stuNO),stuName,password,Integer.parseInt(age));
        studentService.insert(student);

        //重定向(让浏览器重新请求服务，按以下的地址)
        resp.sendRedirect("/stuList");
    }
}
