package teste;

import static org.junit.Assert.*;
import negocio.Cliente;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteTest {
	Cliente cliente, copia;
		
	/*
	 * antes do teste fazer:
	 * insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
	 * delete delete from cliente where id=23;
	 * */
	
	
	@Before
	public void setUp() throws Exception {
		cliente = new Cliente(23, "Teste Cliente",1);
		copia = new Cliente(23, "Teste Cliente",1);
	}
	
	@Test
	public void test00Carregar() {
		Cliente fixture = new Cliente(90, "test nome 90", 00);
		Cliente novo = new Cliente(90, null, 00);
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test02Atualizar() {
		cliente.setTipo(9);
		copia.setTipo(9);		
		cliente.atualizar();
		assertEquals("testa inclusao", cliente, copia);
	}

}
