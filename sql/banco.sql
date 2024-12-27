DROP TABLE IF EXISTS Itens; 
DROP TABLE IF EXISTS Bolsas; 
DROP TABLE IF EXISTS Possuir; 
DROP TABLE IF EXISTS SeresMagicosMonstros; 
DROP TABLE IF EXISTS SeresMagicosRacasInteligente; 
DROP TABLE IF EXISTS SeresMagicos; 
DROP TABLE IF EXISTS Personagens; 

CREATE TABLE Itens ( 
    Nome VARCHAR(50) NOT NULL PRIMARY KEY, 
    Peso INT NOT NULL, 
    Valor INT  NOT NULL, 
    Quantidade INT  NOT NULL, 
    Consumivel BOOLEAN NOT NULL 
); 

CREATE TABLE SeresMagicos ( 
    Nome VARCHAR(50) NOT NULL PRIMARY KEY, 
    HabilidadeMagica VARCHAR(50) NOT NULL 
); 

CREATE TABLE SeresMagicosMonstros ( 
    Hostil BOOLEAN NOT NULL, 
    DanoAdicional INT NOT NULL, 
    SerMágicoId VARCHAR(50) NOT NULL, 
    FOREIGN KEY (SerMágicoId) REFERENCES SeresMagicos(Nome)
);
 
CREATE TABLE SeresMagicosRacasInteligente ( 
    Tendência VARCHAR(50), 
    Habitat VARCHAR(50), 
    SerMágicoId VARCHAR(50) NOT NULL, 
    FOREIGN KEY (SerMágicoId) REFERENCES SeresMagicos(Nome) 
); 

CREATE TABLE Bolsas ( 	
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    Peso_Max INT NOT NULL, 
    Qualidade VARCHAR(50) NOT NULL 
); 

CREATE TABLE Possuir ( 
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    BolsaId INT (100) NOT NULL, 
    ItemId VARCHAR(50) NOT NULL, 
    FOREIGN KEY (BolsaId) REFERENCES Bolsas(Sequencial), 
    FOREIGN KEY (ItemId) REFERENCES Itens(Nome) 
); 

CREATE TABLE Personagens ( 
    Sequencial INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    Nome VARCHAR(50) NOT NULL,
    Nivel INT NOT NULL,
    Pontos_vida INT NOT NULL,
    Pontos_força INT NOT NULL,
    Classe INT NOT NULL,
    BolsaId INT (100) NOT NULL, 
    SerMágicoId VARCHAR(50) NOT NULL, 
    FOREIGN KEY (BolsaId) REFERENCES Bolsas(Sequencial), 
    FOREIGN KEY (SerMágicoId) REFERENCES SeresMagicos(Nome) 
); 
