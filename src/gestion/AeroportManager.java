package gestion;

import compagnie.CompagnieAerienne;
import compagnie.Vol;
import moyens.Avion;
import moyens.Pave;

import java.util.ArrayList;
import java.util.List;

public class AeroportManager {
    private List<CompagnieAerienne> compagnies;
    private List<Pave> pistes;
    private List<Vol> vols;
    private List<Avion> avions;

    public AeroportManager() {
        this.compagnies = new ArrayList<>();
        this.pistes = new ArrayList<>();
        this.vols = new ArrayList<>();
        this.avions = new ArrayList<>();
    }

    // === Gestion des compagnies ===
    public void ajouterCompagnie(String nom) {
        CompagnieAerienne compagnie = new CompagnieAerienne(nom);
        compagnies.add(compagnie);
        System.out.println("Compagnie ajoutée : " + nom);
    }

    public List<CompagnieAerienne> getCompagnies() {
        return compagnies;
    }

    // === Gestion des pistes ===
    public void ajouterPiste(String identifiant) {
        Pave pave = new Pave(identifiant);
        pistes.add(pave);
        System.out.println("Piste ajoutée : " + identifiant);
    }

    public List<Pave> getPistes() {
        return pistes;
    }

    // === Gestion des vols ===
    public void ajouterVol(Vol vol) {
        this.vols.add(vol);
    }

    public List<Vol> getVols() {
        return vols;
    }

    // === Gestion des avions ===
    public void ajouterAvion(Avion avion) {
        this.avions.add(avion);
    }

    public List<Avion> getAvions() {
        return avions;
    }
}
