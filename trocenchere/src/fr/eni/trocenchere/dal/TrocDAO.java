package fr.eni.trocenchere.dal;

import java.util.List;

import fr.eni.trocenchere.TrocEnchereExceptions;
import fr.eni.trocenchere.bo.Utilisateur;

public interface TrocDAO {

	boolean selectMotDePasse(String pseudo_ou_email, String motdepasse, TrocEnchereExceptions tExceptions);
	boolean insert(Utilisateur utilisateur) throws TrocEnchereExceptions;
	Utilisateur selectUserByPseudo(String pseudo);
	boolean removeUser(String mail);
	void update (Utilisateur utilisateur) throws TrocEnchereExceptions;
	Utilisateur selectUserByID(int utilisateurID) throws TrocEnchereExceptions;
	List<Utilisateur> selectAllPseudo() throws TrocEnchereExceptions;

}
