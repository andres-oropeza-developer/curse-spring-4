package com.udemy.backendninja.crudcontacts.controller;

import com.udemy.backendninja.crudcontacts.model.ContactModel;
import com.udemy.backendninja.crudcontacts.service.ContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContactControllerTest {

    public ContactControllerTest() {
    }

    private MockMvc mockMvc;

//    @Mock
//    private ContactService contactService;

    @InjectMocks
    private ContactController contactController;

    @Before
    public void setUp() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(contactController).build();
    }

    @Test
    public void testGetContacts() throws Exception {
//        List<ContactModel> contactModels = new ArrayList<ContactModel>();


        // .andExpect(model().attribute("listContacts", contactService.getAllContacts()));
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}