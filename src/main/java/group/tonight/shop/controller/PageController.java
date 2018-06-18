package group.tonight.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping(value = "/")
    public String index() {
        System.out.println("/");
        return "Index_main";
    }

    @GetMapping(value = "/Login.html")
    public String Login() {
        System.out.println("/Login");
        return "Login";
    }

    @GetMapping(value = "/Regist.html")
    public String Regist() {
        System.out.println("/Regist");
        return "Regist";
    }

    @GetMapping(value = "/Member.html")
    public String Member() {
        System.out.println("/Member");
        return "Member";
    }
}
