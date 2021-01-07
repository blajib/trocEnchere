package fr.eni.trocenchere.bll;

public abstract class CodeResultatBLL {
	
	// 20000 à 29999
	
	//erreur utilisateur
	public static final int CODE_POSTAL_LETTRE = 20000;
	public static final int PSEUDO_NULL = 20001;
	public static final int PRENOM_NULL = 20002;
	public static final int NOM_NULL = 20003;
	public static final int MAIL_NULL = 20004;
	public static final int TELEPHONE_NULL = 20005;
	public static final int RUE_NULL = 20006;
	public static final int CODE_POSTAL_NULL = 20010;
	public static final int VILLE_NULL = 20008;
	public static final int MOT_DE_PASSE_NULL = 20009;
	
	//erreur article
	public static final int PRIX_INITIAL_NON_CHIFFRE = 20020;
	public static final int ERREUR_DATE_DEBUT = 20021;
	public static final int ERREUR_DATE_FIN = 20022;
	public static final int ERREUR_CATEGORIE =20023;
	public static final int ERREUR_NO_UTILISATEUR = 20024;
	public static final int ERREUR_INSERTION= 20025;
	public static final int ERREUR_NOM_ARTICLE= 20026;
	public static final int ERREUR_DESCRIPTION= 20027;
	
	//erreur retrait
	public static final int ERREUR_RUE_RET= 20028;
	public static final int ERREUR_CPO_RET= 20029;
	public static final int ERREUR_VILLE_RET= 20030;
	
	//erreur au niveau enchere
	public static final int ERREUR_CHIFFRE_SAISI= 20031;

	


	


	


	

}
