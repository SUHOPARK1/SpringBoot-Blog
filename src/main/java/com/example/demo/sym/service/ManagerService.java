package com.example.demo.sym.service;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.utl.DummyGenerator;

@Service
public class ManagerService {
    @Autowired
	ManagerRepository managerRepository;
    @Autowired DummyGenerator dummy;

    public void register(Manager manager) {
        managerRepository.save(manager);
    }

	public void insertMany(int count) {
		var list = new ArrayList<Manager>();
		Manager m = null;
		for(int i=0; i< count; i++) {
			//m = dummy.makeManager();
			//list.add(m);
		}
		managerRepository.saveAll(null);
	}

}
