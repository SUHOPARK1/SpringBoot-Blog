package com.example.demo.sts.web;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.Grade;
import com.example.demo.sts.service.GradeRepository;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.StudentRepository;
import com.example.demo.uss.service.StudentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;

import static com.example.demo.cmm.utl.Util.integer;

@RequestMapping("/grades")
@RestController
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class GradeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final StudentService studentService;
    private final GradeService gradeService;
    private final StudentRepository studentRepository;
    private final GradeRepository gradeRepository;
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final ManagerService managerService;
    private final Pagination page;

    @PostMapping("/save")
    public Messenger save(@RequestBody Grade grade) {
        gradeRepository.save(grade);
        return Messenger.SUCCESS;
    }
    @GetMapping("/count")
    public long count() {
        return gradeRepository.count();
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return gradeRepository.existsById(integer.apply(id));
    }
    @GetMapping("/findById/{id}")
    public Optional<Grade > findById(@PathVariable String id) {
        return gradeRepository.findById(integer.apply(id));
    }
    /*
    @PostMapping("/findAll")
    public Page<Grade> findAll(@RequestBody Pageable pageable) {
        return gradeRepository.findAll(pageable);
    } */
    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody Grade  grade){
        gradeRepository.delete(grade);
        return Messenger.SUCCESS;
    }

    
	
}
