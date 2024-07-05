package com.example.complexeSportif.entities.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

public enum Permission {
    ADHERANT_READ("adherant:read"),
    ADHERANT_WRITE("adherant:write"),
    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    ENTRAINEUR_READ("entraineur:read"),
    ENTRAINEUR_WRITE("entraineur:write");

    private final String permission;



    public String getPermission() {
        return permission;
    }
}
