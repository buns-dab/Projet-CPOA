package test.dao;

import java.util.Scanner;

import dao.enumeration.Persistance;
import dao.factory.DAOFactory;
import metier.Periodicite_pojo;

public class testPeriodiciteMain {
	
	public static DAOFactory daos =null;
	public static void main(String[] args) throws Exception {
		
		String resPer;
		Integer id;
		Periodicite_pojo p1 = new Periodicite_pojo();
		
		ChoixPersistance();
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Voulez vous cr�er une nouvelle periodicite ? Appuyer sur YES(oui) ou NO(non)");
		resPer = sc.nextLine();
		
		if (resPer.equals("YES")) {
			System.out.println("Veuillez saisir le libelle de la periodicite: ");
			resPer = sc.nextLine();
			daos.getPeriodiciteDao().create(p1);
			//p1.requeteAjouterPeriodicite(resPer);
		}
			System.out.println("Voulez vous modifier une p�riodicit� ? Appuyer sur YES(oui) ou NO(non)");
			resPer = sc.nextLine();
			if (resPer.equals("YES")) {
				System.out.println("Veuillez saisir l'id de la periodicite � modifier ainsi que le nouveau libelle: ");
				
				id=sc.nextInt();
				resPer=sc.nextLine();
				daos.getPeriodiciteDao().update(p1);
				//p1.requeteModifierPeriodicite(id, resPer);	
			}
			
			System.out.println("Voulez vous supprimer une p�riodicit� ? Appuyer sur YES(oui) ou NO(non)");
			resPer = sc.nextLine();
			if (resPer.equals("YES")) {
			
				System.out.println("Veuillez saisir l'id de la periodicite � supprimer: ");
				id=sc.nextInt();
				//p1.requeteSupprimerPeriodicite(id);
				daos.getPeriodiciteDao().delete(p1);
				System.out.println("Suppression effectu�e");
				sc.close();	
			}
			
			else if (resPer.equals("NO")) {
				System.out.println("Mais que faite vous l� alors ?");
			}
			
	}
	
	public static void ChoixPersistance() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choisir un lieu de sauvegarde: 1 pour mysql 2 pour liste_memoire");
		String choix = sc.nextLine();
		
		try {
			int choixOk = Integer.parseInt(choix);
			switch(choixOk) {
			
				case 1: daos=DAOFactory.getDAOFactory(Persistance.MYSQL);
				break;
				
				case 2 : daos=DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
				break;
			}
			
			
		}catch (NumberFormatException e){
			System.out.println("Veuillez saisir un choix valide");
			ChoixPersistance();
		}
		
		
		
	}

}
