public class Contacte {

    protected int id;
    protected String nom;
    protected String cognom;
    protected String telefon;
    protected String email;

    public Contacte(int id, String nom, String cognom, String telefon, String email) {
        this.id = id;
        this.nom = nom;
        this.cognom = cognom;
        this.telefon = telefon;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
