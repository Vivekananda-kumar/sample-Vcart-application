package com.Vcart.VcartManagement.Config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.Vcart.VcartManagement.Controller.VcartManagementController;
import com.Vcart.VcartManagement.Services.VcartManagementServices;
import com.Vcart.VcartManagement.errorhandler.BadRequestMapper;
import com.Vcart.VcartManagement.errorhandler.CategoryNotFoundException;
import com.Vcart.VcartManagement.errorhandler.GlobalExceptionHandler;
import com.Vcart.VcartManagement.errorhandler.IteamNotFoundException;
import com.Vcart.VcartManagement.errorhandler.JsonMappingErrorHandler;
import com.Vcart.VcartManagement.errorhandler.NotFoundMapper;
import com.Vcart.VcartManagement.errorhandler.ServerErrorMapper;
import com.Vcart.VcartManagement.errorhandler.UnprocessableEntityMapper;

@Configuration
public class VcartConfig extends ResourceConfig {
	
	public VcartConfig(){
	register(VcartManagementController.class);
	register(VcartManagementServices.class);
	register(GlobalExceptionHandler.class);
	register(IteamNotFoundException.class);
	register(CategoryNotFoundException.class);
	  // Error handling
    register(ServerErrorMapper.class);
    register(NotFoundMapper.class);
    register(BadRequestMapper.class);
    register(JsonMappingErrorHandler.class);
    register(UnprocessableEntityMapper.class);
	}
}
