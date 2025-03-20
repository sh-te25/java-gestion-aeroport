package employe;

public class EmployeSuper {
    int id;
    String nom;
    String email;
    String mot_de_passe;

    public EmployeSuper() {
        this.id = 0;
        this.nom = "SansNom";
        this.email = "SansEmail";
        this.mot_de_passe = "1234";
    }

    public EmployeSuper(int i, String n, String m, String mdp) {
        this.id = i;
        this.nom = n;
        this.email = m;
        this.mot_de_passe = mdp;
    }

    public EmployeSuper(EmployeSuper emp) {
        this.id = emp.id;
        this.nom = emp.nom;
        this.email = emp.email;
        this.mot_de_passe = emp.mot_de_passe;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }
    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }
}
