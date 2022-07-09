package cn.wolfcode.health.Util;

import org.springframework.util.DigestUtils;

public class Test {
    public static void main(String[] args) {
        String password = "admin";
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);
    }

}
