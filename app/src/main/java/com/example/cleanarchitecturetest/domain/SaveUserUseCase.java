package com.example.cleanarchitecturetest.domain;

import com.example.cleanarchitecturetest.domain.entety.User;

public class SaveUserUseCase {

    private Repository repository;

    public SaveUserUseCase(Repository repository) {
        this.repository = repository;
    }

    public boolean saveUser(User user){
        return repository.saveUser(user);
    }
}
