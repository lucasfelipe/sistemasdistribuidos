package com.facnet.sistemasdistribuidos.jersey.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/RestAPI")
public class RestAPI {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello WS";
	}

}
