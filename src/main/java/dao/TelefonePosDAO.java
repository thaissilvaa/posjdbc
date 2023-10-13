package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Telefoneuser;

public class TelefonePosDAO {

	private Connection connection;

	public TelefonePosDAO() {
		connection = SingleConnection.getConnection();
	}

	public void inserir(Telefoneuser telefoneuser) {
		try {
			String sql = "insert into telefoneuser (numero, tipo, usuariopessoa) values (?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefoneuser.getNumero());
			insert.setString(2, telefoneuser.getTipo());
			insert.setLong(3, telefoneuser.getUsuariopessoa());
			insert.execute();
			connection.commit();
			System.out.println("Salvo com sucesso");
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

	public List<Telefoneuser> listar() throws Exception {
		List<Telefoneuser> list = new ArrayList<Telefoneuser>();

		String sql = "select * from telefoneuser";
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery(sql);

		while (resultado.next()) {
			Telefoneuser user = new Telefoneuser();
			user.setId(resultado.getLong("id"));
			user.setNumero(resultado.getString("numero"));
			user.setTipo(resultado.getString("tipo"));
			user.setUsuariopessoa(resultado.getLong("usuariopessoa"));
			list.add(user);
		}

		return list;
	}

	public Telefoneuser buscar(Long id) throws Exception {
		Telefoneuser user = new Telefoneuser();

		String sql = "select * from telefoneuser where id = " + id;
		PreparedStatement select = connection.prepareStatement(sql);
		ResultSet resultado = select.executeQuery(sql);

		while (resultado.next()) {
			user.setId(resultado.getLong("id"));
			user.setNumero(resultado.getString("numero"));
			user.setTipo(resultado.getString("tipo"));
			user.setUsuariopessoa(resultado.getLong("usuariopessoa"));
		}

		return user;
	}

	public void atualizar(Telefoneuser telefoneuser) throws SQLException {
		try {
			String sql = "update telefoneuser set tipo = '" + telefoneuser.getTipo() + "', numero = '"
					+ telefoneuser.getNumero() + "', usuariopessoa = " + telefoneuser.getUsuariopessoa() + " where id = " + telefoneuser.getId();
			PreparedStatement update = connection.prepareStatement(sql);
			update.execute();
			connection.commit();
			System.out.println("Salvo com sucesso");
		} catch (Exception ex) {
			try {
				connection.rollback();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ex.printStackTrace();
		}
	}

	public void deletar(Long id) {
		try {
			String sql = "delete from telefoneuser where id = " + id;
			PreparedStatement delete = connection.prepareStatement(sql);
			delete.execute();
			connection.commit();
			System.out.println("Excluído com sucesso");
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
