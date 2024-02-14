package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.entity.State;

import java.util.List;

public interface StateService {

    List<State> getAllStates();
    State getState(int id);
}
