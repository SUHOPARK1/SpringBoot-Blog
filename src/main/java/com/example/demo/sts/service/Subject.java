package com.example.demo.sts.service;
import com.example.demo.sym.service.Teacher;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@Table(name="subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sub_num") private int subNum;
	@Column(name = "subject") private String subject;
	@Column(name = "description") private String description;

	@OneToMany(mappedBy = "subject")
	private List<Teacher> teacherList = new ArrayList<>();
	@OneToMany(mappedBy = "subject")
	private List<Grade> gradeList = new ArrayList<>();

	@Builder
	private Subject( String subject, String description){
		this.subject = subject;
		this.description = description;
	}

	public Subject(){}


}

