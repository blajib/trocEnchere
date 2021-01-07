package fr.eni.trocenchere.messages;

import java.util.ResourceBundle;

public class LecteurMessage {
	private static ResourceBundle rb;
	
	static { // se lance en premier au premier appel de la classe, est là pour initialiser un attribut de classe
		try {
			rb = ResourceBundle.getBundle("fr.eni.trocenchere.messages.messages_erreur");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public LecteurMessage() {
	}
	
	public static String getMessageErreur (int code) {
		String message = "";
		
		try {
			if(rb != null) {
				message = rb.getString(String.valueOf(code));
			} else {
				message = "Problème à la lecture du fichier contenant les messages";
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "Une erreur inconnue est survenue";
		}
				
		return message;
	}

}
