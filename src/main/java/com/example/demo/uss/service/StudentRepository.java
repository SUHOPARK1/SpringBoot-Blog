package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Page<Student> findByStudentsOrderByStuNumDesc(Pageable pageable);

}