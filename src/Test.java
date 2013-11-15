
import java.sql.*;
import java.util.ArrayList;
public class Test {


	public static void main(String[] args) {
		
		Model unModel = new Model();
		Connection connexion = unModel.connexion();
		System.out.println("ok");
				
		
		try{
			String nom1 = "a";
			Statement statement = connexion.createStatement();
			String req = "SELECT * FROM Contact where nom = '" + nom1 + "'";
			ResultSet res = statement.executeQuery(req);

	//		statement.executeUpdate("CREATE table if not exists personne (Numero int auto_increment primary key,prenom varchar(20) );");
	//		st.executeUpdate("INSERT INTO personne VALUES ('','sylvain'),('','vincent');");
	//		ResultSet rs=statement.executeQuery("SELECT * FROM personne ;");
			while (res.next()){
				int num = res.getInt(1); // recupere la valeur de la premiere colonne
				String nom = res.getString(2); // recupere la valeur de la deuxieme colonne
				System.out.println(" ID = " + num+" Prenom = "+nom ) ;
				}
			res.close() ; // Permet de liberer de la memoire 
			}
		catch(SQLException erreur){
			System.out.println("erreur de requete"+erreur);
		}
		
		ArrayList <Contact> lesContacts = unModel.afficherContact();
		
		for (Contact c : lesContacts) {
			System.out.println(c.getIdPersonne()  + " " + c.getNom() + " " + c.getPrenom());
		}
	}

}
