package com.example.demo.sts.service;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubject is a Querydsl query type for Subject
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubject extends EntityPathBase<Subject> {

    private static final long serialVersionUID = -974555811L;

    public static final QSubject subject1 = new QSubject("subject1");

    public final StringPath description = createString("description");

    public final ListPath<Grade, QGrade> gradeList = this.<Grade, QGrade>createList("gradeList", Grade.class, QGrade.class, PathInits.DIRECT2);

    public final StringPath subject = createString("subject");

    public final NumberPath<Integer> subNum = createNumber("subNum", Integer.class);

    public final ListPath<com.example.demo.sym.service.Teacher, com.example.demo.sym.service.QTeacher> teacherList = this.<com.example.demo.sym.service.Teacher, com.example.demo.sym.service.QTeacher>createList("teacherList", com.example.demo.sym.service.Teacher.class, com.example.demo.sym.service.QTeacher.class, PathInits.DIRECT2);

    public QSubject(String variable) {
        super(Subject.class, forVariable(variable));
    }

    public QSubject(Path<? extends Subject> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubject(PathMetadata metadata) {
        super(Subject.class, metadata);
    }

}

