package br.com.heusser.custovidaservice.dao.fonte;

import java.util.List;

import br.com.heusser.custovidaservice.modelo.Fonte;

public interface FonteDAO {

	public List<Fonte> listar(int usuarioid);
	
}
