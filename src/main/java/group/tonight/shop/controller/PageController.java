package group.tonight.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PageController {
    @GetMapping(value = "/")
    public String index() {
        System.out.println("/");
        return "Index";
    }

//    @GetMapping(value = "/Index.html")
//    public String Index() {
//        System.out.println("/");
//        return "Index";
//    }
//
//    @GetMapping(value = "/Login.html")
//    public String Login() {
//        System.out.println("/Login");
//        return "Login";
//    }
//
//    @GetMapping(value = "/Regist.html")
//    public String Regist() {
//        System.out.println("/Regist");
//        return "Regist";
//    }
//
//    @GetMapping(value = "/Member.html")
//    public String Member() {
//        System.out.println("/Member");
//        return "Member";
//    }
//
//    @GetMapping(value = "/Member_Order.html")
//    public String Member_Order() {
//        System.out.println("/Member_Order");
//        return "Member_Order";
//    }
//
//    @GetMapping(value = "/Member_Address.html")
//    public String Member_Address() {
//        System.out.println("/Member_Address");
//        return "Member_Address";
//    }
//
//    @GetMapping(value = "/Member_User.html")
//    public String Member_User() {
//        System.out.println("/Member_User");
//        return "Member_User";
//    }
//
//    @GetMapping(value = "/Member_Collect.html")
//    public String Member_Collect() {
//        System.out.println("/Member_Collect");
//        return "Member_Collect";
//    }
//
//    @GetMapping(value = "/Member_Msg.html")
//    public String Member_Msg() {
//        System.out.println("/Member_Msg");
//        return "Member_Msg";
//    }
//
//    @GetMapping(value = "/Member_Links.html")
//    public String Member_Links() {
//        System.out.println("/Member_Links");
//        return "Member_Links";
//    }
//
//    @GetMapping(value = "/Member_Safe.html")
//    public String Member_Safe() {
//        System.out.println("/Member_Safe");
//        return "Member_Safe";
//    }
//
//    @GetMapping(value = "/Member_Packet.html")
//    public String Member_Packet() {
//        System.out.println("/Member_Packet");
//        return "Member_Packet";
//    }
//
//    @GetMapping(value = "/Member_Money.html")
//    public String Member_Money() {
//        System.out.println("/Member_Money");
//        return "Member_Money";
//    }
//
//    @GetMapping(value = "/Member_Member.html")
//    public String Member_Member() {
//        System.out.println("/Member_Member");
//        return "Member_Member";
//    }
//
//    @GetMapping(value = "/Member_Results.html")
//    public String Member_Results() {
//        System.out.println("/Member_Results");
//        return "Member_Results";
//    }
//
//    @GetMapping(value = "/Member_Commission.html")
//    public String Member_Commission() {
//        System.out.println("/Member_Commission");
//        return "Member_Commission";
//    }
//
//    @GetMapping(value = "/Member_Cash.html")
//    public String Member_Cash() {
//        System.out.println("/Member_Cash");
//        return "Member_Cash";
//    }

    @GetMapping(value = "/*.html")
    public String other(HttpServletRequest request) {
        String servletPath = request.getServletPath();//   /Member_Cash.html
        System.out.println(servletPath);
        if (servletPath.contains(".html")) {
            servletPath = servletPath.replace(".html", "");
            if ("Index".equals(servletPath)) {
                indexPage(request);
            }
        }
        return servletPath;
    }

    public void indexPage(HttpServletRequest request) {

    }
}
