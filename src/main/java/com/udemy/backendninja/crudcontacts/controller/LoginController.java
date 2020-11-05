package com.udemy.backendninja.crudcontacts.controller;

import com.udemy.backendninja.crudcontacts.constant.Constant;
import com.udemy.backendninja.crudcontacts.log.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    public static final Log LOG_CLASS = LogFactory.getLog(LoginController.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @GetMapping(Constant.URL_LOGIN)
    public ModelAndView loginPage(
            @RequestParam(name = "logout", required = false) String logout,
            @RequestParam(name = "error", required = false) String error) {
        LOGGER.beginMethod(LOG_CLASS, "loginPage()",logout, error);
            ModelAndView modelAndView = new ModelAndView(Constant.VIEW_LOGIN);
            modelAndView.addObject("logout", logout);
            modelAndView.addObject("error", error);
        LOGGER.endMethod(LOG_CLASS, "loginPage()", modelAndView);
        return modelAndView;
    }

    @GetMapping(Constant.URL_LOGIN_VALIDATE)
    public RedirectView validateLogin() {
        return new RedirectView(Constant.URL_SHOW_CONTACTS);
    }
}
