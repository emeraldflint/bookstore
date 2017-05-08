package com.bookstore.controller;

import com.bookstore.security.PasswordResetToken;
import com.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

/**
 * Created by ekasap on 06.03.2017.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /*  @RequestMapping("/myAccount")
        public String myAccount() {
          return "myAccount";
      }
  */
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("classActiveLogin", true);
        return "myAccount";
    }

    @RequestMapping("/forgetPassword")
    public String forgetPassword(Locale locale,
                                 @RequestParam("token") String token,
                                 Model model) {
        PasswordResetToken passwordResetToken = userService.getPasswordResetToken(token);
        model.addAttribute("classActiveForgetPassword", true);
        return "myAccount";
    }

    @RequestMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("classActiveNewUser ", true);
        return "myAccount";
    }
}
