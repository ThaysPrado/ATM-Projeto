package teste;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import to.ClienteTO;

public class ClienteTOTest {
	
	ClienteTO to;
	@Before
	public void setUp() throws Exception {
		to = new ClienteTO();
		to.setTipo(1);
		to.setNome("Teste cliente");
		to.setId(23);
	}

	@Test
	public void testGets() {
		assertEquals("getNome", to.getNome(), "Teste cliente");
		assertEquals("getFone", to.getTipo(), 1);
		assertEquals("getId", to.getId(), 23);
	}
	
	@Test
	public void testEquals(){
		ClienteTO copia = new ClienteTO();
		copia.setTipo(to.getTipo());
		copia.setNome(to.getNome());
		copia.setId(to.getId());
		assertEquals("teste to igual a copia", to, copia);
	}
}
