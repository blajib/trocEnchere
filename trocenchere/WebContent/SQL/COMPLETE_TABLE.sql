DROP TABLE IF EXISTS RETRAITS;
DROP TABLE IF EXISTS ENCHERES;
DROP TABLE IF EXISTS ARTICLES;
DROP TABLE IF EXISTS CATEGORIES;
DROP TABLE IF EXISTS UTILISATEURS;


CREATE TABLE UTILISATEURS (
	util_ident INT PRIMARY KEY IDENTITY(1,1),
	util_pseudo VARCHAR(50) UNIQUE NOT NULL,
	util_motdepasse VARCHAR(50) NOT NULL,
	util_email varchar(50) UNIQUE NOT NULL,
	util_nom varchar(50) UNIQUE not null,
	util_prenom varchar(50) not null,
	util_telephone varchar(20) UNIQUE null,
	util_rue varchar(100) not null,
	util_codePostal varchar(20) not null,
	util_ville varchar(50) not null,
	util_credit int not null,
	util_administrateur bit not null
);

CREATE TABLE CATEGORIES(
	cat_noCat INT PRIMARY KEY IDENTITY(1,1),
	cat_libelle varchar(100) not null
);

INSERT INTO CATEGORIES VALUES ('Informatique'), ('Ameublement'), ('Vêtement'), ('Sport & Loisirs');

CREATE TABLE ARTICLES(
	art_noArticle INT PRIMARY KEY IDENTITY(1,1),
	art_nomArticle VARCHAR(50) NOT NULL,
	art_description VARCHAR(300) null,
	art_dateDebut datetime not null,
	art_dateFin datetime NOT NULl,
	art_miseAPrix int not null,
	art_prixVente int not null,
	art_etatVente varchar(3) CHECK (art_etatVente IN ('PV', 'EC', 'TER', 'ANN')), /* PréVente, EnCours, TERminée, ANNulée */
	art_image varchar(300)
,	art_ptrutilident int not null REFERENCES UTILISATEURS (util_ident),
	art_ptrcatnocat int not null REFERENCES CATEGORIES (cat_noCat)
);

CREATE TABLE ENCHERES(
	ench_noUtilisateur INT NOT NULL REFERENCES UTILISATEURS (util_ident),
	ench_noArticle INT NOT NULL REFERENCES ARTICLES (art_noArticle),
	ench_dateEnchere datetime not null,
	ench_montantEnchere int not null,
	PRIMARY KEY (ench_noUtilisateur, ench_noArticle)
);

CREATE TABLE RETRAITS(
	ret_noArticle INT PRIMARY KEY REFERENCES ARTICLES (art_noArticle),
	ret_rue varchar(50) not null,
	ret_cp varchar(10) not null,
	ret_ville varchar(50) NOT NULL
);

/* 4 = id de l'utilisateur CBZ, 1 = id de la catégorie infor */
INSERT INTO ARTICLES VALUES ('clavier', 'clavier bureautique', '22/06/2020', '23/06/2020', 100, 1000, 'TER', null, 4, 1);
/* 1 = id article */
INSERT INTO ENCHERES VALUES (4, 1, '22/06/2020', 100);
/* 1 = id article */
INSERT INTO RETRAITS VALUES (1, '1 allée des tanneurs', '44700', 'ORVAULT');

INSERT INTO ARTICLES VALUES ('souris', 'souris gamer', '24/06/2020', '29/06/2020', 100, 1000, 'EC', null, 4, 1);
/* 2 = id article */
INSERT INTO ENCHERES VALUES (4, 2, '29/06/2020', 100);
/* 2 = id article */
INSERT INTO RETRAITS VALUES (2, '1 allée des tanneurs', '44700', 'ORVAULT');


