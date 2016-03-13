package com.study.lab1.service;

import com.study.lab1.dao.UserDao;
import com.study.lab1.model.Request;
import com.study.lab1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestValidator {
    @Autowired
    private UserDao userDao;
//    private UserDao userDao = new UserDao();

    public void validate(Request request) {
        long userId = request.getUserId();
        User user = userDao.getUser(userId);
        if (user == null) {
            throw new SecurityException("User with id = " + userId + " not found");
        }
    }
}
