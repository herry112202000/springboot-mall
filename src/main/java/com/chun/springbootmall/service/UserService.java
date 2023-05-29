package com.chun.springbootmall.service;

import com.chun.springbootmall.dto.UserLoginRequest;
import com.chun.springbootmall.dto.UserRegisterRequest;
import com.chun.springbootmall.model.User;

public interface UserService {

    User getByUserId(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
