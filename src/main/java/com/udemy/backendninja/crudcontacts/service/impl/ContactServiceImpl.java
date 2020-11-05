package com.udemy.backendninja.crudcontacts.service.impl;

import com.udemy.backendninja.crudcontacts.controller.ContactController;
import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.log.Logger;
import com.udemy.backendninja.crudcontacts.repository.ContactRepository;
import com.udemy.backendninja.crudcontacts.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("ContactService")
public class ContactServiceImpl implements ContactService {

    public static final Log LOG_CLASS = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @Autowired
    @Qualifier("ContactJpaRepository")
    ContactRepository contactRepository;

    @Override
    public List<ContactEntity> getAllContacts(){
        LOGGER.beginMethod(LOG_CLASS, "getAllContacts()",null);
        List<ContactEntity> listContactEntity = contactRepository.findAll();
        LOGGER.endMethod(LOG_CLASS, "getAllContacts()", listContactEntity);
        return listContactEntity;
    }

    @Override
    public ContactEntity getContactById(int id) {
        LOGGER.beginMethod(LOG_CLASS, "getContactById()",id);
        ContactEntity contactEntity = contactRepository.getContactEntityById(id);
        LOGGER.endMethod(LOG_CLASS, "getContactById()", contactEntity);
        return contactEntity;
    }

    @Override
    public ContactEntity updateContact(ContactEntity contactEntity) {
        LOGGER.beginMethod(LOG_CLASS, "updateContact()",contactEntity);
        ContactEntity contactEntityResult = contactRepository.save(contactEntity);
        LOGGER.endMethod(LOG_CLASS, "updateContact()", contactEntity);
        return contactEntityResult;
    }

    @Override
    public ContactEntity saveContact(ContactEntity contactEntity) {
        LOGGER.beginMethod(LOG_CLASS, "saveContact()",contactEntity);
        ContactEntity contactEntityResult = contactRepository.save(contactEntity);
        LOGGER.endMethod(LOG_CLASS, "saveContact()", contactEntity);
        return contactEntityResult;
    }

    @Override
    public void deleteContactById(int id) {
        LOGGER.beginMethod(LOG_CLASS, "deleteContact()",id);
        contactRepository.deleteById(id);
        LOGGER.endMethod(LOG_CLASS, "deleteContact()", null);
    }
}
