package test.dao;

import java.util.Scanner;

import dao.enumeration.Persistance;
import dao.factory.DAOFactory;
import metier.Revue_pojo;

public class testRevueMain {
	public static DAOFactory daos =null;

	public static void main(String[] args) throws Exception {
		String resRev,titre,description,visuel;
		Integer id,tarif_numero,id_rev;
		
		Revue_pojo p3=new Revue_pojo();
		Scanner sc=new Scanner(System.in);
		
		ChoixPersistance();
		
		System.out.println("Voulez vous cr�er une revue ? Appuyer sur YES(oui) ou NO(non)");
		resRev = sc.nextLine();
		if (resRev.equals("YES")) {
			System.out.println("le titre: "); 
			titre=sc.nextLine();
			System.out.println("la description: ");	
			description=sc.nextLine();
			System.out.println("le tarif_numero: ");
			tarif_numero=sc.nextInt();
			System.out.println("le visuel: ");
			visuel=sc.nextLine();
			System.out.println("l'id_periodicite ");
			id=sc.nextInt();
			
			daos.getRevueDao().create(p3);				
			//p3.requeteAjouterRevue(titre, description, tarif_numero, visuel, id);	
			
		}
		
		System.out.println("Voulez vous modifier une revue ? Appuyer sur YES(oui) ou NO(non)");
		resRev = sc.nextLine();
		if (resRev.equals("YES")) {
			System.out.println("l'id_revue");
			id_rev=sc.nextInt();
			System.out.println("le titre: "); 
			titre=sc.nextLine();
			System.out.println("la description: ");	
			description=sc.nextLine();
			System.out.println("le tarif_numero: ");
			tarif_numero=sc.nextInt();
			System.out.println("le visuel: ");
			visuel=sc.nextLine();
			System.out.println("l'id_periodicite ");
			id=sc.nextInt();
			
			daos.getRevueDao().update(p3);				
			//p3.requeteModifierRevue(id_rev,titre, description, tarif_numero, visuel, id);	
		}	
		
		System.out.println("Voulez vous supprimer une revue ? Appuyer sur YES(oui) ou NO(non)");
		resRev = sc.nextLine();
		if (resRev.equals("YES")) {
			System.out.println("l'id_revue");
			id_rev=sc.nextInt();
			
			daos.getRevueDao().delete(p3);				
			//p3.requeteRetirerRevue(id_rev);	
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
