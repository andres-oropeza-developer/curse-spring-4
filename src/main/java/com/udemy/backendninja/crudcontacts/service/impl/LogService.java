package com.udemy.backendninja.crudcontacts.service.impl;

import com.udemy.backendninja.crudcontacts.repository.LogRepository;
import org.springframework.stereotype.Service;

@Service(value = "LogService")
public interface LogService extends LogRepository {
}
