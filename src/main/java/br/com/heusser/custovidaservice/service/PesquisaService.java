package br.com.heusser.custovidaservice.service;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.heusser.custovidaservice.modelo.Pesquisa;
import br.com.heusser.custovidaservice.modelo.PesquisaControle;

@Path("/pesquisas")
public class PesquisaService {

	@GET
	@Path("/pesquisacontroles/{pesquisacontroleid}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Pesquisa> listarUltimasPesquisa(@PathParam("pesquisacontroleid")int pesquisacontroleid){
		PesquisaControle pc = PesquisaControle.get(pesquisacontroleid);
		return Pesquisa.listar(pc.getUsuario().getUsuarioid(), pc.getFonte().getFonteid());
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserir(Pesquisa p){
		try {
			int id = p.inserir();
			return Response.created(new URI("pesquisas/"+id)).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
