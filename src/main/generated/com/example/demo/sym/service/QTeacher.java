package com.example.demo.sym.service;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTeacher is a Querydsl query type for Teacher
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTeacher extends EntityPathBase<Teacher> {

    private static final long serialVersionUID = -766565720L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTeacher teacher = new QTeacher("teacher");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath profileImage = createString("profileImage");

    public final com.example.demo.sts.service.QSubject subject;

    public final NumberPath<Integer> teaNum = createNumber("teaNum", Integer.class);

    public QTeacher(String variable) {
        this(Teacher.class, forVariable(variable), INITS);
    }

    public QTeacher(Path<? extends Teacher> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTeacher(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTeacher(PathMetadata metadata, PathInits inits) {
        this(Teacher.class, metadata, inits);
    }

    public QTeacher(Class<? extends Teacher> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.subject = inits.isInitialized("subject") ? new com.example.demo.sts.service.QSubject(forProperty("subject")) : null;
    }

}

