package moyens;

import employe.Technicien;

public class Avion {
    private String immatriculation;
    private Technicien technicien;

    public Avion(String immatriculation, Technicien technicien) {
        this.immatriculation = immatriculation;
        this.technicien = technicien;
    }

    public String getImmatriculation() { return immatriculation; }
    public Technicien getTechnicien() { return technicien; }

    @Override
    public String toString() {
        return "Avion " + immatriculation + ", Technicien: " + (technicien != null ? technicien.getNom() : "Aucun");
    }
}
