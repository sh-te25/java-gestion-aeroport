package auth;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private List<Utilisateur> utilisateurs;

    public LoginService() {
        utilisateurs = new ArrayList<>();

        // Utilisateurs par défaut
        utilisateurs.add(new Utilisateur("admin1", "adminpass", "Admin"));
        utilisateurs.add(new Utilisateur("agent1", "agentpass", "Agent"));
        utilisateurs.add(new Utilisateur("bagagiste1", "bagagepass", "Bagagiste"));
        utilisateurs.add(new Utilisateur("tech1", "techpass", "Technicien"));
    }

    /**
     * Authentifie un utilisateur par identifiant et mot de passe.
     */
    public Utilisateur connecter(String identifiant, String motDePasse) {
        for (Utilisateur u : utilisateurs) {
            if (u.getIdentifiant().equals(identifiant) && u.getMotDePasse().equals(motDePasse)) {
                return u;
            }
        }
        return null;
    }

    /**
     * Ajoute un nouvel utilisateur à la liste.
     */
    public void ajouterUtilisateur(String identifiant, String motDePasse, String role) {
        utilisateurs.add(new Utilisateur(identifiant, motDePasse, role));
    }

    /**
     * Retourne tous les utilisateurs (optionnel).
     */
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }
}
