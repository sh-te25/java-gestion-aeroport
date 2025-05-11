package moyens;

public class Reclamation {
    private String contenu;

    public Reclamation(String contenu) {
        this.contenu = contenu;
    }

    public String getContenu() {
        return contenu;
    }

    @Override
    public String toString() {
        return "Réclamation: " + contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}
