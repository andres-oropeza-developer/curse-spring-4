package com.udemy.backendninja.crudcontacts.entity;

import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Entity
@Table(name = "user_role", uniqueConstraints = @UniqueConstraint(columnNames = {"role", "username"}))
public class UserRoleEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_role_id", nullable = false, unique = true)
    private int userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable = false, unique = true)
    private UserEntity user;

    @Column(name = "role", nullable = false, length = 80)
    private String role;

    public int getUserRoleId() {
        return userRoleId;
    }

    public UserEntity getUser() {
        return user;
    }

    public String getRole() {
        return role;
    }

    public UserRoleEntity(int userRoleId, UserEntity user, String role) {
        this.userRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public UserRoleEntity() {
    }
}
