package com.udemy.backendninja.crudcontacts.constant;

public class ContactConstant {

    /* Direcciones URL */
    public static final String URL_LOGIN         = "/login";
    public static final String URL_CONTACTS      = "/contacts";
    public static final String URL_MAIN          = "/contacts/main";
    public static final String URL_CREATE_CONTACT = "/contacts/create";
    public static final String URL_UPDATE_CONTACT = "/contacts/update";
    public static final String URL_DELETE_CONTACT = "/contacts/delete";

    /* Resultado Operaciones  */
    public static final String RESULT_CONTACT_CREATED = "?result=created";
    public static final String RESULT_CONTACT_UPDATED = "?result=updated";
    public static final String RESULT_CONTACT_DELETED = "?result=deleted";

    /* Errores */
    public static final String ERROR_CREATING_CONTACT = "?result=errorCreating";
    public static final String ERROR_UPDATING_CONTACT = "?result=errorUpdating";
    public static final String ERROR_DELETING_CONTACT = "?result=errorDeleting";

}
