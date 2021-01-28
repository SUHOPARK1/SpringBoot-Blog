package com.example.demo.sym.service;

import com.example.demo.uss.service.Student;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Table(name="managers")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mgr_num") private Long mgrNum;
    @Column(name = "email") private String email;
    @Column(name = "password") private String password;
    @Column(name = "name") private String name;
    @Column(name = "profile_image") private String profileImage;

    @OneToMany(mappedBy="manager")
    private List<Student> studentList = new ArrayList<>();

    @Builder
    private Manager(String email, String password, String name, String profileImage){
        this.email = email;
        this.password = password;
        this.name = name;
        this.profileImage = profileImage;
    }

}