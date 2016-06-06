package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ConnectionFactoryTest.class, ContaDAOTest.class, ContaTest.class, ContaTOTest.class })
public class AllTestsConta {

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
	
}
