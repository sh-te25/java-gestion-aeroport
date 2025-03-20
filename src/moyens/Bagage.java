package moyens;

public class Bagage {
    int idBagage;
    float poids;
    String destination;
    String statut;

    public Bagage() {
        this.idBagage = 0;
        this.poids = 0.0f;
        this.destination = "Inconnue";
        this.statut = "Inconnu";
    }

    public Bagage(int i, float p, String d, String s) {
        this.idBagage = i;
        this.poids = p;
        this.destination = d;
        this.statut = s;
    }

    public Bagage(Bagage b) {
        this.idBagage = b.idBagage;
        this.poids = b.poids;
        this.destination = b.destination;
        this.statut = b.statut;
    }


    public int getIdBagage() {
        return idBagage;
    }

    public float getPoids() {
        return poids;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatut() {
        return statut;
    }

    public void setIdBagage(int idBagage) {
        this.idBagage = idBagage;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    // modifierStatut dans la conception est un setter, donc pas besoin de créer une nouvelle méthode
    public void setStatut(String statut) {
        this.statut = statut;
    }

    public void enregistrerBagage() {
        System.out.println("Enregistré.");
    }
}
