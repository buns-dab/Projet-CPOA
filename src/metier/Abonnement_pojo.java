
package metier;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Abonnement_pojo {

	private int id_abonnement;
	private LocalDate date_debut;
	private LocalDate date_fin;
	private Client_pojo client;
	private Revue_pojo revue;
	DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");//

	public Abonnement_pojo( LocalDate date_debut, LocalDate date_fin, Client_pojo client, Revue_pojo revue) {

		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.client = client;
		this.revue = revue;
	}

	public Abonnement_pojo( int id_abonnement,LocalDate date_debut, LocalDate date_fin, Client_pojo client, Revue_pojo revue) {

		this.id_abonnement = id_abonnement;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.client = client;
		this.revue = revue;
	}

	public Abonnement_pojo() {

	}

	public int getId_abonnement() {
		return id_abonnement;
	}

	public void setId_abonnement(int id_abonnement) {
		this.id_abonnement = id_abonnement;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public Client_pojo getClient() {
		return client;
	}

	public void setClient(Client_pojo client) {
		this.client = client;
	}

	public Revue_pojo getRevue() {
		return revue;
	}

	public void setRevue(Revue_pojo revue) {
		this.revue = revue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abonnement_pojo other = (Abonnement_pojo) obj;
		return
				id_abonnement == other.id_abonnement ;
	}

	@Override
	public String toString() {
		return "Abonnement_pojo [id_abonnement=" + id_abonnement + ", date_debut=" + date_debut + ", date_fin="
				+ date_fin + ", id_client=" + client + ", id_revue=" + revue + "]";
	}

}