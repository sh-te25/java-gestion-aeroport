package controller;

import compagnie.CompagnieAerienne;
import gestion.AeroportManager;
import moyens.Pave;

import java.util.Scanner;

public class AdminController {
    private AeroportManager manager;
    private Scanner scanner;

    public AdminController(AeroportManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void lancerMenu() {
        int choix;
        do {
            System.out.println("\n=== Menu Administrateur ===");
            System.out.println("1. Ajouter une compagnie aérienne");
            System.out.println("2. Ajouter une piste");
            System.out.println("3. Afficher les compagnies");
            System.out.println("4. Afficher les pistes");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    ajouterCompagnie();
                    break;
                case 2:
                    ajouterPiste();
                    break;
                case 3:
                    afficherCompagnies();
                    break;
                case 4:
                    afficherPistes();
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 0);
    }

    private void ajouterCompagnie() {
        System.out.print("Nom de la compagnie : ");
        String nom = scanner.nextLine();
        manager.ajouterCompagnie(nom);
    }

    private void ajouterPiste() {
        System.out.print("Identifiant de la piste : ");
        String id = scanner.nextLine();
        manager.ajouterPiste(id);
    }

    private void afficherCompagnies() {
        System.out.println("Liste des compagnies :");
        for (CompagnieAerienne c : manager.getCompagnies()) {
            System.out.println("- " + c);
        }
    }

    private void afficherPistes() {
        System.out.println("Liste des pistes :");
        for (Pave p : manager.getPistes()) {
            System.out.println("- " + p);
        }
    }
}
