package com.chun.springbootmall.service.impl;

import com.chun.springbootmall.dao.UserDao;
import com.chun.springbootmall.dto.UserRegisterRequest;
import com.chun.springbootmall.model.User;
import com.chun.springbootmall.service.UserService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getByUserId(Integer userId) {
        return userDao.getByUserId(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        // 檢查註冊的 email
        User user = userDao.getByEmail(userRegisterRequest.getEmail());

        if(user != null){
            log.warn("該 email {} 已經被註冊",userRegisterRequest.getEmail());
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        // 創建帳號
        return userDao.createUser(userRegisterRequest);
    }
}
