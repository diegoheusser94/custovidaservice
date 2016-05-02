package br.com.heusser.custovidaservice.dao.pesquisa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.heusser.custovidaservice.dao.mysql.Conexao;
import br.com.heusser.custovidaservice.modelo.Fonte;
import br.com.heusser.custovidaservice.modelo.Item;
import br.com.heusser.custovidaservice.modelo.Pesquisa;
import br.com.heusser.custovidaservice.modelo.Usuario;

public class MysqlPesquisaDAO implements PesquisaDAO {

	@Override
	public List<Pesquisa> listar(int usuarioid, int fonteid) {
		Connection con = Conexao.get();
		String select = "SELECT itemid FROM item";
		List<Pesquisa> lista = new ArrayList<>();
		List<Integer> itemids = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);
			while (rs.next()) {
				Integer i = new Integer(rs.getInt("itemid"));
				itemids.add(i);
			}
			rs.close();
			for (Integer i : itemids){
				String select2 = "SELECT * FROM pesquisa WHERE usuarioid = "+usuarioid+" AND fonteid = "+fonteid+" AND itemid = "+i.intValue()+" ORDER BY data DESC LIMIT 1";
				rs = st.executeQuery(select2);
				while(rs.next()){
					Pesquisa p = new Pesquisa();
					p.setAno(rs.getInt("ano"));
					p.setData(rs.getDate("data"));
					p.setEspecificacao(rs.getString("especificacao"));
					p.setMarca(rs.getString("marca"));
					p.setMes(rs.getInt("mes"));
					p.setMudouMarca(rs.getBoolean("mudoumarca"));
					p.setPesquisaid(rs.getInt("pesquisaid"));
					p.setSemana(rs.getInt("semana"));
					p.setValorLido(rs.getDouble("valorlido"));
					Usuario u = new Usuario();
					u.setUsuarioid(rs.getInt("usuarioid"));
					Fonte f = new Fonte();
					f.setFonteid(rs.getInt("fonteid"));
					Item it = new Item();
					it.setItemid(rs.getInt("itemid"));
					p.setUsuario(u);
					p.setFonte(f);
					p.setItem(it);
					lista.add(p);
				}
				rs.close();
			}
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

}
