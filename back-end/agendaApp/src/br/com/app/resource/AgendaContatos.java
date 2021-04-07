package br.com.app.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;



@Path("/agenda")
public class AgendaContatos {
	
	List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

	public void init() {
		listaPessoas.add(new Pessoa("pessoa 1", 1));
		listaPessoas.add(new Pessoa("pessoa 2", 2));
		listaPessoas.add(new Pessoa("pessoa 3", 3));
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar")
	public List<Pessoa> listar() {
		init();
		return listaPessoas;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listar/id/{id}")
	public Response listarId(@PathParam("id") String id) {
		init();
		int _id = Integer.parseInt(id);
		for(Pessoa p: listaPessoas) {
			if (p.getIdade() == _id)
				return Response.status(Status.OK).entity(p).build();
		}
		return Response.status(Status.NO_CONTENT).build();
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/inserir")
	public Response inserir(Pessoa p) {
		init();
		listaPessoas.add(p);
		return Response.status(Status.CREATED).entity(p).build();		
		
	
	}
	

}
