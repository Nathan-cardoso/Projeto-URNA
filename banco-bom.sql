CREATE TABLE candidato(
	numero_eleicao varchar(5),
	nome varchar(60) not null,
	cpf varchar(14) not null,
	email varchar(70) not null,
	total_votos int,
	primary key (numero_eleicao)
);

CREATE TABLE eleitor (
	matricula varchar(10),
	nome varchar(60) not null,
	cpf varchar(14) not null,
	email varchar(70) not null,
	senha varchar(20),
	status_voto boolean default false,
	primary key (matricula)
);
