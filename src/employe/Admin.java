package employe;

public class Admin extends EmployeSuper {
    public Admin() {
        super();
    }
    public Admin(int i, String n, String m, String mdp) {
        super(i, n, m, mdp);
    }
    public Admin(Admin a) {
        super(a);
    }

    public void gererUtilisateur() {
        System.out.println("Menu de gestion...");
    }
    public void assignerRole(EmployeSuper e) {
        System.out.println("Rôle assigné");
    }

}
