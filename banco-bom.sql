CREATE TABLE candidato(
	numero_eleicao varchar(5),
	nome varchar(60) not null,
	cpf varchar(11) not null,
	email varchar() not null,
	total_votos int,
	primary key (numero_eleicao)
);

CREATE TABLE eleitor (
	matricula varchar(10),
	nome varchar(60) not null,
	cpf varchar(11) not null,
	email varchar() not null,
	senha varchar(20) not null,
	status_voto boolean not null,
	primary key (matricula)
);