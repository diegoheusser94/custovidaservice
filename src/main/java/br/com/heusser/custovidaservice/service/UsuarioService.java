package br.com.heusser.custovidaservice.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.heusser.custovidaservice.modelo.Fonte;
import br.com.heusser.custovidaservice.modelo.PesquisaControle;
import br.com.heusser.custovidaservice.modelo.Usuario;

@Path("/usuarios")
public class UsuarioService {

	@GET
	@Path("/pesquisadores/ativos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listarPesquisadoresAtivos(){
		return Usuario.listarPesquisadoresAtivos();
	}
	
	@GET
	@Path("/{usuarioid}/fontes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Fonte> listarFontes(@PathParam("usuarioid") int usuarioid){
		return Fonte.listar(usuarioid);
	}
	
	@GET
	@Path("/{usuarioid}/pesquisacontroles/abertas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PesquisaControle> listarPesquisaControles(@PathParam("usuarioid") int usuarioid){
		return Usuario.listarPesquisaControles(usuarioid);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response alterar(Usuario u){
		try {
			u.alterar();
			return Response.ok("Alterado com sucesso", MediaType.TEXT_PLAIN).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
}
