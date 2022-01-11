package metier;

public class Revue_pojo {

	private int id_revue;
	private String titre;
	private String description;
	private float tarif_numero;
	private String visuel;
	private Periodicite_pojo periodicite;

	public Revue_pojo(String titre, String description, float tarif_numero, String visuel, Periodicite_pojo periodicite) {
		this.titre = titre;
		this.description = description;
		this.tarif_numero = tarif_numero;
		this.visuel = visuel;
		this.periodicite = periodicite;
	}

	public Revue_pojo(int id_revue, String titre, String description, float tarif_numero, String visuel, Periodicite_pojo periodicite) {
		this.id_revue = id_revue;
		this.titre = titre;
		this.description = description;
		this.tarif_numero = tarif_numero;
		this.visuel = visuel;
		this.periodicite = periodicite;
	}


	public Revue_pojo() {

	}

	public int getId_revue() {
		return id_revue;
	}

	public void setId_revue(int id_revue) {
		this.id_revue = id_revue;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getTarif_numero() {
		return tarif_numero;
	}

	public void setTarif_numero(float tarif_numero) {
		this.tarif_numero = tarif_numero;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public Periodicite_pojo getPeriodicite() {
		return periodicite;
	}

	public void setPeriodicite(Periodicite_pojo periodicite) {
		this.periodicite = periodicite;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revue_pojo other = (Revue_pojo) obj;
		return
				id_revue == other.id_revue ;
	}

	@Override
	public String toString() {
		return titre;
	}
}