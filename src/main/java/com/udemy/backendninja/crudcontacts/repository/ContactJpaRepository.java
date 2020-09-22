package com.udemy.backendninja.crudcontacts.repository;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.io.Serializable;

@Repository("ContactJpaRepository")
public interface ContactJpaRepository extends JpaRepository<ContactEntity, Serializable> {

    public abstract ContactEntity getContactEntityById(int id);
}
