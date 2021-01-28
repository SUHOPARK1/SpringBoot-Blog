package com.example.demo.sts.service;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGrade is a Querydsl query type for Grade
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGrade extends EntityPathBase<Grade> {

    private static final long serialVersionUID = -602130360L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGrade grade1 = new QGrade("grade1");

    public final StringPath examDate = createString("examDate");

    public final StringPath grade = createString("grade");

    public final NumberPath<Integer> grdNum = createNumber("grdNum", Integer.class);

    public final StringPath passExam = createString("passExam");

    public final NumberPath<Integer> score = createNumber("score", Integer.class);

    public final com.example.demo.uss.service.QStudent student;

    public final QSubject subject;

    public QGrade(String variable) {
        this(Grade.class, forVariable(variable), INITS);
    }

    public QGrade(Path<? extends Grade> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QGrade(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QGrade(PathMetadata metadata, PathInits inits) {
        this(Grade.class, metadata, inits);
    }

    public QGrade(Class<? extends Grade> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.student = inits.isInitialized("student") ? new com.example.demo.uss.service.QStudent(forProperty("student"), inits.get("student")) : null;
        this.subject = inits.isInitialized("subject") ? new QSubject(forProperty("subject")) : null;
    }

}

