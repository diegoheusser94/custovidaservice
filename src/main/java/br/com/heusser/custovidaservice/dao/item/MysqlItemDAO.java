package br.com.heusser.custovidaservice.dao.item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.heusser.custovidaservice.dao.mysql.Conexao;
import br.com.heusser.custovidaservice.modelo.Classe;
import br.com.heusser.custovidaservice.modelo.Grupo;
import br.com.heusser.custovidaservice.modelo.Item;
import br.com.heusser.custovidaservice.modelo.Produto;
import br.com.heusser.custovidaservice.modelo.Subgrupo;

public class MysqlItemDAO implements ItemDAO {

	@Override
	public List<Item> listar() {
		Connection con = Conexao.get();
		String select = "SELECT i.itemid as item_id, " + "i.identificador as item_identificador, "
				+ "i.descricao as item_descricao, " + "p.produtoid as produto_id, "
				+ "p.identificador as produto_identificador, " + "p.descricao as produto_descricao, "
				+ "c.classeid as classe_id, " + "c.identificador as classe_identificador, "
				+ "c.descricao as classe_descricao, " + "s.subgrupoid as subgrupo_id, "
				+ "s.identificador as subgrupo_identificador, " + "s.descricao as subgrupo_descricao, "
				+ "g.grupoid as grupo_id, " + "g.identificador as grupo_identificador, "
				+ "g.descricao as grupo_descricao "
				+ "FROM item as i INNER JOIN produto as p ON i.produtoid = p.produtoid "
				+ "INNER JOIN classe as c ON p.classeid = c.classeid "
				+ "INNER JOIN subgrupo as s ON c.subgrupoid = s.subgrupoid "
				+ "INNER JOIN grupo as g ON s.grupoid = g.grupoid;";
		List<Item> itens = new ArrayList<>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);

			while (rs.next()) {
				Grupo g = new Grupo();
				g.setGrupoid(rs.getInt("grupo_id"));
				g.setIdentificador(rs.getString("grupo_identificador"));
				g.setDescricao(rs.getString("grupo_descricao"));
				Subgrupo s = new Subgrupo();
				s.setSubgrupoid(rs.getInt("subgrupo_id"));
				s.setIdentificador(rs.getString("subgrupo_identificador"));
				s.setDescricao(rs.getString("subgrupo_descricao"));
				s.setGrupo(g);
				Classe c = new Classe();
				c.setClasseid(rs.getInt("classe_id"));
				c.setIdentificador(rs.getString("classe_identificador"));
				c.setDescricao(rs.getString("classe_descricao"));
				c.setSubgrupo(s);
				Produto p = new Produto();
				p.setProdutoid(rs.getInt("produto_id"));
				p.setIdentificador(rs.getString("produto_identificador"));
				p.setDescricao(rs.getString("produto_descricao"));
				p.setClasse(c);
				Item i = new Item();
				i.setItemid(rs.getInt("item_id"));
				i.setIdentificador(rs.getString("item_identificador"));
				i.setDescricao(rs.getString("item_descricao"));
				i.setProduto(p);
				itens.add(i);
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
		return itens;
	}

}
