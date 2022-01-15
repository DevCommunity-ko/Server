package com.devko.magnet.model;

public enum Job {
    Student("student", "중고등학생"),
    Collegian("collegian", "대학생"),
    Incumbent("incumbent", "현직자");

    String code;
    String name;

    Job(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
