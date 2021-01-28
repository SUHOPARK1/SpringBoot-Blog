package com.example.demo.uss.service;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudent is a Querydsl query type for Student
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudent extends EntityPathBase<Student> {

    private static final long serialVersionUID = -1677687857L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStudent student = new QStudent("student");

    public final StringPath birthday = createString("birthday");

    public final StringPath gender = createString("gender");

    public final ListPath<com.example.demo.sts.service.Grade, com.example.demo.sts.service.QGrade> gradeList = this.<com.example.demo.sts.service.Grade, com.example.demo.sts.service.QGrade>createList("gradeList", com.example.demo.sts.service.Grade.class, com.example.demo.sts.service.QGrade.class, PathInits.DIRECT2);

    public final com.example.demo.sym.service.QManager manager;

    public final StringPath name = createString("name");

    public final StringPath passwd = createString("passwd");

    public final StringPath profileImage = createString("profileImage");

    public final StringPath regDate = createString("regDate");

    public final NumberPath<Integer> stuNum = createNumber("stuNum", Integer.class);

    public final StringPath userid = createString("userid");

    public QStudent(String variable) {
        this(Student.class, forVariable(variable), INITS);
    }

    public QStudent(Path<? extends Student> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStudent(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStudent(PathMetadata metadata, PathInits inits) {
        this(Student.class, metadata, inits);
    }

    public QStudent(Class<? extends Student> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.manager = inits.isInitialized("manager") ? new com.example.demo.sym.service.QManager(forProperty("manager")) : null;
    }

}

