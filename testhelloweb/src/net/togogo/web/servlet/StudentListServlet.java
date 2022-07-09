package net.togogo.web.servlet;

import net.togogo.web.bean.Student;
import net.togogo.web.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stuList")
public class StudentListServlet extends HttpServlet {

    private StudentService  studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       List<Student> list = studentService.list(null);
       System.out.println("StudentListServlet list --->"+list);
       //把數據轉到頁面
       req.setAttribute("list",list);
       req.getRequestDispatcher("/stu-list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String keyword = req.getParameter("keyword");
        List<Student> list = studentService.list(keyword);
        System.out.println("StudentListServlet list --->"+list);
        //把數據轉到頁面
        req.setAttribute("list",list);
        req.getRequestDispatcher("/stu-list.jsp").forward(req,resp);
    }
}
