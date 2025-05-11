package employe;

public abstract class EmployeSuper {
    protected String nom;
    protected String identifiant;
    protected String motDePasse;

    public EmployeSuper(String nom, String identifiant, String motDePasse) {
        this.nom = nom;
        this.identifiant = identifiant;
        this.motDePasse = motDePasse;
    }

    public String getNom() { return nom; }
    public String getIdentifiant() { return identifiant; }
    public String getMotDePasse() { return motDePasse; }

    @Override
    public String toString() {
        return nom + " (" + this.getClass().getSimpleName() + ")";
    }
}

