package br.com.heusser.custovidaservice.modelo;

import java.util.List;

import br.com.heusser.custovidaservice.dao.core.DAOFactory;
import br.com.heusser.custovidaservice.dao.fonte.FonteDAO;

public class Fonte {

	private int fonteid;
	private String descricao;
	private String localizacao;
	
	public static List<Fonte> listar(int usuarioid){
		FonteDAO dao = DAOFactory.getInstance().getFonteDAO();
		return dao.listar(usuarioid);
	}
	
	public int getFonteid() {
		return fonteid;
	}
	public void setFonteid(int fonteid) {
		this.fonteid = fonteid;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
}
