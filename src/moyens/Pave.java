package moyens;

public class Pave {
    int numeroPiste;
    Boolean estLoue; // je l'ai défini comme Boolean car nous avons deux états: loué ou non.

    public Pave() {
        this.numeroPiste = 0;
        this.estLoue = false;
    }

    public Pave(int nP, Boolean eL) {
        this.numeroPiste = nP;
        this.estLoue = eL;
    }

    public Pave(Pave p) {
        this.numeroPiste = p.numeroPiste;
        this.estLoue = p.estLoue;
    }

    public int getNumeroPiste() {
        return numeroPiste;
    }
    public Boolean getEstLoue() {
        return estLoue;
    }

    public void setNumeroPiste(int nPiste) {
        this.numeroPiste = nPiste;
    }
    public void setEstLoue(Boolean estLoue) {
        this.estLoue = estLoue;
    }

    public Boolean confirmerLocation(int numeroPiste) {
        if (!(this.estLoue)) {
            System.out.println("Location de la piste " + numeroPiste + " confirmée.");
            return true;
        }
        return false;
    }
    // pour qu'on puisse l'appeler et enregistrer la valeur directement: pave1.estLoue=setEstLoue(confirmerLocation(2));
}
