package com.chun.springbootmall.dao;

import com.chun.springbootmall.dto.UserRegisterRequest;
import com.chun.springbootmall.model.User;

public interface UserDao {

    User getByUserId(Integer userId);
    Integer createUser(UserRegisterRequest userRegisterRequest);

}
