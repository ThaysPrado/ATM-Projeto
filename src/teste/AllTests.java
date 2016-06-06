package teste;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ClienteDAOTest.class, ClienteTest.class, ClienteTOTest.class, ConnectionFactoryTest.class,
		ContaDAOTest.class, ContaTest.class, ContaTOTest.class, ExtratoDAOTest.class, ExtratoTest.class,
		ExtratoTOTest.class })
public class AllTests {
	
	//antes dos teste fazer:
	/*
	 * insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
	 * insert into conta values(0000000,0000,0.00,90);
	 * insert into ACAO values(90,curdate(),'saque', 0.00, 0000000);
	 * insert into cliente (id, nome, tipo) values (13, 'Teste', 1);
	 * insert into cliente (id, nome, tipo) values (10, 'Teste', 1);
	 * insert into conta values(1010101,1010,0.00,10);
	 * delete from ACAO where conta = 1010101;
	 * delete from conta where idCliente = 13;
	 * delete from cliente where id=23;
	 * */

}
