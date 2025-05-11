package compagnie;

import moyens.Bagage;
import moyens.Pave;
import moyens.Reclamation;
import java.util.ArrayList;
import java.util.List;

public class Vol {
    private String codeVol;
    private CompagnieAerienne compagnie;
    private Pave pave;
    private List<Bagage> bagages;
    private List<Reclamation> reclamations;


    public Vol(String codeVol, CompagnieAerienne compagnie, Pave pave) {
        this.codeVol = codeVol;
        this.compagnie = compagnie;
        this.pave = pave;
        this.bagages = new ArrayList<>();
        this.reclamations = new ArrayList<>();

    }

    public String getCodeVol() { return codeVol; }
    public CompagnieAerienne getCompagnie() { return compagnie; }
    public Pave getPave() { return pave; }
    public List<Bagage> getBagages() { return bagages; }
    public List<Reclamation> getReclamations() {
        return reclamations;
    }
    public void ajouterReclamation(Reclamation r) {
        reclamations.add(r);
    }


    public void ajouterBagage(Bagage bagage) {
        bagages.add(bagage);
    }

    @Override
    public String toString() {
        return "Vol " + codeVol + " | Compagnie: " + compagnie.getNom() + " | Piste: " + (pave != null ? pave.getIdentifiant() : "Non assignée");
    }
}
