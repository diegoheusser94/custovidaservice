package br.com.heusser.custovidaservice.modelo;

import java.util.Date;
import java.util.List;

import br.com.heusser.custovidaservice.dao.core.DAOFactory;
import br.com.heusser.custovidaservice.dao.pesquisa.PesquisaDAO;

public class Pesquisa {

	private int pesquisaid;
	private int semana;
	private int mes;
	private int ano;
	private double valorLido;
	private boolean mudouMarca;
	private String especificacao;
	private String marca;
	private Date data;	
	private Item item;
	private Usuario usuario;
	private Fonte fonte;
	
	public int getPesquisaid() {
		return pesquisaid;
	}
	public void setPesquisaid(int pesquisaid) {
		this.pesquisaid = pesquisaid;
	}
	public int getSemana() {
		return semana;
	}
	public void setSemana(int semana) {
		this.semana = semana;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public double getValorLido() {
		return valorLido;
	}
	public void setValorLido(double valorLido) {
		this.valorLido = valorLido;
	}
	public boolean isMudouMarca() {
		return mudouMarca;
	}
	public void setMudouMarca(boolean mudouMarca) {
		this.mudouMarca = mudouMarca;
	}
	public String getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Fonte getFonte() {
		return fonte;
	}
	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}
	public static List<Pesquisa> listar(int usuarioid, int fonteid) {
		PesquisaDAO dao = DAOFactory.getInstance().getPesquisaDAO();
		return dao.listar(usuarioid, fonteid);
	}
	public int inserir() throws Exception {
		PesquisaDAO dao = DAOFactory.getInstance().getPesquisaDAO();
		return dao.inserir(this);
	}
	
}
