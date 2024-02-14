package com.example.policyadministrativesystem.service;

import com.example.policyadministrativesystem.dao.StateDaoImpl;
import com.example.policyadministrativesystem.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateDaoImpl stateDao;
    @Override
    public List<State> getAllStates() {
        return stateDao.findAll();
    }

    @Override
    public State getState(int id) {
        return stateDao.findById(id);
    }

}
