package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.entity.Policy;

import java.util.List;

public interface PolicyService {

    List<Policy> getAll();
    Policy getPolicy(int id);
    Policy storePolicy(Policy policy);
    Policy updatePolicy(Policy policy);

}
