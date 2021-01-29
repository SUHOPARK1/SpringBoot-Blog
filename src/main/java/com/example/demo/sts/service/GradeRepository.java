package com.example.demo.sts.service;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.cmm.utl.Vector;

@Repository
public interface GradeRepository extends CrudRepository<Grade,Integer>
        , JpaSpecificationExecutor<Grade> {

}
