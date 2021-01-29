package com.example.demo.sym.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import static com.example.demo.cmm.utl.Util.*;
import com.example.demo.cmm.enm.Messenger;
import com.example.demo.sym.service.Manager;
import com.example.demo.sym.service.ManagerRepository;
import com.example.demo.sym.service.ManagerService;

import java.util.Optional;

@RestController
@RequestMapping("/managers")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class ManagerController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ManagerService managerService;
    private final ManagerRepository managerRepository;

    @PostMapping("/save")
    public Messenger save(@RequestBody Manager manager) {
        managerRepository.save(manager);
        return Messenger.SUCCESS;
    }
    @GetMapping("/count")
    public long count() {
        return managerRepository.count();
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return managerRepository.existsById(integer.apply(id));
    }
    @GetMapping("/findById/{id}")
    public Optional<Manager> findById(@PathVariable String id) {
        return managerRepository.findById(integer.apply(id));
    }
    @PostMapping("/findAll")
    public Page<Manager> findAll(@RequestBody Pageable pageable) {
        return managerRepository.findAll(pageable);
    }
    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody Manager manager){
        managerRepository.delete(manager);
        return Messenger.SUCCESS;
    }

    
    @PostMapping("/access")
    public Optional<Manager> access(@RequestBody Manager manager) {
    	return managerRepository.findById(0);
    }
    
}








