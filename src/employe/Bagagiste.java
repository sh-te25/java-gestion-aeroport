package employe;

public class Bagagiste extends EmployeSuper {

    String zoneTravail;


    public Bagagiste() {
        super();
        this.zoneTravail = "Aucune";
    }

    public Bagagiste(int i, String n, String m, String mdp, String zt) {
        super(i, n, m, mdp);
        this.zoneTravail = zt;
    }

    public Bagagiste(Bagagiste b) {
        super(b);
        this.zoneTravail = b.zoneTravail;
    }

    public String getZoneTravail() {
        return zoneTravail;
    }
    public void setZoneTravail(String zoneTravail) {
        this.zoneTravail = zoneTravail;
    }

    public int gererBagage() {
        return 1;
    }
    public int scannerBagage() {
        return 1;
    }
    public String suivreBagage() {
        return "Embarqué";
    }
}
