package com.bmw.imiles.service;


import java.util.List;

import com.bmw.imiles.entity.User;
import com.bmw.imiles.model.UserDto;

public interface UserService {

    UserDto save(UserDto user);
    List<UserDto> findAll();
    User findOne(long id);
    void delete(long id);
}
