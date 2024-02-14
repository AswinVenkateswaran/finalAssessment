package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.dao.PolicyDaoImpl;
import com.example.policyadministrativesystem.entity.Policy;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {

  @Autowired
   private PolicyDaoImpl policyDao;

    @Override
    public List<Policy> getAll() {
        return policyDao.findAll();
    }


    @Override
    public Policy getPolicy(int id) {
        return policyDao.findById(id);
    }
    @Transactional
    @Override
    public Policy storePolicy(Policy policy) {
        return policyDao.save(policy);
    }
    @Transactional
    @Override
    public Policy updatePolicy(Policy policy) {
        return policyDao.save(policy);
    }


}
