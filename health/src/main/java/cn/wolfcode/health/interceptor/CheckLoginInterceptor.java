package cn.wolfcode.health.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckLoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        //对请求验证，验证当前是否登录
        HttpSession session = request.getSession();
        Object login  = session.getAttribute("login");
        System.out.println("拦截器"+login);

        if (login == null){
            request.setAttribute("errMsg","检测到未登录，请先登录");
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);
            return false;
        }


        //如果没有登录，跳转到登录页面，拦截请求

        //如果登录，直接放行
        return true;
    }

}
