package br.com.heusser.custovidaservice.modelo;

public class Subgrupo {

	private int subgrupoid;
	private String identificador;
	private String descricao;
	private Grupo grupo;
	
	public int getSubgrupoid() {
		return subgrupoid;
	}
	public void setSubgrupoid(int subgrupoid) {
		this.subgrupoid = subgrupoid;
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
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
