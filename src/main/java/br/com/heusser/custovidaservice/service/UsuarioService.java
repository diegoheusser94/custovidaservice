package br.com.heusser.custovidaservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.heusser.custovidaservice.modelo.Fonte;
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
	
}
