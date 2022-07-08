package com.example.dealnmeal.controllers;

import com.example.dealnmeal.services.user.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping
    @ResponseBody
    public void getRegistrationData(@RequestBody String json) {
        System.out.println(json);
        JSONObject jsonObject = JSONObject.fromObject(json);
        System.out.println(jsonObject);
        userService.registerUser(jsonObject);
    }
}
