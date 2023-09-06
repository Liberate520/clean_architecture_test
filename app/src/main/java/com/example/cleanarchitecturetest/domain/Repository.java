package com.example.cleanarchitecturetest.domain;

import com.example.cleanarchitecturetest.domain.entety.User;

public interface Repository {
    User loadUser();
    boolean saveUser(User user);
}
