package com.Vcart.VcartManagement.errorhandler;

import javax.ws.rs.ext.Provider;

@Provider
public class CategoryNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7891729388553500226L;


	public CategoryNotFoundException() {
		
		super();
		System.out.println("step 2a");
		// TODO Auto-generated constructor stub
	}

	public CategoryNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		System.out.println("step 2b");
	}
}
