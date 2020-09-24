package com.udemy.backendninja.crudcontacts.repository;

import com.udemy.backendninja.crudcontacts.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("UserRepository")
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

    public abstract UserEntity findByUsername(String userName);
}
