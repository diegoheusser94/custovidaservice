package br.com.heusser.custovidaservice.dao.mysql;

import br.com.heusser.custovidaservice.dao.core.DAOFactory;
import br.com.heusser.custovidaservice.dao.fonte.FonteDAO;
import br.com.heusser.custovidaservice.dao.fonte.MysqlFonteDAO;
import br.com.heusser.custovidaservice.dao.item.ItemDAO;
import br.com.heusser.custovidaservice.dao.item.MysqlItemDAO;
import br.com.heusser.custovidaservice.dao.pesquisa.MysqlPesquisaDAO;
import br.com.heusser.custovidaservice.dao.pesquisa.PesquisaDAO;
import br.com.heusser.custovidaservice.dao.pesquisacontrole.MysqlPesquisaControleDAO;
import br.com.heusser.custovidaservice.dao.pesquisacontrole.PesquisaControleDAO;
import br.com.heusser.custovidaservice.dao.usuario.MysqlUsuarioDAO;
import br.com.heusser.custovidaservice.dao.usuario.UsuarioDAO;

public class DAOFactoryMysql extends DAOFactory {

	@Override
	public ItemDAO getItemDAO() {
		return new MysqlItemDAO();
	}

	@Override
	public FonteDAO getFonteDAO() {
		return new MysqlFonteDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MysqlUsuarioDAO();
	}

	@Override
	public PesquisaDAO getPesquisaDAO() {
		return new MysqlPesquisaDAO();
	}

	@Override
	public PesquisaControleDAO getPesquisaControleDAO() {
		return new MysqlPesquisaControleDAO();
	}

}
