package metier;

public class Periodicite_pojo {

	private int id;
	private String libelle;

	public Periodicite_pojo(String libelle) {
		this.libelle = libelle;
	}

	public Periodicite_pojo(int id, String libelle) {
	
		this.id = id;
		this.libelle = libelle;
	}

	public Periodicite_pojo() {
	}

	public int getId() {
		return id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		if(libelle==null ||libelle.trim().length()==0) {
			throw new IllegalArgumentException("Libelle vide");
			}
		this.libelle = libelle;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Periodicite_pojo other = (Periodicite_pojo) obj;
		if (id != other.getId()) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return libelle;
	}

}
