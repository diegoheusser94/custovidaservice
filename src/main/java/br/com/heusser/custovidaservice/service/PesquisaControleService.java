package br.com.heusser.custovidaservice.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.heusser.custovidaservice.modelo.PesquisaControle;

@Path("/pesquisacontroles")
public class PesquisaControleService {

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(PesquisaControle pc){
		try {
			pc.alterar();
			return Response.ok("Alterado com sucesso", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
