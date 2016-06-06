package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import to.ClienteTO;
import dao.ClienteDAO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteDAOTest {
	
	ClienteDAO dao;
	ClienteTO to;
	
	/*
	 * antes do teste fazer:
	 * insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
	 * delete from cliente where id=23;
	 * */
	
	@Before
	public void setUp() throws Exception {
		dao = new ClienteDAO();
		to = new ClienteTO();
		to.setTipo(1);
		to.setNome("Teste Cliente");
		to.setId(23);
	}
	
	@Test
	public void test00Carregar() {
		ClienteTO fixture = new ClienteTO();
		fixture.setTipo(00);
		fixture.setNome("test nome 90");
		fixture.setId(90);
		ClienteTO novo = dao.carregar(90);
		novo.setId(90);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setTipo(02);
		dao.atualizar(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setNome(null);
		to.setTipo(00);
		dao.excluir(to);
		ClienteTO novo = dao.carregar(to.getId());
		novo.setId(to.getId());
		assertEquals("testa inclusao", novo, to);
	}

}
