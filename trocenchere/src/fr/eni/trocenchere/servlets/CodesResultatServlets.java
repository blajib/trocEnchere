package fr.eni.trocenchere.servlets;

public abstract class CodesResultatServlets {
	/**
	 * Les codes disponibles sont entre 10000 et 19999
	 */
	
	/**
	 * Echec : la combinaison est faux
	 */
	public static final int MAUVAISE_COMBINAISON_ERREUR = 10000;
	
	/**
	 * Echec lors de la modification du mot de passe : le nouveau mot de passe est identique à l'ancien
	 */
	
	public static final int NOUVEAU_MDP_IDENTIQUE_ANCIEN = 10002;
	
	/**
	 * Echec lors de la modification du mot de passe : le nouveau mot de passe et la confirmation du nouveau mot de passe ne sont pas identiques
	 */
	
	public static final int MDP_NON_IDENTIQUES = 10003;
	

}
