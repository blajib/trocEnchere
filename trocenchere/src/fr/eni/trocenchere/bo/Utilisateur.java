package fr.eni.trocenchere.bo;

public class Utilisateur {
	private int ident;
	private String pseudo;
	private String mail;
	private String motdepasse;
	private String nom;
	private String prenom;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private int credit = 0;
	private byte administrateur;

	
	public Utilisateur(int ident, String pseudo, String motdepasse) {
		this.ident = ident;
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
	}
	
	public Utilisateur(String pseudo, String motdepasse) {
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
	}
	
	// généré pour connaître la liste des pseudos pour afficher le pseudo du vendeur
	public Utilisateur(int ident, String pseudo) {
		this.ident = ident;
		this.pseudo = pseudo;
	}

	public Utilisateur(String pseudo, String mail, String motdepasse, String nom, String prenom, String telephone,
			String rue, String codePostal, String ville) {
		this.pseudo = pseudo;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.credit = 0;
		this.administrateur = 1;
	}
	public Utilisateur(int noUtilisateur,String pseudo, String mail, String motdepasse, String nom, String prenom, String telephone,
			String rue, String codePostal, String ville,int credit) {
		this.ident = noUtilisateur;
		this.pseudo = pseudo;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.credit = credit;
		this.administrateur = 1;
	}
	

	public Utilisateur(String mail) {
		this.mail = mail;
	}

	public Utilisateur(int ident, String pseudo, String motdepasse, String mail, String nom, String prenom,
			String telephone, String rue, String codePostal, String ville) {
		super();
		this.ident = ident;
		this.pseudo = pseudo;
		this.motdepasse = motdepasse;
		this.mail = mail;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	

	

	public Utilisateur(String pseudo, String mail, String motdepasse, String nom, String prenom, String rue,
			String codePostal, String ville) {
		super();
		this.pseudo = pseudo;
		this.mail = mail;
		this.motdepasse = motdepasse;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	

	public int getIdent() {
		return ident;
	}

	public void setIdent(int ident) {
		this.ident = ident;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	

	public byte getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(byte administrateur) {
		this.administrateur = administrateur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [ident=");
		builder.append(ident);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", mail=");
		builder.append(mail);
		builder.append(", motdepasse=");
		builder.append(motdepasse);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", test=");
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

	

}
