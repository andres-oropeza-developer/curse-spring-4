package com.udemy.backendninja.crudcontacts.converter;

import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.log.Logger;
import com.udemy.backendninja.crudcontacts.model.ContactModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ContactEntityToContactModel")
public class ContactEntityToContactModel {

    public static final Log LOG_CLASS = LogFactory.getLog(ContactEntityToContactModel.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    public ContactModel convertContactEntityToContactModel(ContactEntity contactEntity) {
        LOGGER.beginMethod(LOG_CLASS, "convertContactEntityToContactModel()", contactEntity);
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contactEntity.getId());
        contactModel.setFirstName(contactEntity.getFirstName());
        contactModel.setLastName(contactEntity.getLastName());
        contactModel.setPhone(contactEntity.getPhone());
        contactModel.setCity(contactEntity.getCity());

        LOGGER.endMethod(LOG_CLASS, "convertContactEntityToContactModel()", contactModel);
        return contactModel;
    }
}
