package com.chun.springbootmall.service.impl;

import com.chun.springbootmall.dao.UserDao;
import com.chun.springbootmall.dto.UserRegisterRequest;
import com.chun.springbootmall.model.User;
import com.chun.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getByUserId(Integer userId) {
        return userDao.getByUserId(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        return userDao.createUser(userRegisterRequest);
    }
}
