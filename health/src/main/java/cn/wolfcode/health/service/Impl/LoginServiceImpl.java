package cn.wolfcode.health.service.Impl;

import cn.wolfcode.health.Util.VerifyCodeUtil;
import cn.wolfcode.health.domain.Admin;
import cn.wolfcode.health.mapper.AdminMapper;
import cn.wolfcode.health.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin login(String adminName, String adminPassword, String verifycode, HttpServletRequest request) {
        boolean verification = VerifyCodeUtil.verification(request, verifycode, true);
        if (!verification){
            throw new RuntimeException("验证码错误");
        }
        adminPassword = DigestUtils.md5DigestAsHex(adminPassword.getBytes());
        Admin login = adminMapper.login(adminName,adminPassword);
        System.out.println("impl"+login);

        if (login == null){
            throw new RuntimeException("管理员账户或密码错误");
        }
        return login;
    }
}
