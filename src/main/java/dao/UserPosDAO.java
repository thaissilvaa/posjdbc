package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	private Connection connection;

	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}

	public void inserir(Userposjava userposjava) {
		try {
			String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit();
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery(sql);

		while (resultado.next()) {
			Userposjava user = new Userposjava();
			user.setId(resultado.getLong("id"));
			user.setNome(resultado.getString("nome"));
			user.setEmail(resultado.getString("email"));
			list.add(user);
		}

		return list;
	}

	public Userposjava buscar(Long id) throws Exception {
		Userposjava user = new Userposjava();

		String sql = "select * from userposjava where id = " + id;
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery(sql);

		while (resultado.next()) {
			user.setId(resultado.getLong("id"));
			user.setNome(resultado.getString("nome"));
			user.setEmail(resultado.getString("email"));
		}

		return user;
	}

	public void atualizar(Userposjava userposjava) throws SQLException {
		try {
			String sql = "update userposjava set nome = '" + userposjava.getNome() + "', email = '"
					+ userposjava.getEmail() + "' where id = " + userposjava.getId();
			PreparedStatement update = connection.prepareStatement(sql);
			update.execute();
			connection.commit();
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

}
