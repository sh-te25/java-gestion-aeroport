package employe;

public class Technicien extends EmployeSuper {
    String specialite;

    public Technicien() {
        super();
        specialite = "Non définie";
    }

    public Technicien(int i, String n, String m, String mdp, String spe) {
        super(i, n, m, mdp);
        this.specialite = spe;
    }

    public Technicien(Technicien t) {
        super(t);
        this.specialite = t.specialite;
    }

    public String getSpecialite() {
        return specialite;
    }
    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public void effectuerMaintenance(int idAvion) {
        System.out.println("Effectuée");
    }
    public int verifierAvion(int idAvion) {
        System.out.println("Verifié.");
        return 1;
    }

}
