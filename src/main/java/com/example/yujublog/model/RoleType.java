package com.example.yujublog.model;

import lombok.Getter;

@Getter
public enum RoleType {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    RoleType(String value) {
        this.value = value;
    }

    private String value;
}
