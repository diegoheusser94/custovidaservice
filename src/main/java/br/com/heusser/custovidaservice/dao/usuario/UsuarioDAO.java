package br.com.heusser.custovidaservice.dao.usuario;

import java.util.List;

import br.com.heusser.custovidaservice.modelo.Usuario;

public interface UsuarioDAO {

	public List<Usuario> listarPesquisadoresAtivos();

	public void alterar(Usuario u) throws Exception;
	
}
