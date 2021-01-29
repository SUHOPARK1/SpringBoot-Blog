package com.example.demo.uss.service;

import com.example.demo.sts.service.Grade;
import com.example.demo.sym.service.Manager;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.demo.cmm.enm.Path;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name="students")
@Component
@Validated
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "stu_num") private int stuNum;
	@Column(name = "userid") private String userid;
	@Column(name = "passwd") private String passwd;
	@Column(name = "name") private String name;
	@Column(name = "birthday") private String birthday;
	@Column(name = "gender") private String gender;
	@Column(name = "reg_date") private String regDate;
	@Column(name = "profile_image") private String profileImage;

	@Min(value = 5, message = "must be between 5 and 25")
	@Max(value = 25, message = "must be between 5 and 25")
	private int pageSize = 20;

	@ManyToOne
	@JoinColumn(name="mgr_num")
	private Manager manager;

	@OneToMany(mappedBy = "student")
	private List<Grade> gradeList = new ArrayList<>();


    public Student(String userid,
			String passwd,
			String name,
			String birthday, 
			String gender,
			String regDate,
			String profileImage,int mgrNum) {
    	this.userid = userid;
    	this.passwd = passwd;
    	this.name = name;
    	this.birthday = birthday;
    	this.gender = gender;
    	this.regDate = regDate;
    	this.profileImage = profileImage;
    }

	@Builder
	private Student(String userid,
					String passwd,
					String name,
					String birthday,
					String regDate,
					String profileImage){

		this.userid = userid;
		this.passwd = passwd;
		this.name = name;
		this.regDate = regDate;
		this.birthday = birthday;
		this.profileImage = profileImage;
	}


}
