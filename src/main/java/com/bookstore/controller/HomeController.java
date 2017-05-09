package com.bookstore.controller;

import com.bookstore.domain.User;
import com.bookstore.security.PasswordResetToken;
import com.bookstore.service.UserService;
import com.bookstore.service.impl.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Security;
import java.util.Locale;

/**
 * Created by ekasap on 06.03.2017.
 */
@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    UserSecurityService userSecurityService;

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
    public String newUser(Locale locale, @RequestParam("token") String token, Model model) {
        PasswordResetToken passToken = userService.getPasswordResetToken(token);

        if (passToken == null) {
            String message = "Invalid Token.";
            model.addAttribute("message", message);
            return "redirect:badRequest";
        }

        User user = passToken.getUser();
        String userName = user.getUsername();

        UserDetails userDetails = userSecurityService.loadUserByUsername(userName);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);


        model.addAttribute("classActiveEdit ", true);
        return "myProfile";
    }
}
