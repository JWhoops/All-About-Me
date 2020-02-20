package com.jinyuwu.practice.controller;

import com.jinyuwu.practice.entity.User;
import com.jinyuwu.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHome(@RequestParam("userId") long uid, Model theModel) {
        User theUser = userService.findByUserId(uid);
        theModel.addAttribute("user", theUser);
        return "home";
    }
}










