package br.com.heusser.custovidaservice.dao.core;

import br.com.heusser.custovidaservice.dao.fonte.FonteDAO;
import br.com.heusser.custovidaservice.dao.item.ItemDAO;
import br.com.heusser.custovidaservice.dao.mysql.DAOFactoryMysql;
import br.com.heusser.custovidaservice.dao.pesquisa.PesquisaDAO;
import br.com.heusser.custovidaservice.dao.pesquisacontrole.PesquisaControleDAO;
import br.com.heusser.custovidaservice.dao.usuario.UsuarioDAO;

public abstract class DAOFactory {

	public static DAOFactory getInstance(){
		return new DAOFactoryMysql();
	}
	
	public abstract ItemDAO getItemDAO();
	public abstract FonteDAO getFonteDAO();
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract PesquisaDAO getPesquisaDAO();
	public abstract PesquisaControleDAO getPesquisaControleDAO();
	
	
}
