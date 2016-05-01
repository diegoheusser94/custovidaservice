package br.com.heusser.custovidaservice.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.heusser.custovidaservice.modelo.Item;

@Path("/itens")
public class ItemService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Item> listar(){
		return Item.getItens();
	}
}
