package fr.eni.trocenchere.bo;

public class Retrait {
	private int noArticle;
	private String rue;
	private String codePostaleRetrait;
	private String ville;
	
	public Retrait(int noArticle, String rue, String codePostaleRetrait, String ville) {
		this.noArticle = noArticle;
		this.rue = rue;
		this.codePostaleRetrait = codePostaleRetrait;
		this.ville = ville;
	}

	public Retrait(String rue, String codePostaleRetrait, String ville) {
		super();
		this.rue = rue;
		this.codePostaleRetrait = codePostaleRetrait;
		this.ville = ville;
	}
	

	public Retrait() {
		super();
	}

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostaleRetrait() {
		return codePostaleRetrait;
	}

	public void setCodePostaleRetrait(String codePostaleRetrait) {
		this.codePostaleRetrait = codePostaleRetrait;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
	
	

}
