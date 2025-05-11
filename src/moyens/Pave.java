package moyens;

public class Pave {
    private String identifiant;

    public Pave(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    @Override
    public String toString() {
        return "Piste: " + identifiant;
    }
}
