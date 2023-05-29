package com.chun.springbootmall.dao;

import com.chun.springbootmall.dto.UserRegisterRequest;
import com.chun.springbootmall.model.User;

public interface UserDao {



    User getByUserId(Integer userId);

    User getByEmail(String email);
    Integer createUser(UserRegisterRequest userRegisterRequest);

}
