package com.example.demo.sts.web;

import java.util.Arrays;

import com.example.demo.sym.service.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.GradeRepository;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.Subject;
import com.example.demo.sts.service.SubjectRepository;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.uss.service.StudentRepository;
import com.example.demo.uss.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static com.example.demo.cmm.utl.Util.integer;

@RequestMapping("/subjects")
@RestController
@CrossOrigin(origins="*")
public class SubjectController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired StudentService studentService;
    @Autowired GradeService gradeService;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired SubjectService subjectService;
    @Autowired TeacherService teacherService;
    @Autowired Pagination page;
    @Autowired Box<String> bx;


    @PostMapping("/save")
    public Messenger save(@RequestBody Subject subject) {
        subjectRepository.save(subject);
        return Messenger.SUCCESS;
    }
    @GetMapping("/count")
    public long count() {
        return subjectRepository.count();
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return subjectRepository.existsById(integer.apply(id));
    }
    @GetMapping("/findById/{id}")
    public Optional<Subject> findById(@PathVariable String id) {
        return subjectRepository.findById(integer.apply(id));
    }
    @PostMapping("/findAll")
    public Page<Subject> findAll(@RequestBody Pageable pageable) {
        return subjectRepository.findAll(pageable);
    }
    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody Subject subject){
        subjectRepository.delete(subject);
        return Messenger.SUCCESS;
    }

   
    @GetMapping("/groupBy/{examDate}/{subNum}")
    public Map<?,?> totalScoreGroupBySubject(
    		@PathVariable String examDate,
    		@PathVariable String subNum){
    	bx.put("examDate", examDate);
    	bx.put("subNum", subNum);
    	subjectService.groupBySubject(bx);
    	return null;
    }
    @GetMapping("/groupByGrade/{examDate}/{subNum}")
    public Map<?,?> groupByGrade(
    		@PathVariable String examDate,
    		@PathVariable String subNum){
    	bx.put("examDate", examDate);
    	bx.put("subNum", subNum);
    	subjectService.groupBySubject(bx);
    	return null;
    }
    
    
    

}









