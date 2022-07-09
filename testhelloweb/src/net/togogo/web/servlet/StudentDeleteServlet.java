package net.togogo.web.servlet;

import net.togogo.web.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/stuDelete")
public class StudentDeleteServlet extends HttpServlet {
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        studentService.delete(Integer.parseInt(id));

        //重定向(让浏览器重新请求服务，按以下的地址)
        resp.sendRedirect("/stuList");
    }
}
