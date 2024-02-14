package com.example.policyadministrativesystem.dao;

import com.example.policyadministrativesystem.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StateDaoImpl implements StateDao {

    private EntityManager entityManager;
    @Autowired
    public StateDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<State> findAll() {
        TypedQuery<State> typedQuery = entityManager.createQuery("from State ", State.class);
        List<State> states = typedQuery.getResultList();
        return states;
    }

    @Override
    public State findById(int id) {
        State state = entityManager.find(State.class,id);
        return state;
    }
}
