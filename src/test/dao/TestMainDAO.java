package test.dao;


import java.util.Scanner;

public class TestMainDAO {

	
	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Bonjour, que souhaitez vous faire ?");
		System.out.println("1: Aller dans Client");
		System.out.println("2: Aller dans Abonnement");
		System.out.println("3: Aller dans Periodicite");
		System.out.println("4: Aller dans Revue");
		System.out.println("5: Quitter");
		
		String choix = sc.nextLine();
		
		try {
			int choixOk = Integer.parseInt(choix);
			switch(choixOk) {
			
				case 1: testClientMain.main(args);
				break;
				
				case 2 : testAbonnementMain.main(args);
				break;
				
				case 3: testPeriodiciteMain.main(args);
				break;
				
				case 4:testRevueMain.main(args);
				break;
				
				case 5: System.exit(0);
				break;
			}
			
			
		}catch (NumberFormatException e){
			System.out.println("Veuillez saisir un choix valide");
			main(args);
		}
			
			//daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);
	        /*Scanner scDateDeb = new Scanner(System.in);
	        System.out.println("Saisir une date de d�but : ");
	        String datedebut = scDateDeb.nextLine();
	        ConversionDate date1= new ConversionDate();
	        Date datedeb=date1.CreerDate(datedebut);
	        System.out.println("r�ponse : " + datedebut);

	        Scanner scDateFin = new Scanner(System.in);
	        System.out.println("Saisir une date de fin : ");
	        String datefin = scDateFin.nextLine();
	        ConversionDate date2= new ConversionDate();
	        Date datefinale=date2.CreerDate(datefin);
	        System.out.println("r�ponse : " + datefin);*/
			
		
	
		

	/*	
		Abonnement_pojo a1 = new Abonnement_pojo("02/02/02","02/03/2005",2,5) ;//
		daos.getAbonnementDao().create(a1);
		a1.requeteAjouterAbonnement("30/09/2022", "01/10/2022", 10, 8);
		//a1.requeteSupprimerAbonnement(1);
		//a1.requeteModifierAbonnement(1, "02/10/2021", "03/10/2021", 5, 7);
		System.out.println(a1);

		// A partir d'ici, travail avec les fichiers XML
		daos = DAOFactory.getDAOFactory(Persistance.LISTE_MEMOIRE);

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
		
		
		
	*/
	}

}
