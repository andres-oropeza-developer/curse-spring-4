package com.udemy.backendninja.crudcontacts.converter;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("ContactEntityToContactModel")
public class ContactEntityToContactModel {

    public ContactModel convertContactEntityToContactModel(ContactEntity contactEntity) {
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contactEntity.getId());
        contactModel.setFirstName(contactEntity.getFirstName());
        contactModel.setLastName(contactEntity.getLastName());
        contactModel.setPhone(contactEntity.getPhone());
        contactModel.setCity(contactEntity.getCity());
        return contactModel;
    }
}
