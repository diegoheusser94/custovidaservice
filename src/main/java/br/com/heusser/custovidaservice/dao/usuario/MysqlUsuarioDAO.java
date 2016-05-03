package br.com.heusser.custovidaservice.dao.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.heusser.custovidaservice.dao.mysql.Conexao;
import br.com.heusser.custovidaservice.modelo.TipoUsuario;
import br.com.heusser.custovidaservice.modelo.Usuario;

public class MysqlUsuarioDAO implements UsuarioDAO {

	@Override
	public List<Usuario> listarPesquisadoresAtivos() {
		Connection con = Conexao.get();
		String select = "SELECT * FROM usuario as u INNER JOIN tipousuario as t on u.tipousuarioid = t.tipousuarioid WHERE t.descricao = 'Pesquisador' AND u.ativo = 1";
		List<Usuario> lista = new ArrayList<>();

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);

			while (rs.next()) {
				Usuario u = new Usuario();
				u.setAtivo(rs.getBoolean("ativo"));
				u.setNick(rs.getString("nick"));
				u.setNomeCompleto(rs.getString("nomeCompleto"));
				u.setUsuarioid(rs.getInt("usuarioid"));
				u.setSenha(rs.getString("senha"));
				TipoUsuario	t = new TipoUsuario();
				t.setDescricao(rs.getString("descricao"));
				t.setTipoUsuarioid(rs.getInt("tipoUsuarioid"));
				u.setTipoUsuario(t);
				lista.add(u);
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
	public void alterar(Usuario u) throws Exception {
		Connection con = Conexao.get();
		String update = "UPDATE usuario SET nomecompleto = ?, nick = ?, senha = ?, ativo = ? WHERE usuarioid = ?";
		PreparedStatement pst = con.prepareStatement(update);
		pst.setString(1, u.getNomeCompleto());
		pst.setString(2, u.getNick());
		pst.setString(3, u.getSenha());
		pst.setBoolean(4, u.isAtivo());
		pst.setInt(5, u.getUsuarioid());
		pst.executeUpdate();
		pst.close();
		con.close();
	}

}
