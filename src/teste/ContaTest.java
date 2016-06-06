package teste;

import static org.junit.Assert.*;
import negocio.Cliente;
import negocio.Conta;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest {
	
	Conta conta, copia;
	
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
	public void setUp()throws Exception{
		conta = new Conta(1234567,8888,80.00, new Cliente(13, "Teste", 1));
		copia = new Conta(1234567,8888,80.00, new Cliente(13, "Teste", 1));
	}
	
	@Test
	public void test00Carregar(){
		
	    Conta fixture = new Conta(0000000, 0000, 0.00, new Cliente(90, "test nome 90", 00));
		Conta novo = new Conta(0000000, 0000, 0.00, new Cliente(90, null, 00));
		novo.carregar();
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test02Atualizar() {
		conta.setAgencia(2222);
		copia.setAgencia(2222);		
		conta.atualizar();
		assertEquals("testa inclusao", conta, copia);
	}


}
