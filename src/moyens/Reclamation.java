package moyens;

public class Reclamation {
    int idReclamation;
    int idCompagnie;
    String type;
    String description;
    String statut;

    public Reclamation() {
        this.idReclamation = 0;
        this.idCompagnie = 0;
        this.type = "Générale";
        this.description = "Sans texte";
        this.statut = "Non traitée";
    }

    public Reclamation(int iR, int iC, String t, String d, String s) {
        this.idReclamation = iR;
        this.idCompagnie = iC;
        this.type = t;
        this.description = d;
        this.statut = s;
    }

    public Reclamation(Reclamation r) {
        this.idReclamation = r.idReclamation;
        this.idCompagnie = r.idCompagnie;
        this.type = r.type;
        this.description = r.description;
        this.statut = r.statut;
    }


    public int getIdReclamation() {
        return idReclamation;
    }
    public int getIdCompagnie() {
        return idCompagnie;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public String getStatut() {
        return statut;
    }

    public void setIdReclamation(int idReclamation) {
        this.idReclamation = idReclamation;
    }
    public void setIdCompagnie(int idCompagnie) {
        this.idCompagnie = idCompagnie;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    // soumettreReclamation est tout simplement la création d'un nouvel objet Reclamation. Pas besoin d'ajouter une méthode.
    // le traitement de la réclamation, de ce côté, sera un setter; les employes traitent les reclamation, pas la réclamation elle-même
}
