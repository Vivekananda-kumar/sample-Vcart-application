package com.Vcart.VcartManagement.Controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Vcart.VcartManagement.Controller.Request.Category;
import com.Vcart.VcartManagement.Controller.Request.Product;
import com.Vcart.VcartManagement.Services.VcartManagementServices;

@Component
@Path("/Vcart")
public class VcartManagementController {
	@Autowired
	VcartManagementServices vcart = new VcartManagementServices();

	@GET
	@Path("item/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response Item(@PathParam("id") int prodcuctid) {
		System.out.println("product: " + vcart.getItem(prodcuctid));

		return Response.status(200).entity(vcart.getItem(prodcuctid)).build();
	}

	@GET
	@Path("getItems")
	@Produces(MediaType.APPLICATION_JSON)
	public Response AllItems() {
		System.out.println();
		return Response.status(200).entity(vcart.getAllItem()).build();
	}

	@POST
	@Path("addItem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addItem(Category item) throws Exception {

		return Response.status(200).entity(vcart.addItem(item)).build();
	}

	@PATCH
	@Path("updateItem")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateItem(Product i) throws Exception {
		return Response.status(200).entity(vcart.updateItem(i)).build();
	}

	@DELETE
	@Path("deleteItem/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteItem(@PathParam("name") String name) {
		return Response.status(Status.OK).entity(vcart.deleteItem(name)).build();

	}

}
