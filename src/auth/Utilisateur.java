package auth;

public class Utilisateur {
    private String identifiant;
    private String motDePasse;
    private String role; // "Admin", "Agent", "Bagagiste", "Technicien"

    public Utilisateur(String identifiant, String motDePasse, String role) {
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
        this.role = role;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getRole() {
        return role;
    }
}
