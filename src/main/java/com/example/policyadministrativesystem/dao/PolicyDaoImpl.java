package com.example.policyadministrativesystem.dao;


import com.example.policyadministrativesystem.entity.Policy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Repository
public class PolicyDaoImpl implements  PolicyDao {

    private EntityManager entityManager;

    @Autowired
    public PolicyDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Policy> findAll() {
        TypedQuery<Policy> typedQuery = entityManager.createQuery("from Policy", Policy.class);
        List<Policy> policys = typedQuery.getResultList();
        return policys;
    }

    @Override
    public Policy findById(int id) {
        Policy policy = entityManager.find(Policy.class,id);
        return policy;
    }

    @Transactional
    @Override
    public Policy save(Policy policy) {
        Policy policy1 = entityManager.merge(policy);
        return policy1;
    }


}

