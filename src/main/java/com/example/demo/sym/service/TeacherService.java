package com.example.demo.sym.service;


import static com.example.demo.cmm.utl.Util.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.cmm.utl.Box;
import com.example.demo.cmm.utl.DummyGenerator;
import com.example.demo.cmm.utl.Pagination;
import com.example.demo.sts.service.GradeVo;
import com.example.demo.sts.service.SubjectRepository;

@Service
@RequiredArgsConstructor
public class TeacherService {
	private final TeacherRepository teacherRepository;
	private final SubjectRepository subjectRepository;
	private final DummyGenerator dummy;
	private final Box<Object> bx;
	
	public void insertMany(int count) {
		
		// teacher 는 subject 수인 5까지만 입력
		var tlist = new ArrayList<Teacher>();
		Teacher t = null;
		
		for(int i=0; i< count; i++) {
			t = dummy.makeTeacher(i+1);
			teacherRepository.save(t);

		}
    }

	public void register(Teacher teacher) {
		teacherRepository.save(teacher);
	}
	public Map<?,?> selectAllBySubject(Box<String> param){
		String pageNum = param.get("pageNum").toString();
		String pageSize = param.get("pageSize").toString();
		
		List<Teacher> list = teacherRepository.findAll();
    	
    	GradeVo vo = new GradeVo();
    	//IntSummaryStatistics is =list.stream().collect(summarizingInt(GradeVo::getScore));// 204
		IntSummaryStatistics is = null;
    	bx.put("max", is.getMax());
    	bx.put("min", is.getMin());
    	bx.put("sum", integer.apply(
    			string.apply(is.getSum())));
    	bx.put("avg", integer.apply(
    			string.apply(is.getAverage())));
    	bx.put("count", integer.apply(
    			string.apply(is.getCount())));
    	
    	
    	bx.put("list", list.stream()
			    	    	.skip(mySkip.apply(pageNum, pageSize))
			    	    	.limit(integer.apply(pageSize))
			    	    	.collect(toList()));
    	
    	bx.put("page", new Pagination(integer.apply(pageSize), 
    								   integer.apply(pageNum), 
    								   list.size()));   
    	
    	bx.put("subjects",subjectRepository.findAll()
					    	.stream());

    	
    	/*
    	Optional<GradeVo> highScoreGrade = list.stream()
    			.collect(reducing( (g1, g2) -> g1.getScore() > g2.getScore() ? g1 : g2 )); */
    	bx.put("highScoreGrade", 0);
		return bx.get();
	}

}





