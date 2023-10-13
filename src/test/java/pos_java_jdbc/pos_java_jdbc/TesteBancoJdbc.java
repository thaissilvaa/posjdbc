package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc{
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}
	
	@Test
	public void inserirDados() {
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(5L);
		userposjava.setNome("Marcos Dao");
		userposjava.setEmail("marcos@gmail.com");
		
		userPosDAO.inserir(userposjava);
	}
	
	@Test
	public void listarDados() {
		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			for(Userposjava userposjava : list) {
				System.out.println(userposjava);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void buscarDados() {
		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava user = dao.buscar(5L);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void atualizarDados() {
		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava user = dao.buscar(5L);
			user.setNome("Marcos Atualiza");
			dao.atualizar(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
