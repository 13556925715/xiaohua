package net.togogo.web.servlet;

import net.togogo.web.bean.Student;
import net.togogo.web.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stuUpdate")
public class StudentModifyServlet extends HttpServlet {
    String id;
    private StudentService studentService = new StudentService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(this.id);
        System.out.println("修改成功");
        String stuNO = req.getParameter("stuNo");
        String stuName = req.getParameter("stuName");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        Student student = new Student(Integer.parseInt(this.id),Integer.parseInt(stuNO),stuName,password,Integer.parseInt(age));
        studentService.update(student,Integer.parseInt(this.id));
        resp.sendRedirect("/stuList");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        this.id = id;
        req.setAttribute("id",id);
        req.getRequestDispatcher("/modify.jsp").forward(req,resp);

    }
}
