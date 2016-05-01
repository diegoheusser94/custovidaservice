package br.com.heusser.custovidaservice.modelo;

import java.util.List;

import br.com.heusser.custovidaservice.dao.core.DAOFactory;
import br.com.heusser.custovidaservice.dao.item.ItemDAO;

public class Item {

	private int itemid;
	private String identificador;
	private String descricao;
	private Produto produto;
	
	public static List<Item> getItens(){
		ItemDAO dao = DAOFactory.getInstance().getItemDAO();
		return dao.listar();
	}
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
		
}
