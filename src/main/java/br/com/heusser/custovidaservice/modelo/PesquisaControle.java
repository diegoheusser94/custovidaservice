package br.com.heusser.custovidaservice.modelo;

import java.util.Date;

import br.com.heusser.custovidaservice.dao.core.DAOFactory;
import br.com.heusser.custovidaservice.dao.pesquisacontrole.PesquisaControleDAO;

public class PesquisaControle {

	private int pesquisaControleid;
	private int semana;
	private int mes;
	private int ano;
	private Date dataEmissao;
	private Date dataEntrega;
	private boolean semanal;
	private boolean aberto;
	private Fonte fonte;
	private Usuario usuario;
	
	public int getPesquisaControleid() {
		return pesquisaControleid;
	}
	public void setPesquisaControleid(int pesquisaControleid) {
		this.pesquisaControleid = pesquisaControleid;
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
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public boolean isSemanal() {
		return semanal;
	}
	public void setSemanal(boolean semanal) {
		this.semanal = semanal;
	}
	public boolean isAberto() {
		return aberto;
	}
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	public Fonte getFonte() {
		return fonte;
	}
	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public static PesquisaControle get(int pesquisacontroleid) {
		PesquisaControleDAO dao = DAOFactory.getInstance().getPesquisaControleDAO();
		return dao.get(pesquisacontroleid);
	}
	public void alterar() throws Exception {
		PesquisaControleDAO dao = DAOFactory.getInstance().getPesquisaControleDAO();
		dao.alterar(this);
	}
	
}
