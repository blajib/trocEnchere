package fr.eni.trocenchere.dal;

public abstract class CodeResultatDAL {
	
	// codes entre 30000 et 39999
	
	/**
	 * Update en échec
	 */
	public static final int MISE_A_JOUR_ECHEC = 30000;
	public static final int INSERTION_ECHEC = 30001;

	
	
	/**
	 * Connexion impossible
	 */
	public static final int CONNEXION_BDD_ECHEC = 30001;
	
	public static final int ERREUR_INSERTION_ARTICLE = 30002;
	
	/**
	 * impossible de sélectionner l'utilisateur
	 */
	
	public static final int ERREUR_LECTURE_UTILISATEUR = 30003;
	public static final int ERREUR_FAIRE_ENCHERE = 30004;

}
