package com.example.policyadministrativesystem.dao;
import com.example.policyadministrativesystem.entity.Policy;

import java.util.List;

public interface PolicyDao {

    List<Policy> findAll();
    Policy findById(int id);

    Policy save(Policy policy);

}

