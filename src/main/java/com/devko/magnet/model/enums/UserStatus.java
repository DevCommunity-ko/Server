package com.devko.magnet.model.enums;

public enum UserStatus {
    N("Non Member"),
    M("Member"),
    I("Inactive Member");

    String value;

    UserStatus(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
