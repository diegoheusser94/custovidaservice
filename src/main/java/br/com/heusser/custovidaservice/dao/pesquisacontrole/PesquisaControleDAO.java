package br.com.heusser.custovidaservice.dao.pesquisacontrole;

import java.util.List;

import br.com.heusser.custovidaservice.modelo.PesquisaControle;

public interface PesquisaControleDAO {

	public List<PesquisaControle> listar(int usuarioid);
	
	public PesquisaControle get(int pesquisacontroleid);

	public void alterar(PesquisaControle pesquisaControle) throws Exception;

}
