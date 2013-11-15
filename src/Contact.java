
public class Contact {

	private int idPersonne;
	private String nom;
	private String prenom;
	
	public Contact (int idPersonne, String unNom, String unPrenom){
		this.idPersonne=idPersonne;
		this.nom=unNom;
		this.prenom=unPrenom;
	}
	public int getIdPersonne(){
		return this.idPersonne;
	}
	public String getNom(){
		return this.nom;
	}
	public String getPrenom(){
		return this.prenom;
	}
}