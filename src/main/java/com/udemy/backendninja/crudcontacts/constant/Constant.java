package com.udemy.backendninja.crudcontacts.constant;

public class Constant {

    /* Direcciones URL */
    public static final String URL_LOGIN          = "/login";
    public static final String URL_LOGIN_VALIDATE = "/login/validate";
    public static final String URL_CONTACTS       = "/contacts";
    public static final String URL_SHOW_CONTACTS  = "/contacts/showcontacts";
    public static final String URL_CREATE_CONTACT = "/contacts/create";
    public static final String URL_UPDATE_CONTACT = "/contacts/update";
    public static final String URL_DELETE_CONTACT = "/contacts/delete";

    /* Vistas */
    public static final String VIEW_LOGIN        = "login";
    public static final String VIEW_CONTACT_FORM = "contactform";
    public static final String VIEW_CONTACTS     = "contacts";

    /* Resultado Operaciones  */
    public static final String RESULT_CONTACT = "result";
    public static final String RESULT_CONTACT_CREATED = "created";
    public static final String RESULT_CONTACT_UPDATED = "updated";
    public static final String RESULT_CONTACT_DELETED = "deleted";
    public static final String ERROR_CREATING_CONTACT = "error-created";
    public static final String ERROR_UPDATING_CONTACT = "error-updated";
    public static final String ERROR_DELETING_CONTACT = "error-deleted";

}
