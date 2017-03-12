package com.bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

/**
 * Created by ekasap on 06.03.2017.
 */
@Controller
public class HomeController {

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
    public String forgetPassword(Model model) {
        model.addAttribute("classActiveForgetPassword", true);
        return "myAccount";
    }

    @RequestMapping("/newUser")
    public String newUser(Model model) {
        model.addAttribute("classActiveNewUser ", true);
        return "myAccount";
    }
}
