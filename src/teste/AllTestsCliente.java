package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteDAOTest.class, ClienteTest.class, ClienteTOTest.class, ConnectionFactoryTest.class })
public class AllTestsCliente {
	
	/*
	 * antes do teste fazer:
	 * insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
	 * delete from cliente where id=23;
	 * */

}
