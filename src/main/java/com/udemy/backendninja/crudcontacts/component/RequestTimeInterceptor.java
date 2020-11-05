package com.udemy.backendninja.crudcontacts.component;

import com.udemy.backendninja.crudcontacts.entity.LogEntity;
import com.udemy.backendninja.crudcontacts.log.Logger;
import com.udemy.backendninja.crudcontacts.service.impl.LogService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component("RequestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    public static final Log LOG_CLASS = LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @Autowired
    @Qualifier(value = "LogService")
    LogService logService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String url = request.getRequestURL().toString();

        logService.save(new LogEntity(
                new Date(),
                user.getUsername(),
                authentication.getDetails().toString(),
                url));

        LOGGER.requestTime(LOG_CLASS, url, System.currentTimeMillis() - startTime);
    }
}
