
-- Création base de donnée / si existe déjà, supprimer !

DROP DATABASE IF EXISTS Projetbank;
CREATE database Projetbank;
use Projetbank;

-- Création table des clients

CREATE TABLE T_Customers (
       IdCust                          int(4)              PRIMARY KEY AUTO_INCREMENT,
       Name                            varchar(20)         NOT NULL

);

-- Ajouter des clients à votre table

INSERT INTO T_Customers (IdCust, Name) VALUES ( 1, 'Cathy' );
INSERT INTO T_Customers (IdCust, Name) VALUES ( 2, 'Alexis' );
INSERT INTO T_Customers (IdCust, Name) VALUES ( 3, 'Sebastien' );
INSERT INTO T_Customers (IdCust, Name) VALUES ( 4, 'Teddy' );
INSERT INTO T_Customers (IdCust, Name) VALUES ( 5, 'toto' );

-- Création table des comptes

CREATE TABLE T_Accounts (
        IdCust                         int(4)             PRIMARY KEY AUTO_INCREMENT,
        Balance                        float(10)          NOT NULL,
        CreationDate                   date               NOT NULL

);

-- Ajouter des comptes

INSERT INTO T_Accounts (IdCust, Balance, CreationDate) VALUES (1,3000,curdate() );
INSERT INTO T_Accounts (IdCust, Balance, CreationDate) VALUES (2,4000,curdate() );
INSERT INTO T_Accounts (IdCust, Balance, CreationDate) VALUES (3,5000,curdate() );
INSERT INTO T_Accounts (IdCust, Balance, CreationDate) VALUES (4,6000 ,curdate());
INSERT INTO T_Accounts (IdCust, Balance, CreationDate) VALUES (5,7000,curdate() );

--Creation Table de Comptes Epargne 

CREATE TABLE T_SavingsAccount (
          IdCust                   int(4)             NOT NULL REFERENCES T_Accounts(IdCust),
          Balance                  float(10)          NOT NULL,
          CreationDate             date               NOT NULL,
          InterestRate             float(10)          NOT NULL

);

-- Ajouter des Comptes Epargne

INSERT INTO T_SavingsAccount (IdCust,Balance,CreationDate,InterestRate) VALUES (1,1000,curdate(), 10 );

--Creation Table Comptes courrant 

CREATE TABLE T_CurrentAccount (
          IdCust                   int(4)             NOT NULL REFERENCES T_Accounts(IdCust),
          Balance                  float(10)          NOT NULL,
          CreationDate             date               NOT NULL, 
          Overdraft                float(10)          NOT NULL
);

--ajouter comptes courrant

INSERT INTO T_CurrentAccount (IdCust,Balance,CreationDate,Overdraft) VALUES (1,1000,curdate(), 100 ) ;

--Creation Table Opérations

CREATE TABLE T_Operation (
         NumOp                          int(4)         PRIMARY KEY AUTO_INCREMENT,
         DateOp                         date           NOT NULL,
         Amount                         float(50)      NOT NULL
);

--Ajouter une Opération

INSERT INTO T_Operation (NumOp, DateOp, Amount) VALUES (200, curdate(),1234);

--Creation Table Retrait 

CREATE TABLE T_Withdrawal (
         NumOp                          int(4)         PRIMARY KEY AUTO_INCREMENT,
         DateOp                         date           NOT NULL,
         Amount                         float(50)      NOT NULL

);

--Ajouter un retrait

INSERT INTO T_Withdrawal (NumOp, DateOp, Amount) VALUES (200, curdate(),1234);

--Creation Table Versement

CREATE TABLE T_Payment (
         NumOp                          int(4)         PRIMARY KEY AUTO_INCREMENT,
         DateOp                         date           NOT NULL,
         Amount                         float(50)      NOT NULL

);

--Ajouter un Versement

INSERT INTO T_Payment (NumOp, DateOp, Amount) VALUES (100, curdate(),1234);

CREATE TABLE T_User (
       Login                          varchar(20)              NOT NULL,
       Pwd                            varchar(20)              NOT NULL

);

-- Ajouter des clients à votre table

INSERT INTO T_User (Login, Pwd) VALUES ( 'alexis', 'etienne' );
INSERT INTO T_User (Login, Pwd) VALUES ('cathy', 'lassalle' );
INSERT INTO T_User (Login, Pwd) VALUES ('teddy', 'mbajoumbe' );
INSERT INTO T_User (Login, Pwd) VALUES ('sebastien', 'blaizot' );






         
