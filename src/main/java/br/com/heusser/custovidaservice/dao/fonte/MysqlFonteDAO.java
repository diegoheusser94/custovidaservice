package br.com.heusser.custovidaservice.dao.fonte;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.heusser.custovidaservice.dao.mysql.Conexao;
import br.com.heusser.custovidaservice.modelo.Fonte;

public class MysqlFonteDAO implements FonteDAO {

	@Override
	public List<Fonte> listar(int usuarioid) {
		Connection con = Conexao.get();
		String select = "SELECT f.* FROM fonte as f INNER JOIN fonteusuario as fu ON f.fonteid = fu.fonteid INNER JOIN usuario as u ON fu.usuarioid = u.usuarioid WHERE u.usuarioid = "+usuarioid;
		List<Fonte> lista = new ArrayList<>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);

			while (rs.next()) {
				Fonte f = new Fonte();
				f.setFonteid(rs.getInt("fonteid"));
				f.setDescricao(rs.getString("descricao"));
				f.setLocalizacao(rs.getString("localizacao"));
				lista.add(f);
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

}
