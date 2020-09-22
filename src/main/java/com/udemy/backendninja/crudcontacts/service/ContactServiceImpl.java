package com.udemy.backendninja.crudcontacts.service;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.repository.ContactJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("ContactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("ContactJpaRepository")
    ContactJpaRepository contactJpaRepository;

    @Override
    public List<ContactEntity> getAllContacts(){
        return contactJpaRepository.findAll();
    }

    @Override
    public ContactEntity getContactById(int id) {
        return contactJpaRepository.getContactEntityById(id);
    }

    @Override
    public ContactEntity updateContact(ContactEntity contactEntity) {
        return contactJpaRepository.save(contactEntity);
    }

    @Override
    public ContactEntity saveContact(ContactEntity contactEntity) {
        return contactJpaRepository.save(contactEntity);
    }

    @Override
    public void deleteContact(ContactEntity contactEntity) {
        contactJpaRepository.delete(contactEntity);
    }
}
