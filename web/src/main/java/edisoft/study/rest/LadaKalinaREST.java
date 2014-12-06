package edisoft.study.rest;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import edisoft.study.model.LadaKalina;
import edisoft.study.service.ILadaKalinaManagerLocal;

@Path("lada_kalina")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LadaKalinaREST {

	
	@EJB
	private ILadaKalinaManagerLocal kalinaManager;
	
	
	@POST
	@Path("/")
	public LadaKalina create(Map<String, Integer> params){
		LadaKalina car = kalinaManager.create(params.get("doorsCount"), params.get("power"));
		return car;
	}
	
	@GET
	@Path("/{id}")
	public String find(@PathParam("id")String id){
		LadaKalina car= kalinaManager.get(id);
		ObjectMapper om = new ObjectMapper();
		String ret = null;
		try {
			ret = om.writeValueAsString(car);
		} catch (Exception e){
			e.printStackTrace();
		}
		return ret;
	}
}
