package br.com.heusser.custovidaservice.dao.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {
	
	public static Connection get() {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			input = classLoader.getResourceAsStream("database.properties");
			prop.load(input);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String user = prop.getProperty("user");
			String password = prop.getProperty("password");
			Class.forName(driver);
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		} catch (IOException exc) {
			exc.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException exce) {
					exce.printStackTrace();
				}
			}
		}
		return null;

	}
}
