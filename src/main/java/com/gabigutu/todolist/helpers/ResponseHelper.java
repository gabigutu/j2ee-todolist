package com.gabigutu.todolist.helpers;

import com.gabigutu.todolist.ServerResponse;

public class ResponseHelper {

    public static ServerResponse objectAsServerResponse(Object object, boolean success, String errorMessage) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setData(object);
        serverResponse.setSuccess(success);
        serverResponse.setErrorMessage(errorMessage);
        return serverResponse;
    }

}
