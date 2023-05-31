package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import ra.model.User;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
@SessionAttributes("userLogin")
public class UserController {
@ModelAttribute("user")
    public User formLogin(){
    return new User();
}
@GetMapping("login")
public String login(){
return "login";
}
@PostMapping("dologin")
    public String dologin(@ModelAttribute("user") User user, Model model, HttpSession httpSession){
if (user.getEmail().equals("quan@gmail.com")&&user.getPassword().equals("12345")){
    model.addAttribute("message","logIn success");
    model.addAttribute("loin","huy k");
    httpSession.setAttribute("userLogin",user);
} else {
    model.addAttribute("message","login fail");
}
return "login";
}
    @GetMapping("logout")
    public String logout(SessionStatus sessionStatus){
    sessionStatus.isComplete();
    return "login";
    }
}
