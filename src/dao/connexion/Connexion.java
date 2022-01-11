package dao.connexion;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {
	private static Connexion instance;
	private String bdd;
	private String url;
	private String pass;
	private String login;

	private Connexion() {
		this.chargeFile();
	}

	public static Connexion getInstance() {
		if(instance==null) {
			instance = new Connexion();
		}
		return instance;
	}


	public static void setInstance(Connexion instance) {
		Connexion.instance = instance;
	}

	public Connection creeConnexion() {
		Connection maConnexion = null;
		try {
			maConnexion = DriverManager.getConnection(this.url, this.login, this.pass);
			System.out.println("Connexion établie");
		} catch (SQLException sqle) {
			System.out.println("Erreur connexion" + sqle.getMessage());
		}
		return maConnexion;

	}

	public void chargeFile() {
		Properties accesBdd = new Properties();
		File fBdd= new File ("config/Properties.txt");
		try {
			FileInputStream source = new FileInputStream(fBdd);
			accesBdd.loadFromXML(source);
		}
		catch (IOException ioe) {
			ioe.printStackTrace()
			;        }
		this.login = accesBdd.getProperty("login");
		this.pass= accesBdd.getProperty("pass");
		this.url= "jdbc:mysql://"+ accesBdd.getProperty("url")+":"+ accesBdd.getProperty("port")+ "/"+accesBdd.getProperty("bdd");
	}

}

