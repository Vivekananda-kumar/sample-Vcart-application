package com.Vcart.VcartManagement.errorhandler;

import javax.ws.rs.core.Response;

public abstract class AbstractBaseErrorMapper {

   
    protected int getStatusCode() {
        return 500;
    }

    /**
     * Logs exception
     *
     * @param ex Exception to log
     */
    protected void logError(Exception ex) {
       
        ex.printStackTrace();
    }

    public Response getResponse(Exception ex) {
        logError(ex);
        return Response.status(getStatusCode()).
                entity(new Error(ex.getMessage(),getStatusCode())).
                type("application/json").
                build();
    }
}

