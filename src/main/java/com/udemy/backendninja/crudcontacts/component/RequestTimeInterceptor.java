package com.udemy.backendninja.crudcontacts.component;

import com.udemy.backendninja.crudcontacts.log.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("RequestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

    public static final Log LOG_CLASS = LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("Logger")
    Logger LOGGER;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        System.out.println("Prueba Andres");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        LOGGER.requestTime(LOG_CLASS, request.getRequestURL().toString(), System.currentTimeMillis() - startTime);
    }
}
