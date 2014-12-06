package edisoft.study.rest;

import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("test")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class HelloRestApi {

	@Path("hello")
	@GET
	public String hello() {
		return "Hello REST!";
	}
	
	@Path("sum/{d1}/{d2}")
	@GET
	public String sum(@PathParam("d1")Long d1, @PathParam("d2")Long d2){
		
		if(d1 == null || d2 == null)
			throw new IllegalArgumentException("One of digits is null!");
		
		Long result = d1 + d2;
		
		return result.toString();
	}
	
	@Path("test_params")
	@GET
	public String parseParams(@QueryParam("flag")Boolean flag, @QueryParam("dig")BigDecimal dig){
		return String.format("Flag is %s. Digit is: %s", flag.toString(), dig.toString());
	}
}
