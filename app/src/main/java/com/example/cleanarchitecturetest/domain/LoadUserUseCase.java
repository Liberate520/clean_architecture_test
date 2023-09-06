package com.example.cleanarchitecturetest.domain;

public class LoadUserUseCase {

    private Repository repository;

    public LoadUserUseCase(Repository repository) {
        this.repository = repository;
    }

    public String loadUser(){
        return repository.loadUser().getName();
    }
}
