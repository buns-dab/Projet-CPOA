package test.dao;

import java.util.Date;
import java.util.Scanner;

import dao.enumeration.Persistance;
import dao.factory.DAOFactory;
import tools.ConversionDate;



public class testAbonnementMain {
	public static DAOFactory daos =null;
	public static void main(String[] args) {
		String resAbo;
		Integer id,id_rev,id_abo;

		ChoixPersistance();
		
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Voulez vous creeer un abonnement ? Appuyer sur YES(oui) ou NO(non)");
		resAbo = sc.nextLine();
		if (resAbo.equals("YES")) {
			Scanner scDateDeb = new Scanner(System.in);
	        System.out.println("Saisir une date de d�but : ");
	        String datedebut = scDateDeb.nextLine();
	        ConversionDate date1= new ConversionDate();
	        Date datedeb=date1.CreerDate(datedebut);

	        Scanner scDateFin = new Scanner(System.in);
	        System.out.println("Saisir une date de fin : ");
	        String datefin = scDateFin.nextLine();
	        ConversionDate date2= new ConversionDate();
	        Date datefinale=date2.CreerDate(datefin);
	       
	       System.out.println("Saisir un id_client : ");
	       id= sc.nextInt();
	       System.out.println("Saisir un id_revue : ");
		}
		
		System.out.println("Voulez vous modifier un abonnement ? Appuyer sur YES(oui) ou NO(non)");
		resAbo = sc.nextLine();
		if (resAbo.equals("YES")) {
			System.out.println("Saisir l'id_abo : ");
			id_abo=sc.nextInt();
			Scanner scDateDeb = new Scanner(System.in);
	        System.out.println("Saisir une date de d�but : ");
	        String datedebut = scDateDeb.nextLine();
	        ConversionDate date1= new ConversionDate();
	        Date datedeb=date1.CreerDate(datedebut);

	        Scanner scDateFin = new Scanner(System.in);
	        System.out.println("Saisir une date de fin : ");
	        String datefin = scDateFin.nextLine();
	        ConversionDate date2= new ConversionDate();
	        Date datefinale=date2.CreerDate(datefin);
	       
	       System.out.println("Saisir un id_client : ");
	       id= sc.nextInt();
	       System.out.println("Saisir un id_revue : ");
	       id_rev=sc.nextInt();	

		}
		
		System.out.println("Voulez vous supprimer un abonnement ? Appuyer sur YES(oui) ou NO(non)");
		resAbo = sc.nextLine();
		if (resAbo.equals("YES")) {
			System.out.println("Saisir l'id_abo : ");
			id_abo=sc.nextInt();
			
		}
		
		else if (resAbo.equals("NO")) {
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
