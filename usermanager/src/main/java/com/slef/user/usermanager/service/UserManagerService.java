package com.slef.user.usermanager.service;

import com.slef.user.usermanager.bean.User;
import com.slef.user.usermanager.dao.UserManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
@Lazy
public class UserManagerService {
    @Autowired
   private UserManagerDao userManagerDao;

    public User selectUser(){
        User user= userManagerDao.selectUser();
        return user;
    }
}
