package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.TelefonePosDAO;
import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefoneuser;
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
		
		userposjava.setNome("Ro Woon");
		userposjava.setEmail("kim_rw@gmail.com");
		
		userPosDAO.inserir(userposjava);
	}
	
	@Test
	public void inserirDadosTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		Telefoneuser telefoneuser = new Telefoneuser();
		
		telefoneuser.setTipo("Celular");
		telefoneuser.setNumero("2056341651");
		telefoneuser.setUsuariopessoa(1L);
		
		dao.inserir(telefoneuser);
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
	public void listarDadosTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		try {
			List<Telefoneuser> list = dao.listar();
			for(Telefoneuser userposjava : list) {
				System.out.println(userposjava);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void listarTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		try {
			List<BeanUserFone> list = dao.listarT();
			for(BeanUserFone userposjava : list) {
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
	public void buscarDadosTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		try {
			Telefoneuser user = dao.buscar(5L);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void buscarTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		try {
			List<BeanUserFone> list = dao.buscarT(1L);
			for(BeanUserFone userposjava : list) {
				System.out.println(userposjava);
			}
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
	
	@Test
	public void atualizarDadosTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		try {
			Telefoneuser user = dao.buscar(3L);
			user.setNumero("44568456");
			dao.atualizar(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletarDados() {
		UserPosDAO dao = new UserPosDAO();
		try {
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void deletarDadosTelefone() {
		TelefonePosDAO dao = new TelefonePosDAO();
		try {
			dao.deletar(1L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
