package com.udemy.backendninja.crudcontacts.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name="username", nullable = false, unique = true, length = 80)
    private String username;

    @Column(name="password", nullable = false, length = 80)
    private String password;

    @Column(name="enabled", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<UserRoleEntity> userRoleEntity = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRoleEntity> getUserRole() {
        return userRoleEntity;
    }

    public void setUserRole(Set<UserRoleEntity> userRoleEntity) {
        this.userRoleEntity = userRoleEntity;
    }

    public UserEntity(String username, String password, boolean enabled, Set<UserRoleEntity> userRoleEntity) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.userRoleEntity = userRoleEntity;
    }

    public UserEntity() {
    }
}
