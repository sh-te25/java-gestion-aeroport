package controller;

import compagnie.Vol;
import gestion.AeroportManager;
import moyens.Bagage;

import java.util.Scanner;

public class BagagisteController {
    private AeroportManager manager;
    private Scanner scanner;

    public BagagisteController(AeroportManager manager) {
        this.manager = manager;
        this.scanner = new Scanner(System.in);
    }

    public void lancerMenu() {
        int choix;
        do {
            System.out.println("\n=== Menu Bagagiste ===");
            System.out.println("1. Ajouter un bagage à un vol");
            System.out.println("2. Voir les bagages d’un vol");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = Integer.parseInt(scanner.nextLine());

            switch (choix) {
                case 1:
                    ajouterBagage();
                    break;
                case 2:
                    voirBagages();
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        } while (choix != 0);
    }

    private void ajouterBagage() {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("Sélectionnez un vol :");
        for (int i = 0; i < manager.getVols().size(); i++) {
            System.out.println(i + ". " + manager.getVols().get(i));
        }
        int choixVol = Integer.parseInt(scanner.nextLine());
        Vol vol = manager.getVols().get(choixVol);

        System.out.print("Identifiant du bagage : ");
        String idBagage = scanner.nextLine();
        Bagage bagage = new Bagage(idBagage);
        vol.ajouterBagage(bagage);

        System.out.println("Bagage ajouté au vol " + vol.getCodeVol());
    }

    private void voirBagages() {
        if (manager.getVols().isEmpty()) {
            System.out.println("Aucun vol disponible.");
            return;
        }

        System.out.println("Sélectionnez un vol :");
        for (int i = 0; i < manager.getVols().size(); i++) {
            System.out.println(i + ". " + manager.getVols().get(i));
        }
        int choixVol = Integer.parseInt(scanner.nextLine());
        Vol vol = manager.getVols().get(choixVol);

        if (vol.getBagages().isEmpty()) {
            System.out.println("Aucun bagage pour ce vol.");
            return;
        }

        System.out.println("Bagages du vol " + vol.getCodeVol() + " :");
        for (Bagage b : vol.getBagages()) {
            System.out.println("- " + b);
        }
    }
}

