package test.dao;

import java.util.Scanner;

import dao.client.Adresse;
import dao.enumeration.Persistance;
import dao.factory.DAOFactory;
import metier.Client_pojo;

public class testClientMain {
	public static DAOFactory daos =null;
	
	public static void main(String[] args) throws Exception {
		String nom,prenom,voie,ville,pays,resCli;
		Integer id,no_rue,code_postal;
		Client_pojo p2=new Client_pojo();
		Scanner sc =new Scanner(System.in);
		
	
		
		ChoixPersistance();
		
		System.out.println("Voulez vous cr��r un client ? Appuyer sur YES(oui) ou NO(non)");
		resCli = sc.nextLine();
		if (resCli.equals("YES")) {
			System.out.println("Veuillez saisir le nom");
			nom=sc.nextLine();
			System.out.println("le prenom: ");
			prenom=sc.nextLine();
			System.out.println("le no_rue: ");
			no_rue=sc.nextInt();
			System.out.println("la voie: ");
			sc.next();
			voie=sc.nextLine();
			System.out.println("le code postal: ");
			code_postal=sc.nextInt();
			sc.next();
			System.out.println("la ville: ");
			ville=sc.nextLine();
			System.out.println("le pays: ");
			pays=sc.nextLine();
			pays=Adresse.normalizePays(pays);
			daos.getClientDao().create(p2);
			//p2.requeteAjouterClient(nom, prenom, no_rue, voie, code_postal, ville, pays);	
		}
		
		System.out.println("Voulez vous modifier un client ? Appuyer sur YES(oui) ou NO(non)");
		resCli = sc.nextLine();
		if (resCli.equals("YES")) {
			System.out.println("Veuillez saisir l'id");
			id=sc.nextInt();
			System.out.println("le nom: "); 
			nom=sc.nextLine();
			System.out.println("le prenom: ");	
			prenom=sc.nextLine();
			System.out.println("le no_rue: ");
			no_rue=sc.nextInt();
			System.out.println("la voie: ");
			voie=sc.nextLine();
			System.out.println("le code postal: ");
			code_postal=sc.nextInt();
			System.out.println("la ville: ");
			ville=sc.nextLine();
			System.out.println("le pays: ");
			pays=sc.nextLine();
			daos.getClientDao().update(p2);				
			//p2.requeteModifierClient(id,nom, prenom, no_rue, voie, code_postal, ville, pays);	
			
		}
		
		System.out.println("Voulez vous supprimer un client ? Appuyer sur YES(oui) ou NO(non)");
		resCli = sc.nextLine();
		if (resCli.equals("YES")) {
			System.out.println("Veuillez saisir l'id");
			id=sc.nextInt();
			//p2.requeteRetirerClient(id);
			daos.getClientDao().delete(p2);				
		}
		
		else if (resCli.equals("NO")) {
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

