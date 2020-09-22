package com.udemy.backendninja.crudcontacts.converter;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.model.ContactModel;
import org.springframework.stereotype.Component;

@Component("ContactModelToContactEntity")
public class ContactModelToContactEntity {

    public ContactEntity convertContactModelToContactEntity(ContactModel contactModel) {

        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setId(contactModel.getId());
        contactEntity.setFirstName(contactModel.getFirstName());
        contactEntity.setLastName(contactModel.getLastName());
        contactEntity.setPhone(contactModel.getPhone());
        contactEntity.setCity(contactModel.getCity());

        return contactEntity;
    }
}
