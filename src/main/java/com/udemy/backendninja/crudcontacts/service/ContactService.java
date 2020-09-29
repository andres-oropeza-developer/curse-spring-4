package com.udemy.backendninja.crudcontacts.service;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import java.util.List;

public interface ContactService{

    public List<ContactEntity> getAllContacts();

    public ContactEntity getContactById(int id);

    public ContactEntity updateContact(ContactEntity contactEntity);

    public ContactEntity saveContact(ContactEntity contactEntity);

    public void deleteContactById(int id);

}
