package com.example.demo.sym.service;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QManager is a Querydsl query type for Manager
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QManager extends EntityPathBase<Manager> {

    private static final long serialVersionUID = 1508271731L;

    public static final QManager manager = new QManager("manager");

    public final StringPath email = createString("email");

    public final NumberPath<Long> mgrNum = createNumber("mgrNum", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final StringPath profileImage = createString("profileImage");

    public final ListPath<com.example.demo.uss.service.Student, com.example.demo.uss.service.QStudent> studentList = this.<com.example.demo.uss.service.Student, com.example.demo.uss.service.QStudent>createList("studentList", com.example.demo.uss.service.Student.class, com.example.demo.uss.service.QStudent.class, PathInits.DIRECT2);

    public QManager(String variable) {
        super(Manager.class, forVariable(variable));
    }

    public QManager(Path<? extends Manager> path) {
        super(path.getType(), path.getMetadata());
    }

    public QManager(PathMetadata metadata) {
        super(Manager.class, metadata);
    }

}

