package com.Vcart.VcartManagement.errorhandler;

import javax.ws.rs.ext.Provider;

@Provider
public class IteamNotFoundException extends RuntimeException {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -6558231219120043643L;

	public IteamNotFoundException() {
		
		super();
		System.out.println("step 2a");
		// TODO Auto-generated constructor stub
	}

	public IteamNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.out.println("step 2b");
	}
}
