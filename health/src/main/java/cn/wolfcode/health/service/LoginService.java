package cn.wolfcode.health.service;

import cn.wolfcode.health.domain.Admin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginService {
    public Admin login(String adminName, String adminPassword, String verifycode, HttpServletRequest request);
}
