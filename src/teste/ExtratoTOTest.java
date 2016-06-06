package teste;

import static org.junit.Assert.*;
import negocio.Cliente;
import negocio.Conta;

import org.junit.Before;
import org.junit.Test;

import to.ExtratoTO;

public class ExtratoTOTest {

	ExtratoTO to;
	
	@Before
	public void setUp() throws Exception {
		to = new ExtratoTO();
		to.setOperacao("saque");
		to.setData("2016-03-20");
		to.setValor(0.00);
		to.setConta(new Conta(1234567,0000, 0.00, new Cliente(6, "Teste", 01)));
		to.setNumConta(1234567);
		to.setPrazo(2);
		to.setMatriz(new Object[][] {{"2016-03-19","saque", 0.00}});
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getOperacao(), "saque");
		assertEquals("getFone", to.getData(), "2016-03-20");
		assertEquals( to.getValor(), 0.00, 0);
		assertEquals("getConta", to.getConta(), new Conta(1234567,0000, 0.00, new Cliente(6, "Teste", 01)));
		assertEquals("getNome", to.getNumConta(), 1234567);
		assertEquals("getNome", to.getPrazo(), 2);
		assertArrayEquals("getNome", to.getMatriz(), new Object[][] {{"2016-03-19","saque", 0.00}});
	}
	
	@Test
	public void testEquals(){
		ExtratoTO copia = new ExtratoTO();
		copia.setOperacao(to.getOperacao());
		copia.setData(to.getData());
		copia.setValor(to.getValor());
		copia.setConta(to.getConta());
		copia.setNumConta(to.getNumConta());
		copia.setPrazo(to.getPrazo());
		copia.setMatriz(to.getMatriz());
		assertEquals("teste to igual a copia", to, copia);
	}

}
