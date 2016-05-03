package br.com.heusser.custovidaservice.dao.pesquisa;

import java.util.List;

import br.com.heusser.custovidaservice.modelo.Pesquisa;

public interface PesquisaDAO {

	public List<Pesquisa> listar(int usuarioid, int fonteid);

	public int inserir(Pesquisa pesquisa) throws Exception;

}
