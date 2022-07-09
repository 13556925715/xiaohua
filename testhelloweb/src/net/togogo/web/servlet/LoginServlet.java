package net.togogo.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

             //接受参数
             String username = req.getParameter("username");
             String password = req.getParameter("password");
             System.out.println("用户名："+username+" ,密码："+password);

             //判断登录成功，还是失败
             if("123456".equals(password)){
                 //通过一个KEY,设计返回页面的内容
                 req.setAttribute("msg",username+",登录成功...");
                 //跳转到成功的页面
                 req.getRequestDispatcher("/succ.jsp").forward(req,resp);
             }else {
                 //通过一个KEY,设计返回页面的内容
                 req.setAttribute("msg",username+",登录失败,密码不是123456...");
                 //跳转到失败的页面
                 req.getRequestDispatcher("/fail.jsp").forward(req,resp);
             }
    }
}
