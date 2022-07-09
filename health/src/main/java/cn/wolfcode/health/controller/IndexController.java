package cn.wolfcode.health.controller;

import cn.wolfcode.health.Util.VerifyCodeUtil;
import cn.wolfcode.health.domain.Admin;
import cn.wolfcode.health.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private LoginService loginService;
@RequestMapping("/")
    public String index(Model model, String f){
    model.addAttribute("f",f);
    //跳转页面
    return "index";

}

    @RequestMapping("/admin")
    public String adminLogin(){
    return "/login";

    }

    @RequestMapping("/dologin")
    public String dologin(String username,String password,HttpServletRequest request, String code,boolean ignoreCase){ //验证验证码对错
    try{
        Admin login = loginService.login(username, password, code, request);
        System.out.println(username+password+code);
        System.out.println("控制层"+login);
        //登录成功
        //根据request获取session对象
        HttpSession session = request.getSession();
        //待当前登录的对象存储到session中
        session.setAttribute("login",login);

    }
    catch (Exception e){
        String errMsg = e.getMessage();
        request.setAttribute("errMsg",errMsg);
        return "login";
    }

    return "redirect:/";


//        boolean verification = VerifyCodeUtil.verification(request, code, ignoreCase);
//        System.out.println("验证码对错:"+verification);
//        System.out.println("用户名"+username+"密码"+password);
//        if (username == null && password ==null){
//            return "/login";
//        }
//        else{
//            List<Admin> admins = adminService.selectAll();
//            for (Admin admin :admins){
//                System.out.println("用户名"+admin.getAdminName()+"密码"+admin.getAdminPassword());
//                if (username.equals(admin.getAdminName())  && password.equals(admin.getAdminPassword()) && verification){
//                    //登录成功
//                    //根据request获取session对象
//                    HttpSession session = request.getSession();
//                    //待当前登录的对象存储到session中
//                    session.setAttribute("admin",admin);
//                    System.out.println("登录成功");
//
//                    return "index";
//                }
//            }

//        }
        }
    @RequestMapping("/verifycode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response){
        VerifyCodeUtil.getVerifyCode(request,response);
    }



}
