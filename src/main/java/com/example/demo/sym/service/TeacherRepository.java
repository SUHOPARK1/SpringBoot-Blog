package com.example.demo.sym.service;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Box;
import com.example.demo.sts.service.Grade;
import com.example.demo.sts.service.GradeVo;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

}
