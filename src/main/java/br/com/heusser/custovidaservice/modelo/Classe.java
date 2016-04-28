package br.com.heusser.custovidaservice.modelo;

public class Classe {
	
	private int classeid;
	private String identificador;
	private String descricao;
	private Subgrupo subgrupo;
	
	public int getClasseid() {
		return classeid;
	}
	public void setClasseid(int classeid) {
		this.classeid = classeid;
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
	public Subgrupo getSubgrupo() {
		return subgrupo;
	}
	public void setSubgrupo(Subgrupo subgrupo) {
		this.subgrupo = subgrupo;
	}
	
}
