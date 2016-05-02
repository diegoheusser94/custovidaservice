package br.com.heusser.custovidaservice.modelo;

import java.util.List;

import br.com.heusser.custovidaservice.dao.core.DAOFactory;
import br.com.heusser.custovidaservice.dao.pesquisacontrole.PesquisaControleDAO;
import br.com.heusser.custovidaservice.dao.usuario.UsuarioDAO;

public class Usuario {

	private int usuarioid;
	private String nomeCompleto;
	private String nick;
	private String senha;
	private boolean ativo;
	private TipoUsuario tipoUsuario;
	
	public static List<Usuario> listarPesquisadoresAtivos(){
		UsuarioDAO dao = DAOFactory.getInstance().getUsuarioDAO();
		return dao.listarPesquisadoresAtivos();
	}
	
	public static List<PesquisaControle> listarPesquisaControles(int usuarioid) {
		PesquisaControleDAO dao = DAOFactory.getInstance().getPesquisaControleDAO();
		return dao.listar(usuarioid);
	}
	
	public int getUsuarioid() {
		return usuarioid;
	}
	public void setUsuarioid(int usuarioid) {
		this.usuarioid = usuarioid;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	
}
