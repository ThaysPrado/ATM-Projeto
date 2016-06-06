package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import to.ContaTO;

public class ContaTOTest {
	
	ContaTO to;
	
	@Before
	public void setUp() throws Exception {
		to = new ContaTO();
		to.setAgencia(0000);
		to.setSaldo(100.00);
		to.setConta(3333333);
	}

	@Test
	public void testGets() {
		assertEquals("getAgencia", to.getAgencia(), 0000);
		assertEquals(to.getSaldo(), 100.00, 0);
		assertEquals("getConta", to.getConta(), 3333333);
	}
	
	@Test
	public void testEquals(){
	    ContaTO copia = new ContaTO();
		copia.setAgencia(to.getAgencia());
		copia.setSaldo(to.getSaldo());
		copia.setConta(to.getConta());
		assertEquals("teste to igual a copia", to, copia);
	}

}
