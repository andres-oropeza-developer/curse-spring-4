package com.udemy.backendninja.crudcontacts.controller;

import com.udemy.backendninja.crudcontacts.constant.Constant;
import com.udemy.backendninja.crudcontacts.converter.ContactConverter;
import com.udemy.backendninja.crudcontacts.entity.ContactEntity;
import com.udemy.backendninja.crudcontacts.log.Logger;
import com.udemy.backendninja.crudcontacts.model.ContactModel;
import com.udemy.backendninja.crudcontacts.service.ContactService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Controller
public class ContactController {

    public static final Log LOG_CLASS = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @Autowired
    @Qualifier("ContactService")
    ContactService contactService;

    @Autowired
    @Qualifier("ContactConverter")
    ContactConverter contactConverter;

    @GetMapping(Constant.URL_SHOW_CONTACTS)
    public ModelAndView showContacts(@RequestParam(name = "result", required = false) String result) {
        LOGGER.beginMethod(LOG_CLASS, "showContacts()",null);
        List<ContactModel> listContactModel = new ArrayList<>();
        List<ContactEntity> listContactEntity = contactService.getAllContacts();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (ContactEntity contactEntity: listContactEntity) {
            listContactModel.add(contactConverter.convertContactEntityToModel(contactEntity));
        }
        ModelAndView modelAndView = new ModelAndView(Constant.VIEW_CONTACTS);
        modelAndView.addObject("user", user.getUsername());
        modelAndView.addObject("contacts", listContactModel);
        modelAndView.addObject("result", result);
        LOGGER.endMethod(LOG_CLASS, "showContacts()", modelAndView);
        return modelAndView;
    }

    @PostMapping(Constant.URL_CREATE_CONTACT)
    public RedirectView createContact(@ModelAttribute(name = "contact") ContactModel contactModel) throws Exception{
        LOGGER.beginMethod(LOG_CLASS, "createContact()",null);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(Constant.URL_SHOW_CONTACTS);
        Properties properties = new Properties();
        try {
            if (null != contactService.saveContact(contactConverter
                    .convertContactModelToEntity(contactModel))) {
                properties.setProperty(Constant.RESULT_CONTACT, Constant.RESULT_CONTACT_CREATED);
                redirectView.setAttributes(properties);
            } else {
                properties.setProperty(Constant.RESULT_CONTACT, Constant.ERROR_CREATING_CONTACT);
                redirectView.setAttributes(properties);
            }
        } catch(Exception exception) {
            properties.setProperty(Constant.RESULT_CONTACT, Constant.ERROR_CREATING_CONTACT);
            redirectView.setAttributes(properties);
        }
        LOGGER.endMethod(LOG_CLASS, "createContact()", redirectView);
        return redirectView;
    }

    @PostMapping(Constant.URL_UPDATE_CONTACT)
    public RedirectView updateContact(@ModelAttribute(name = "contact") ContactModel contactModel) throws Exception{
        LOGGER.beginMethod(LOG_CLASS, "updateContact()",null);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(Constant.URL_SHOW_CONTACTS);
        Properties properties = new Properties();
        try {
            if (null != contactService.updateContact(contactConverter.convertContactModelToEntity(contactModel))) {
                properties.setProperty(Constant.RESULT_CONTACT, Constant.RESULT_CONTACT_UPDATED);
                redirectView.setAttributes(properties);
            } else {
                properties.setProperty(Constant.RESULT_CONTACT, Constant.ERROR_UPDATING_CONTACT);
                redirectView.setAttributes(properties);
            }
        } catch(Exception exception) {
            properties.setProperty(Constant.RESULT_CONTACT, Constant.ERROR_UPDATING_CONTACT);
            redirectView.setAttributes(properties);
        }
        LOGGER.endMethod(LOG_CLASS, "updateContact()", redirectView);
        return redirectView;
    }

    @GetMapping("/contact/deleteContact")
    public RedirectView deleteContact(@RequestParam(name = "id") int id) throws Exception{
        LOGGER.beginMethod(LOG_CLASS, "mainPage()",null);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(Constant.URL_SHOW_CONTACTS);
        Properties properties = new Properties();
        try {
            contactService.deleteContactById(id);
            properties.setProperty(Constant.RESULT_CONTACT, Constant.RESULT_CONTACT_DELETED);
            redirectView.setAttributes(properties);
        } catch(Exception exception) {
            properties.setProperty(Constant.RESULT_CONTACT, Constant.ERROR_DELETING_CONTACT);
            redirectView.setAttributes(properties);
        }
        LOGGER.endMethod(LOG_CLASS, "deleteContact()", redirectView);
        return redirectView;
    }

    @GetMapping("/contact/showContactForm")
    public ModelAndView showContactForm(
            @RequestParam(name = "operation", required = false) String operation,
            @RequestParam(name = "id", required = false) String id) throws Exception{
        ModelAndView modelAndView = new ModelAndView(Constant.VIEW_CONTACT_FORM);
        try {
            modelAndView.addObject("operation", operation);
            switch (operation) {
                case "create":
                    modelAndView.addObject("contact", new ContactModel());
                    break;
                case "update":
                    if (id != null) {
                        ContactEntity contactEntity = contactService.getContactById(Integer.parseInt(id));
                        modelAndView.addObject("contact",
                                contactConverter.convertContactEntityToModel(contactEntity));
                    }
                    break;
            }
        } catch (Exception exception) {}
        return modelAndView;
    }
}
