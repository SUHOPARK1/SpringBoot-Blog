package com.example.demo.sts.service;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Vector;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {


}
