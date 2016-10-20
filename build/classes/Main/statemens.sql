DROP TABLE IF EXISTS schedule;
CREATE TABLE schedule (
  idOperacao SERIAL,
  indiceTransacao INTEGER,
  operacao VARCHAR(10),
  itemDado VARCHAR(10),
  timestampj VARCHAR(15),
  CONSTRAINT pk_constraint PRIMARY KEY (idOperacao)
);

DROP TABLE IF EXISTS scheduleSerializado;
CREATE TABLE scheduleSerializado (
  idOperacao SERIAL,
  indiceTransacao INTEGER,
  operacao VARCHAR(10),
  itemDado VARCHAR(10),
  timestampj VARCHAR(15),
  CONSTRAINT pkey_constraint PRIMARY KEY (idOperacao)
);