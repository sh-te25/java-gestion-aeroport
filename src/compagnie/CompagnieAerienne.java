package compagnie;

import java.util.ArrayList;
import java.util.List;
import moyens.Pave;
import moyens.Reclamation;

public class CompagnieAerienne {
    private String nom;
    private List<Vol> vols;
    private List<Reclamation> reclamations;

    public CompagnieAerienne(String nom) {
        this.nom = nom;
        this.vols = new ArrayList<>();
        this.reclamations = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public List<Vol> getVols() { return vols; }
    public List<Reclamation> getReclamations() { return reclamations; }

    public void ajouterVol(Vol vol) {
        vols.add(vol);
    }

    public void ajouterReclamation(Reclamation r) {
        reclamations.add(r);
    }

    @Override
    public String toString() {
        return "Compagnie: " + nom + " | Vols: " + vols.size() + " | Réclamations: " + reclamations.size();
    }
}
