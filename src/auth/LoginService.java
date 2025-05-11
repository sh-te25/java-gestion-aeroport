package auth;

import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private List<Utilisateur> utilisateurs;

    public LoginService() {
        utilisateurs = new ArrayList<>();

        // Comptes prédéfinis pour les tests (à adapter si besoin)
        utilisateurs.add(new Utilisateur("admin1", "adminpass", "Admin"));
        utilisateurs.add(new Utilisateur("agent1", "agentpass", "Agent"));
        utilisateurs.add(new Utilisateur("bagagiste1", "bagagepass", "Bagagiste"));
        utilisateurs.add(new Utilisateur("tech1", "techpass", "Technicien"));
    }

    /**
     * Tente d’authentifier un utilisateur par identifiant et mot de passe.
     * @param identifiant Identifiant saisi
     * @param motDePasse Mot de passe saisi
     * @return Utilisateur correspondant ou null si échec
     */
    public Utilisateur connecter(String identifiant, String motDePasse) {
        for (Utilisateur u : utilisateurs) {
            if (u.getIdentifiant().equals(identifiant) && u.getMotDePasse().equals(motDePasse)) {
                return u;
            }
        }
        return null;
    }
}
