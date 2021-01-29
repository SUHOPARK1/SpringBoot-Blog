package com.example.demo.uss.service;
import static java.util.Comparator.comparing;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.cmm.utl.Pagination;

import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
public class StudentService{
	private final DummyGenerator dummy;
	private final StudentRepository studentRepository;
	private final Box<String> bx;
    @Transactional
    public long insertMany(int count) {
    	for(int i=0; i < count; i++) {
    		studentRepository.save(dummy.makeStudent());
    	}
    	return count(); 
    }
    @Transactional
    public int truncate() {
    	bx.clear();
    	bx.put("TRUNCATE_STUDENTS", Sql.TRUNCATE.toString() + Table.STUDENTS);
    	studentRepository.deleteAll();
    	return count() != 0 ? 0 : 1;
    }
    
    public long count() {
    	bx.clear();
    	bx.put("COUNT_STUDENTS", Sql.TOTAL_COUNT.toString() +  Table.STUDENTS);
    	return studentRepository.count();
    }
    
    public List<Student> list(Pagination page){
    	/*
    	return studentRepository.list().stream()
    			.sorted(comparing(Student::getStuNum).reversed())
    			.skip(page.getPageSize() * (page.getPageNum()-1))
    			.limit(page.getPageSize())
    			.collect(Collectors.toList()); */
		return null;
    }
    
    /*public List<Student> selectByGender(String gender){
    	return list().stream()
    			
    			.collect(toList());
    }*/
    
}