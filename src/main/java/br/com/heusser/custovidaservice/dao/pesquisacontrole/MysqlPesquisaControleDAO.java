package br.com.heusser.custovidaservice.dao.pesquisacontrole;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.heusser.custovidaservice.dao.mysql.Conexao;
import br.com.heusser.custovidaservice.modelo.Fonte;
import br.com.heusser.custovidaservice.modelo.PesquisaControle;
import br.com.heusser.custovidaservice.modelo.Usuario;

public class MysqlPesquisaControleDAO implements PesquisaControleDAO {

	@Override
	public List<PesquisaControle> listar(int usuarioid) {
		Connection con = Conexao.get();
		String select = "SELECT p.* FROM pesquisacontrole as p INNER JOIN usuario as u ON p.usuarioid = u.usuarioid WHERE p.aberto = 1 AND u.usuarioid = "+usuarioid;
		List<PesquisaControle> lista = new ArrayList<>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);
			while (rs.next()) {
				PesquisaControle p = new PesquisaControle();
				p.setAberto(rs.getBoolean("aberto"));
				p.setAno(rs.getInt("ano"));
				p.setDataEmissao(rs.getDate("dataEmissao"));
				p.setDataEntrega(rs.getDate("dataEntrega"));
				Fonte f = new Fonte();
				f.setFonteid(rs.getInt("fonteid"));
				p.setFonte(f);
				p.setMes(rs.getInt("mes"));
				p.setPesquisaControleid(rs.getInt("pesquisacontroleid"));
				p.setSemana(rs.getInt("semana"));
				p.setSemanal(rs.getBoolean("semanal"));
				Usuario u = new Usuario();
				u.setUsuarioid(rs.getInt("usuarioid"));
				p.setUsuario(u);
				lista.add(p);
			}
			rs.close();
			st.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public PesquisaControle get(int pesquisacontroleid) {
		Connection con = Conexao.get();
		String select = "SELECT p.* FROM pesquisacontrole as p WHERE p.pesquisacontroleid = "+pesquisacontroleid;
		PesquisaControle p = new PesquisaControle();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);
			while (rs.next()) {
				p.setAberto(rs.getBoolean("aberto"));
				p.setAno(rs.getInt("ano"));
				p.setDataEmissao(rs.getDate("dataEmissao"));
				p.setDataEntrega(rs.getDate("dataEntrega"));
				Fonte f = new Fonte();
				f.setFonteid(rs.getInt("fonteid"));
				p.setFonte(f);
				p.setMes(rs.getInt("mes"));
				p.setPesquisaControleid(rs.getInt("pesquisacontroleid"));
				p.setSemana(rs.getInt("semana"));
				p.setSemanal(rs.getBoolean("semanal"));
				Usuario u = new Usuario();
				u.setUsuarioid(rs.getInt("usuarioid"));
				p.setUsuario(u);
			}
			rs.close();
			st.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}



}
