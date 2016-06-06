create database if not exists sistBanco;

use sistBanco;

create table if not exists cliente (
	id   integer     not null,
	nome varchar(50) not null,
	tipo integer     not null,
	primary key (id)
);

create table if not exists conta(
	conta     integer not null,
	agencia   integer not null,
	saldo     double  not null,
	idCliente integer not null,
	primary key (conta),   
	foreign key (idCliente) references cliente(id)
);

create table if not exists acao(
	id 	integer not null auto_increment,
    dataMov date not null,
    operacao varchar(30) not null,
    valorMov numeric(10,2) not null,
    conta integer not null,
    primary key (id),
    foreign key (conta) references conta(conta)
);

insert into cliente values
(1, 'Han Solo', 01),
(2, 'Peter Parker', 01),
(3, 'Lisa Simpson', 02),
(4, 'Walter White', 01);
 
insert into conta values
(2395784, 9999, 500.00, 1),
(2385998, 9999, 1200.00, 1),
(2587415, 9999, 50000.00, 3),
(2145987, 9999, 737000.00, 4),
(2398468, 9999, 20.00, 2); 


INSERT INTO ACAO VALUES
(1,curdate(),'saque', 2220.00,  2145987),
(2,curdate(),'saque', 239.00,  2145987),
(3,curdate(),'saque', 80.00,  2145987),
(4,curdate(),'saque', 55220.00,  2145987);

#############################################################
#linhas pré testes

insert into cliente (id, nome, tipo) values (90, 'test nome 90', 00);
insert into conta values(0000000,0000,0.00,90);
insert into ACAO values(90,curdate(),'saque', 0.00, 0000000);

insert into cliente (id, nome, tipo) values (13, 'Teste', 1);

insert into cliente (id, nome, tipo) values (10, 'Teste', 1);
insert into conta values(1010101,1010,0.00,10);

#########################################
#Pre e pos testes
delete from ACAO where conta = 1010101;
delete from conta where idCliente = 13;
delete from cliente where id=23;

#################################################################


select * from cliente;
select * from conta;
select * from acao;

show tables from sistBanco;

drop database sistBanco;