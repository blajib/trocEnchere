CREATE TABLE UTILISATEURS (
	util_ident INT PRIMARY KEY IDENTITY(1,1),
	util_pseudo VARCHAR(50) UNIQUE NOT NULL,
	util_motdepasse VARCHAR(50) NOT NULL,
	util_email varchar(50) UNIQUE NOT NULL,
	util_nom varchar(50) not null,
	util_prenom varchar(50) not null,
	util_telephone varchar(20) UNIQUE null,
	util_rue varchar(100) not null,
	util_codePostal varchar(20) not null,
	util_ville varchar(50) not null
);

INSERT INTO UTILISATEURS (util_pseudo,  util_motdepasse,util_email,util_nom,util_prenom,util_telephone,util_rue,util_codePostal,util_ville) 
VALUES ('jb', 'california', 'fish@gmail.com','blaschka','jean-Baptiste','0640597671','3 rue basse creuse','44000','Nantes');

select*
from UTILISATEURS
;

DROP TABLE IF EXISTS UTILISATEURS;