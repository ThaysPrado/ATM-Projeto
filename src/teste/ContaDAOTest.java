package teste;

import static org.junit.Assert.*;
import negocio.Cliente;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.ContaDAO;
import to.ContaTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaDAOTest {
	ContaDAO dao;
	ContaTO to;
	Cliente clienteA;
	
	/*
	 * Antes dos teste fazer:
	 * 
	 * insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
	 * insert into conta values(0000000,0000,0.00,90);
	 * insert into cliente (id, nome, tipo) values (13, 'Teste', 1);
	 * 
	 * delete from conta where idCliente = 13;
	 * 
	 * */

	@Before
	public void setUp() throws Exception {
		
		dao = new ContaDAO();
		to = new ContaTO();
		to.setAgencia(1000);
		to.setSaldo(20.00);
		to.setConta(1234567);
		to.setCliente(new Cliente(13,"Teste",1));
		
	}
	
	@Test
	public void test00Carregar() {
		ContaTO fixture = new ContaTO();
		fixture.setAgencia(0000);
		fixture.setSaldo(0.00);
		fixture.setConta(0000000);
		fixture.setCliente(new Cliente(90, "test nome 90", 00));
		ContaTO novo = dao.carregar(0000000);
		novo.setConta(0000000);
		assertEquals("testa inclusao", novo, fixture);
	}
	
	@Test
	public void test01Inserir() {
		dao.incluir(to);
		ContaTO novo = dao.carregar(to.getConta());
		novo.setConta(to.getConta());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setSaldo(400.00);
		dao.atualizar(to);
		ContaTO novo = dao.carregar(to.getConta());
		novo.setConta(to.getConta());
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test 
	public void test03Excluir() {
		to.setSaldo(0);
		to.setAgencia(0);
		to.setCliente(clienteA);
		dao.excluir(to);
		ContaTO novo = dao.carregar(to.getConta());
		novo.setConta(to.getConta());
		assertEquals("testa inclusao", novo, to);
	}

}
