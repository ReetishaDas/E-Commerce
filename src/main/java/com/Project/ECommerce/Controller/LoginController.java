package com.Project.ECommerce.Controller;


import com.Project.ECommerce.Globals.GlobalData;
import com.Project.ECommerce.Model.Role;
import com.Project.ECommerce.Model.User;
import com.Project.ECommerce.Repository.RoleRepository;
import com.Project.ECommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository UR;
    @Autowired
    RoleRepository RR;

    @GetMapping("/login")
    public String login(){
        GlobalData.cart.clear();
        return "login";
    }

    @GetMapping("/register")
    public String registerGet(){
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles = new ArrayList<>();
        roles.add(RR.findById(2).get());
        user.setRoles(roles);
        UR.save(user);
        request.login(user.getEmail(), password);
        return "redirect:/";
    }

}
