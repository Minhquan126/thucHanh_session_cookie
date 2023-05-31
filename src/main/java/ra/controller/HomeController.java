package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller

public class HomeController {
    @RequestMapping("/")
    public String home(@CookieValue(value = "userName",defaultValue = "hung") String userName, HttpServletResponse response, Model model){
        Cookie cookie = new Cookie("userName",userName);
        cookie.setMaxAge(5*60);
        response.addCookie(cookie);
        return "home";
    }
    @GetMapping("cookie")
    public String cookie(HttpServletRequest request,HttpServletResponse response,Model model){
      Cookie[] cookies = null;
      cookies = request.getCookies();
//        for (Cookie cookie:cookies) {
//            if (cookie.getName().equals("userName")){
//                cookie.setMaxAge(0);
//                response.addCookie(cookie);
//            }
//        }
        return "cookie";
    }
    @GetMapping("count")
    public String count(@CookieValue(value = "count",defaultValue = "0") Long count,HttpServletRequest request,HttpServletResponse response,Model model){
        count ++;
        Cookie cookie = new Cookie("count",count.toString());
        cookie.setMaxAge(24*60*60);
       response.addCookie(cookie);
       Cookie[] cookies = request.getCookies();
        for (Cookie c:cookies) {
            if (c.getName().equals("count")){
                model.addAttribute("cc",c);
            }
        }
        return "count";
    }
}
