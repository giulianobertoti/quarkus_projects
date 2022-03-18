package org.park;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import com.google.gson.Gson;

@Path("/carro")
public class Controller {

	
	Model model = new Model();
	
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{modelo}/{marca}/{cor}/")
    public Response carro2(@PathParam String modelo, @PathParam String marca, @PathParam String cor) {	
		List<Carro> carrosEncontrados = model.buscarEspecificacao(new Especificacao(modelo, marca, cor));	
		String json = new Gson().toJson(carrosEncontrados);
    	return Response.status(200).entity(json).build();	
    }
	
	
	
	
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasymmmmmmm";
    }
}