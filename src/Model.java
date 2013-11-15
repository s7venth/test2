	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



	public class Model {
		private static Connection connexion = null;	
		private static Statement st;
			
		public  Connection connexion() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connexion = DriverManager.getConnection("jdbc:mysql://localhost/Contacts", "root", "");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Driver non chargé !" + e);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return connexion;
		}
		
		public static void insererContact(int idPersonne, String nom, String prenom){
			try {
				
				PreparedStatement statement = connexion.prepareStatement("INSERT INTO Contact(nom, prenom, email) values (?, ?, ?)");
				statement.setInt(1, 8);
				statement.setString(2, "Laurent");
				statement.setString(3, "martin.laurent@lycee.fr");
				statement.executeUpdate();
				
				statement.close();
			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		public static ArrayList<Contact> afficherContact(){
			ArrayList<Contact> lesContacts = new ArrayList<Contact>();
			try {
				Statement st = connexion.createStatement();
				String req = "SELECT * FROM personne";
				ResultSet rs = st.executeQuery(req); // Requete SQL qui renvoie une valeur
				// Pour accéder à chacune des lignes du résultat de la requête :
				while (rs.next()) {
					lesContacts.add(new Contact(rs.getInt(1), rs.getString(2), rs.getString(3)));
				}
				rs.close() ; // Permet de libérer la mémoire utilisée

			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return lesContacts;
		}
		
		public static void supprimerContact(int idPersonne){
			
			try {
				st.executeUpdate ("DELETE FROM Contact where idPersonne = " + idPersonne); // Requete SQL qui renvoie une valeur
						
			} catch (SQLException e) { 
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public void Deconnection(){
			try {
				connexion.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}