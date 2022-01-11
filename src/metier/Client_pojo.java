package metier;

public class Client_pojo {
	private int id_client;
	private String nom;
	private String prenom;
	private String no_rue;
	private String voie;
	private String code_postal;
	private String ville;
	private String pays;

	public Client_pojo(int id_client, String nom, String prenom, String no_rue, String voie, String code_postal, String ville, String pays) {
		this.id_client = id_client;
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	public Client_pojo(String nom, String prenom, String no_rue, String voie, String code_postal, String ville, String pays) {
		this.nom = nom;
		this.prenom = prenom;
		this.no_rue = no_rue;
		this.voie = voie;
		this.code_postal = code_postal;
		this.ville = ville;
		this.pays = pays;
	}

	public Client_pojo() {
	
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if(nom==null || nom.trim().length()==0) {
			throw new IllegalArgumentException("Nom vide !");
		}
		this.nom = nom.trim();
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		if(prenom==null || prenom.trim().length()==0) {
			throw new IllegalArgumentException("Prenom vide !");
		}
		this.prenom = prenom.trim();
	}

	public String getNo_rue() {
		return no_rue;
	}

	public void setNo_rue(String no_rue) {
		if(no_rue==null || no_rue.trim().length()==0) {
			throw new IllegalArgumentException("numéro de rue vide !");
		}
		this.no_rue = no_rue;
	}

	public String getVoie() {
		return voie;
	}

	public void setVoie(String voie) {
		if(voie==null || voie.trim().length()==0) {
			throw new IllegalArgumentException("Voie vide !");
		}
		this.voie = voie.trim();
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		if(code_postal==null || code_postal.trim().length()==0) {
			throw new IllegalArgumentException("code_postal vide !");
		}
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		if(ville==null || ville.trim().length()==0) {
			throw new IllegalArgumentException("Ville vide !");
		}
		this.ville = ville.trim();
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		if(pays==null || pays.trim().length()==0) {
			throw new IllegalArgumentException("Pays vide !");
		}
		this.pays = pays.trim();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client_pojo other = (Client_pojo) obj;
		return  id_client == other.id_client ;
	}

	@Override
	public String toString() {
		return id_client + " | " + nom + " " + prenom;
	}
}
