package employe;

public class Agent extends EmployeSuper {
    String bureau;

    public Agent() {
        super();
        bureau = "Aucun";
    }

    public Agent(int i, String n, String m, String mdp, String bur) {
        super(i, n, m, mdp);
        this.bureau = bur;
    }

    public Agent(Agent a) {
        super(a);
        this.bureau = "Aucun";
    }

    public String getBureau() {
        return bureau;
    }
    public void setBureau(String bureau) {
        this.bureau = bureau;
    }

    public int confirmerVol(int idVol) {
        System.out.println("Confirmé.");
        return 1;
    }
    public void creerPave() {
        System.out.println("Crée");
    }
    public int confirmerPave(int idPave) {
        System.out.println("Confirmé.");
        return 1;
    }
    public void supprimerPave(int idPave) {
        System.out.println("Supprimé.");
    }
    public void traiterReclamation(int idReclamation) {
        System.out.println("Reçue, en traitement...");
    }
}
