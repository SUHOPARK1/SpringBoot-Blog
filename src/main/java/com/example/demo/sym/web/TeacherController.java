package com.example.demo.sym.web;
import java.util.Map;
import java.util.Optional;


import com.example.demo.sym.service.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.utl.Box;
import com.example.demo.sts.service.SubjectRepository;

import static com.example.demo.cmm.utl.Util.integer;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class TeacherController {
private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final TeacherService teacherService;
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final Box<String> bx;


    @PostMapping("/save")
    public Messenger save(@RequestBody Teacher teacher) {
        teacherRepository.save(teacher);
        return Messenger.SUCCESS;
    }
    @GetMapping("/count")
    public long count() {
        return teacherRepository.count();
    }
    @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return teacherRepository.existsById(integer.apply(id));
    }
    @GetMapping("/findById/{id}")
    public Optional<Teacher> findById(@PathVariable String id) {

        return teacherRepository.findById(integer.apply(id));
    }
    @PostMapping("/findAll")
    public Page<Teacher> findAll(@RequestBody Pageable pageable) {
        return teacherRepository.findAll(pageable);
    }
    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody Teacher teacher){
        teacherRepository.delete(teacher);
        return Messenger.SUCCESS;
    }
    

    
    @PostMapping("/access")
    public Optional<Teacher> access(@RequestBody Teacher teacher) {
        // teacherRepository.findById(teacher.getTeaNum());
        return null;
    }
    /**
     * 해당 교강사가 담당하는 과목의 최근 시험결과에 따른 결과반환
     * 
     * */
    @GetMapping("/page/{pageSize}/{pageNum}/subject/{subNum}/{examDate}")
    public Map<?,?> selectAllBySubject(
    		@PathVariable String pageSize, 
			@PathVariable String pageNum,
    		@PathVariable String subNum,
    		@PathVariable String examDate){
    	logger.info(" selectAllBySubject Executed ...");
    	bx.put("pageSize", pageSize);
    	bx.put("pageNum", pageNum);
    	bx.put("subNum", subNum);
    	bx.put("examDate", examDate);
    	teacherService.selectAllBySubject(bx);
    	
    	return null;
    }
  
} 










