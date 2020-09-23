package com.udemy.backendninja.crudcontacts.converter;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.log.Logger;
import com.udemy.backendninja.crudcontacts.model.ContactModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ContactModelToContactEntity")
public class ContactModelToContactEntity {

    public static final Log LOG_CLASS = LogFactory.getLog(ContactModelToContactEntity.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    public ContactEntity convertContactModelToContactEntity(ContactModel contactModel) {
        LOGGER.beginMethod(LOG_CLASS, "convertContactModelToContactEntity()", contactModel);
        ContactEntity contactEntity = new ContactEntity();
        contactEntity.setId(contactModel.getId());
        contactEntity.setFirstName(contactModel.getFirstName());
        contactEntity.setLastName(contactModel.getLastName());
        contactEntity.setPhone(contactModel.getPhone());
        contactEntity.setCity(contactModel.getCity());
        LOGGER.endMethod(LOG_CLASS, "convertContactModelToContactEntity()", contactEntity);
        return contactEntity;
    }
}
