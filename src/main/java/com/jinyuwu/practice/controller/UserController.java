package com.jinyuwu.practice.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.jinyuwu.practice.user.CrmUser;
import com.jinyuwu.practice.entity.User;
import com.jinyuwu.practice.service.UserService;

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());
        return "registration-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showUpdatePage(@RequestParam("userId") long uid, Model model) {
        User theUser = userService.findByUserId(uid);
        model.addAttribute("user", theUser);
        return "update-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult theBindingResult,
            Model model) {
        String userName = theCrmUser.getUserName();

        if (theBindingResult.hasErrors()) {
            return "registration-form";
        }
        User existing = userService.findByUserName(userName);
        if (existing != null) {
            model.addAttribute("crmUser", new CrmUser());
            model.addAttribute("registrationError", "User name already exists.");
            return "registration-form";
        }
        userService.save(theCrmUser);
        return "login";
    }
}
