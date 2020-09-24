package com.udemy.backendninja.crudcontacts.controller;

import com.udemy.backendninja.crudcontacts.constant.ContactConstant;
import com.udemy.backendninja.crudcontacts.log.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Component
@Controller("/")
public class LoginController {

    public static final Log LOG_CLASS = LogFactory.getLog(ContactController.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @RequestMapping(ContactConstant.URL_LOGIN)
    public String loginPage() {
        LOGGER.beginMethod(LOG_CLASS, "loginPage()",null);
        LOGGER.endMethod(LOG_CLASS, "loginPage()", "login");
        return "login";
    }

    @PostMapping(ContactConstant.URL_LOGIN_VALIDATE)
    public RedirectView validateLogin() {
        return new RedirectView(ContactConstant.URL_SHOW_CONTACTS);
    }
}
