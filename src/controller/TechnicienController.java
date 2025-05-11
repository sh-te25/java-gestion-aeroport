package controller;

import employe.Technicien;
import gestion.AeroportManager;
import moyens.Avion;

import java.util.Scanner;

public class TechnicienController {
    private AeroportManager manager;
    private Scanner scanner;
    private Technicien technicien;

    public TechnicienController(AeroportManager manager, Technicien technicien) {
        this.manager = manager;
        this.technicien = technicien;
        this.scanner = new Scanner(System.in);
    }

    public void lancerMenu() {
        int choix;
        do {
            System.out.println("\n=== Menu Technicien ===");
            System.out.println("1. Ajouter un avion");
            System.out.println("2. Voir les avions affectés");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    ajouterAvion();
                    break;
                case 2:
                    afficherAvions();
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private void ajouterAvion() {
        System.out.print("Immatriculation de l'avion : ");
        String immatriculation = scanner.nextLine();

        Avion avion = new Avion(immatriculation, technicien);
        manager.ajouterAvion(avion);
        System.out.println("Avion ajouté avec succès.");
    }

    private void afficherAvions() {
        boolean trouve = false;
        for (Avion a : manager.getAvions()) {
            if (a.getTechnicien().getIdentifiant().equals(technicien.getIdentifiant())) {
                System.out.println("- " + a);
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Aucun avion assigné à ce technicien.");
        }
    }
}
