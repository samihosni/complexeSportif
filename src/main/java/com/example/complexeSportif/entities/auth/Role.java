package com.example.complexeSportif.entities.auth;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.complexeSportif.entities.auth.Permission.*;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.emptySet()),
    MANAGER(Set.of(
            MANAGER_READ,
            MANAGER_UPDATE,
            MANAGER_CREATE,
            MANAGER_DELETE
    )),
    ADMIN(Set.of(
            MANAGER_READ,
            MANAGER_UPDATE,
            MANAGER_CREATE,
            MANAGER_DELETE,
            ADMIN_READ,
            ADMIN_CREATE,
            ADMIN_UPDATE,
            ADMIN_DELETE
    ))
    ;
    @Getter
    private final Set<Permission> permissions;
    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }

}
