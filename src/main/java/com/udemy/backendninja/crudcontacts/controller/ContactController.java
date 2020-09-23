package com.udemy.backendninja.crudcontacts.controller;

import com.udemy.backendninja.crudcontacts.constant.ContactConstant;
import com.udemy.backendninja.crudcontacts.converter.ContactEntityToContactModel;
import com.udemy.backendninja.crudcontacts.converter.ContactModelToContactEntity;
import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.log.Logger;
import com.udemy.backendninja.crudcontacts.model.ContactModel;
import com.udemy.backendninja.crudcontacts.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;

@Component
@Controller(ContactConstant.URL_CONTACTS)
public class ContactController {

    public static final Log LOG_CLASS = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @Autowired
    @Qualifier("ContactService")
    ContactService contactService;

    @Autowired
    @Qualifier("ContactEntityToContactModel")
    ContactEntityToContactModel contactEntityToContactModel;

    @Autowired
    @Qualifier("ContactModelToContactEntity")
    ContactModelToContactEntity contactModelToContactEntity;

    @RequestMapping(ContactConstant.URL_LOGIN)
    public String loginPage() {
        LOGGER.beginMethod(LOG_CLASS, "loginPage()",null);
        LOGGER.endMethod(LOG_CLASS, "loginPage()", "login");
        return "login";
    }

    @RequestMapping(ContactConstant.URL_MAIN)
    public ModelAndView mainPage() {
        LOGGER.beginMethod(LOG_CLASS, "mainPage()",null);
        List<ContactModel> listContactModel = new ArrayList<>();
        List<ContactEntity> listContactEntity = contactService.getAllContacts();
        for (ContactEntity contactEntity: listContactEntity) {
            listContactModel.add(contactEntityToContactModel.convertContactEntityToContactModel(contactEntity));
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listContacts", listContactModel);
        LOGGER.endMethod(LOG_CLASS, "mainPage()", modelAndView);
        return modelAndView;
    }

    @PostMapping(ContactConstant.URL_CREATE_CONTACT)
    public RedirectView createContact(@ModelAttribute(name = "contact") ContactModel contactModel) throws Exception{
        LOGGER.beginMethod(LOG_CLASS, "createContact()",null);
        ContactModel contactModelTest = new ContactModel(6, "Freddy", "Oropeza", 444444444 ,"Seatle");
        String url = ContactConstant.URL_CONTACTS;

        try {
            if (null != contactService.saveContact(contactModelToContactEntity
                    .convertContactModelToContactEntity(contactModelTest))) {
                url += ContactConstant.RESULT_CONTACT_CREATED;
            } else {
                url += ContactConstant.ERROR_CREATING_CONTACT;
            }
        } catch(Exception exception) {
            url += ContactConstant.ERROR_CREATING_CONTACT;
        }
        LOGGER.endMethod(LOG_CLASS, "createContact()", url);
        return new RedirectView(url);
    }

    @PostMapping(ContactConstant.URL_UPDATE_CONTACT)
    public RedirectView updateContact(@ModelAttribute(name = "contact") ContactModel contactModel) throws Exception{
        LOGGER.beginMethod(LOG_CLASS, "updateContact()",null);
        //        ContactModel contactModelTest = new ContactModel(6, "Freddy", "Oropeza", 444444444 ,"Seatle");
        String url = ContactConstant.URL_CONTACTS;
        try {
            if (null != contactService.updateContact(
                    contactModelToContactEntity.convertContactModelToContactEntity(contactModel))) {
                url += ContactConstant.RESULT_CONTACT_UPDATED;
            } else {
                url += ContactConstant.ERROR_UPDATING_CONTACT;
            }
        } catch(Exception exception) {
            url += ContactConstant.ERROR_UPDATING_CONTACT;
        }
        LOGGER.endMethod(LOG_CLASS, "updateContact()", url);
        return new RedirectView(url);
    }

    @PostMapping(ContactConstant.URL_DELETE_CONTACT)
    public RedirectView deleteContact(@ModelAttribute(name = "deleteContact") ContactModel contactModel) throws Exception{
        LOGGER.beginMethod(LOG_CLASS, "mainPage()",null);
//        ContactModel contactModelTest = new ContactModel(6, "Freddy", "Oropeza", 444444444 ,"Seatle");
        String url = ContactConstant.URL_CONTACTS;
        try {
            contactService.deleteContact(contactModelToContactEntity
                    .convertContactModelToContactEntity(contactModel));
            url += ContactConstant.RESULT_CONTACT_DELETED;
        } catch(Exception exception) {
            url += ContactConstant.ERROR_DELETING_CONTACT;
        }
        LOGGER.endMethod(LOG_CLASS, "deleteContact()", url);
        return new RedirectView(url);
    }
}
