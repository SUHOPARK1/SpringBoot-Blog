package com.example.demo.uss.web;
import com.example.demo.cmm.enm.Messenger;
import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.enm.Table;
import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.GradeService;
import com.example.demo.sts.service.SubjectService;
import com.example.demo.sym.service.ManagerService;
import com.example.demo.sym.service.Teacher;
import com.example.demo.sym.service.TeacherService;
import com.example.demo.uss.service.Student;
import com.example.demo.uss.service.StudentRepository;
import com.example.demo.uss.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.example.demo.cmm.utl.Util.integer;
import static com.example.demo.cmm.utl.Util.string;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
public class StudentController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final GradeService gradeService;
    private final StudentService studentService;
    private final StudentRepository studentRepository;
    private final SubjectService subjectService;
    private final TeacherService teacherService;
    private final ManagerService managerService;
    private final Student student;
    private final Pagination page;
    private final Box<String> bx;

    @PostMapping("/save")
    public String save(@RequestBody Student student) {
        studentRepository.save(student);
        return "redirect:/login";
    }
    @GetMapping("/count")
    public long count() {
        return studentRepository.count();
    }
     @GetMapping("/existsById/{id}")
    public boolean existsById(@PathVariable String id) {
        return studentRepository.existsById(integer.apply(id));
    }
    @GetMapping("/findById/{id}")
    public Optional<Student> findById(@PathVariable String id) {
        return studentRepository.findById(integer.apply(id));
    }
    @GetMapping("/findAll/{pageNum}")
    public Page<Student> findAll(@PathVariable String pageNum) {
        Pageable pageable = PageRequest.of(integer.apply(pageNum) -1, student.getPageSize());
        return studentRepository.findAll(pageable);
    }
    @DeleteMapping("/delete")
    public Messenger delete(@RequestBody Student student){
        studentRepository.delete(student);
        return Messenger.SUCCESS;
    }
    @GetMapping("/findByStudentsOrderByStuNumDesc/{pageNum}")
    public Page<Student> findByStudentsOrderByStuNumDesc(@PathVariable String pageNum){
        Pageable pageable = PageRequest.of(integer.apply(pageNum) -1, student.getPageSize());
        return studentRepository.findByStudentsOrderByStuNumDesc(pageable);
    }

    @PostMapping("/login")
    public Map<?,?> login(@RequestBody Student s){
        var map = new HashMap<>();
        // Optional<Student> result = studentRepository.findById(s.getStuNum());
        Optional<Student> result = null;
        map.put("message", result!=null?"SUCCESS":"FAILURE");
        map.put("sessionUser", result);
        return map;
    }

    @GetMapping("/list/{pageSize}/{pageNum}")
    public Map<?,?> list(@PathVariable String pageSize, 
    					@PathVariable String pageNum){
    	logger.info("Students List Execute ...");
    	var map = new HashMap<String,String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.STUDENTS);	
    	var page = new Pagination(
				Table.STUDENTS.toString(), 
				integer.apply(pageSize),
				integer.apply(pageNum), 100)
				;
    	var map2 = new HashMap<String, Object>();
    	map2.put("list", studentService.list(page));
    	map2.put("page", page);
        return map2;
    }
    @GetMapping("/page/{pageSize}/{pageNum}/selectAll")
    public List<?> selectAll(@PathVariable String pageSize, 
    					@PathVariable String pageNum){
    	logger.info("Students List Execute ...");
    	var map = new HashMap<String,String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.STUDENTS);	
        return studentRepository.findAll();
    }
    
    @PutMapping("/update")
    public Messenger update(@RequestBody Student s){
        return Messenger.SUCCESS;
    }

    @PatchMapping("/patch/{id}")
    public Messenger patch(@PathVariable String id,
                           @RequestBody Student student){
        Student s = studentRepository.findById(integer.apply(id)).orElse(student);
        return Messenger.SUCCESS;
    }


    @GetMapping("/insert-many/{count}")
    public String insertMany(@PathVariable String count) {
    	logger.info(String.format("Insert %s Students ...",count));
    	var map = new HashMap<String,String>();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.STUDENTS);
    	if(studentRepository.count() == 0) {
    		managerService.insertMany(1);
        	subjectService.insertMany(5);
        	studentService.insertMany(Integer.parseInt(count));
        	teacherService.insertMany(5);
        	//gradeService.insertMany(Integer.parseInt(count)); 나중에 추가함
    	}
    	map.clear();
    	map.put("TOTAL_COUNT", Sql.TOTAL_COUNT.toString() + Table.STUDENTS);
    	return string.apply(studentRepository.count());
    }

    @GetMapping("/find-by-gender/{gender}")
    public List<Student> findByGender(@PathVariable String gender) {
    	logger.info(String.format("Find By %s from Students ...", gender));
    	return null; //studentService.selectByGender(gender);
    }
}