package group.tonight.shop.controller;

import group.tonight.shop.bean.BaseResponseBean;
import group.tonight.shop.bean.User;
import group.tonight.shop.dao.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private UserJPA mUserJPA;

    @PostMapping(value = "/register")
    public BaseResponseBean register(HttpServletRequest httpServletRequest) {
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            System.out.println(string + " " + Arrays.toString(parameterMap.get(string)));
        }
        HttpSession httpSession = httpServletRequest.getSession();

        String verifyCode = (String) httpSession.getAttribute("verifyCode");
        String l_ipt = parameterMap.get("l_ipt")[0];

        if (!l_ipt.equals(verifyCode)) {
            return new BaseResponseBean(-1, "验证码错误");
        }

        if (!strings.contains("l_user")) {
            return new BaseResponseBean(-1, "缺少l_user参数");
        }
        String userName = parameterMap.get("l_user")[0];
        if ("".equals(userName)) {
            return new BaseResponseBean(-1, "用户名不能为空");
        }
        if (!strings.contains("l_pwd")) {
            return new BaseResponseBean(-1, "缺少l_pwd参数");
        }
        String password = parameterMap.get("l_pwd")[0];
        if ("".equals(password)) {
            return new BaseResponseBean(-1, "密码不能为空");
        }
        String l_email = parameterMap.get("l_email")[0];
        if ("".equals(l_email)) {
            return new BaseResponseBean(-1, "邮箱不能为空");
        }
        String l_tel = parameterMap.get("l_tel")[0];
        if ("".equals(l_tel)) {
            return new BaseResponseBean(-1, "手机不能为空");
        }
        String l_mem = parameterMap.get("l_mem")[0];
        String l_num = parameterMap.get("l_num")[0];

        User user = mUserJPA.findByUserName(userName);
        if (user != null) {
            return new BaseResponseBean(-1, "用户名已存在");
        }
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setEmail(l_email);
        newUser.setPhone(l_tel);
        newUser.setInviterName(l_mem);
        newUser.setInviterId(l_num);
        mUserJPA.save(newUser);

        return new BaseResponseBean(0, "register success");
    }

    @PostMapping(value = "/login")
    public BaseResponseBean login(HttpServletRequest httpServletRequest) {
        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        for (String string : strings) {
            System.out.println(string + " " + Arrays.toString(parameterMap.get(string)));
        }

        if (!strings.contains("l_user")) {
            return new BaseResponseBean(-1, "缺少l_user参数");
        }
        String userName = parameterMap.get("l_user")[0];
        if ("".equals(userName)) {
            return new BaseResponseBean(-1, "用户名不能为空");
        }
        if (!strings.contains("l_pwd")) {
            return new BaseResponseBean(-1, "缺少l_pwd参数");
        }
        String password = parameterMap.get("l_pwd")[0];
        if ("".equals(password)) {
            return new BaseResponseBean(-1, "密码不能为空");
        }

        User user = mUserJPA.findByUserName(userName);
        if (user == null) {
            return new BaseResponseBean(-1, "用户名不存在");
        }
        if (!user.getPassword().equals(password)) {
            return new BaseResponseBean(-1, "密码不正确");
        }
        System.out.println("登录成功：" + userName + " " + password);
        return new BaseResponseBean(0, "login success");
    }
}
