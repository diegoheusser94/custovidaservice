package br.com.heusser.custovidaservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
	
}
