package com.slef.user.usermanager.controller;

import com.slef.user.usermanager.bean.User;
import com.slef.user.usermanager.service.UserManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
@RequestMapping(value = "/manager")
public class UserManagerController {
    @Autowired
    private UserManagerService userManagerService;
    private static Logger _log = LoggerFactory.getLogger(UserManagerController.class);

    @GetMapping("/getUser")
    public String pickUser() {
        User user = userManagerService.selectUser();
        _log.error("zs+sl+ww");
        return "user";
    }
}
