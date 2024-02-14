package com.example.policyadministrativesystem.dao;

import com.example.policyadministrativesystem.entity.State;
import java.util.List;

public interface StateDao {

    List<State> findAll();
    State findById(int id);
}
