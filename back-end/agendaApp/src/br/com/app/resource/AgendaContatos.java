package br.com.app.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/agenda")
public class AgendaContatos {
	
	@GET
	public String listar() {
		return "esta eh a funcao de listar";
	}

}
