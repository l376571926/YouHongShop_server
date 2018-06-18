package group.tonight.shop.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import group.tonight.shop.bean.BaseResponseBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @PostMapping(value = "/try/ajax/demo_test_post.php")
    public String ccc(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String name = parameterMap.get("name")[0];
        String url = parameterMap.get("url")[0];

        return "网站名: " +
                name +
                "\n" +
                "URL 地址: " +
                url;
    }

    @PostMapping(value = "/try/ajax/demo_test_post1.php")
    public BaseResponseBean ddd(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String name = parameterMap.get("name")[0];
        String url = parameterMap.get("url")[0];

        String builder = "网站名: " +
                name +
                "\n" +
                "URL 地址: " +
                url;

        return new BaseResponseBean(0, builder);
    }

    @PostMapping(value = "/demo_ajax_gethint.php")
    public String vvv(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String suggest = parameterMap.get("suggest")[0];
        System.out.println(suggest);
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            if (string.toLowerCase().startsWith(suggest.toLowerCase())) {
                builder.append(string)
                        .append(" , ");
            }
        }
        String s = builder.toString();
        if ("".equals(s)) {
            return "未匹配到";
        }

        return s.substring(0, s.length() - 2);
    }

    private String[] strings = {
            "Anna",
            "Brittany",
            "Cinderella",
            "Diana",
            "Eva",
            "Fiona",
            "Gunda",
            "Hege",
            "Inga",
            "Johanna",
            "Kitty",
            "Linda",
            "Nina",
            "Ophelia",
            "Petunia",
            "Amanda",
            "Raquel",
            "Cindy",
            "Doris",
            "Eve",
            "Evita",
            "Sunniva",
            "Tove",
            "Unni",
            "Violet",
            "Liza",
            "Elizabeth",
            "Ellen",
            "Wenche",
            "Vicky"
    };
}
