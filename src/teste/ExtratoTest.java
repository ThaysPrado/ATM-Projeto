package teste;

import static org.junit.Assert.*;
import negocio.Cliente;
import negocio.Conta;
import negocio.Extrato;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExtratoTest {

	Extrato extrato, copia;
	
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
	 * 
	 */
	

	@Before
	public void setUp() throws Exception {
		extrato = new Extrato(new Conta(1010101,1010,80.00, new Cliente(10, "Teste", 1)));
		extrato.setOperacao("saque");
		extrato.setValor(10.00);
		copia = new Extrato(new Conta(1010101,1010,80.00, new Cliente(10, "Teste", 1)));
		copia.setOperacao("saque");
		copia.setValor(10.00);
		copia.setMatriz(new Object[][]{{"2016-03-21","saque",10.00}});
	}
	
	@Test
	public void test00Carregar() {
		Extrato fixture = new Extrato(new Conta(0000000,0000,0.00, new Cliente(90,"test nome 90",00)));
		fixture.setMatriz(new Object[][]{{"2016-03-21","saque",0.00}});
		Extrato novo = new Extrato(new Conta(00000000,0000,0.00, new Cliente(90,"test nome 90",00)));
		novo.consultar(2);
		assertArrayEquals("testa inclusao", novo.getMatriz(), fixture.getMatriz());
	}

 	@Test
	public void test01Criar(){
 		extrato.incluir();
 		extrato.consultar(2);
		assertArrayEquals("teste", extrato.getMatriz(), copia.getMatriz());
	}
 	

}
