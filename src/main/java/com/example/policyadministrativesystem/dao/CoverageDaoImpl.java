package com.example.policyadministrativesystem.dao;

import com.example.policyadministrativesystem.entity.Coverage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoverageDaoImpl implements CoverageDao {

    private EntityManager entityManager;

    @Autowired
    public CoverageDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Coverage> findAll() {
        TypedQuery<Coverage> typedQuery = entityManager.createQuery("from Coverage ", Coverage.class);
        List<Coverage> coverages =typedQuery.getResultList();
        return coverages;
    }

    @Override
    public Coverage findById(int id) {
        Coverage coverage = entityManager.find(Coverage.class,id);
        return coverage;
    }
}
