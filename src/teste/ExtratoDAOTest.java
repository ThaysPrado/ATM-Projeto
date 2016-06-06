package teste;

import static org.junit.Assert.*;
import negocio.Cliente;
import negocio.Conta;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.ClienteDAO;
import dao.ContaDAO;
import dao.ExtratoDAO;
import to.ClienteTO;
import to.ContaTO;
import to.ExtratoTO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExtratoDAOTest {

	ExtratoTO to;
	ExtratoDAO dao;
	ContaTO cnt;
	ClienteTO cl;
	ContaDAO cntd;
	ClienteDAO cld;
	

	/*
	 * Antes dos testes fazer:
	 * 
	 * insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
	 * insert into conta values(0000000,0000,0.00,90);
	 * insert into ACAO values(90,curdate(),'saque', 0.00, 0000000);
	 * 
	 * insert into cliente (id, nome, tipo) values (10, 'Teste', 1);
	 * insert into conta values(1010101,1010,0.00,10);
	 * 
	 * delete from ACAO where conta = 1010101;
	 */
	
	
	
	@Before
	public void setUp() throws Exception {
		dao = new ExtratoDAO();
		to = new ExtratoTO();
		to.setData("2016-03-20");
		to.setOperacao("saque");
		to.setValor(0.00);
		to.setConta(new Conta(1010101,1010, 0.00, new Cliente(10, "Teste", 1)));
	}
	
	@Test
	public void test00Carregar() {
		
		ExtratoTO fixture = new ExtratoTO();
		fixture.setNumConta(0000000);
		fixture.setPrazo(2);
		fixture.setMatriz(new Object[][] {{"2016-03-20","saque", 0.00}});
		fixture.setConta(new Conta(0000000,0000, 0.00, new Cliente(90, "test nome 90", 00)));

		ExtratoTO novo = new ExtratoTO();
		novo.setNumConta(1111111);
		novo.setConta(new Conta(0000000,0000, 0.00, new Cliente(90, "test nome 90", 00)));
		novo.setPrazo(2);
		novo = dao.carregar(novo);
		//assertArrayEquals("teste de verificação do array", novo.getMatriz(), fixture.getMatriz());
	}

	@Test
	public void test01Inserir() {
		dao.incluir(to);
		ExtratoTO novo = dao.carregar(to);
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test02Atualizar() {
		to.setOperacao("deposito");
		dao.atualizar(to);
		ExtratoTO novo = dao.carregar(to);
		assertEquals("testa inclusao", novo, to);
	}
	
	@Test
	public void test03Excluir() {
		to.setOperacao(null);
		to.setData(null);
		to.setMatriz(new Object[][]{{}});
		dao.excluir(to);
		ExtratoTO novo = dao.carregar(to);
		assertEquals("testa inclusao", novo, to);
	}

}
