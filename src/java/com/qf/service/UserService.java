package com.qf.service;

import com.qf.pojo.User;

public interface UserService {
    User selectUserByEmailAndPassword(User user);

    User selectUserByEmail(String email);

    boolean insertUser(User user);

    void updateUser(User user);
}
