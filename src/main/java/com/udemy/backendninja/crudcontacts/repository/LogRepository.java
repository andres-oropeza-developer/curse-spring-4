package com.udemy.backendninja.crudcontacts.repository;

import com.udemy.backendninja.crudcontacts.entity.LogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository(value = "LogRepository")
public interface LogRepository extends JpaRepository<LogEntity, Serializable> {
}
