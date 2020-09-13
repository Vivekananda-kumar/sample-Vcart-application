package com.Vcart.VcartManagement.errorhandler;

import javax.ws.rs.ext.Provider;

@Provider
public class UnauthorizedException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2634038242862085066L;

	public UnauthorizedException(String message) {
        super(message);
    }

}