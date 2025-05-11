package ui.swing;

import compagnie.Vol;
import compagnie.CompagnieAerienne;
import gestion.AeroportManager;
import gestion.Session;
import moyens.Pave;
import moyens.Reclamation;

import javax.swing.*;
import java.awt.*;

public class AgentFrame extends JFrame {
    private AeroportManager manager;
    private DefaultListModel<String> volsModel;

    public AgentFrame() {
        super("Menu Agent de planification");
        this.manager = Session.getManager();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // === Boutons d’action ===
        JButton creerVolBtn = new JButton("Créer un vol");
        creerVolBtn.addActionListener(e -> creerVol());

        JButton creerReclamationBtn = new JButton("Créer une réclamation");
        creerReclamationBtn.addActionListener(e -> creerReclamation());

        JButton afficherReclamationsBtn = new JButton("Voir les réclamations");
        afficherReclamationsBtn.addActionListener(e -> voirReclamations());

        JButton supprimerReclamationBtn = new JButton("Supprimer une réclamation");
        supprimerReclamationBtn.addActionListener(e -> supprimerReclamation());

        JButton modifierReclamationBtn = new JButton("Modifier une réclamation");
        modifierReclamationBtn.addActionListener(e -> modifierReclamation());




        JPanel top = new JPanel(new GridLayout(3, 2, 5, 5));
        top.add(creerVolBtn);
        top.add(creerReclamationBtn);
        top.add(afficherReclamationsBtn);
        top.add(supprimerReclamationBtn);
        top.add(modifierReclamationBtn);
        add(top, BorderLayout.NORTH);

        // === Liste des vols ===
        volsModel = new DefaultListModel<>();
        JList<String> liste = new JList<>(volsModel);
        JScrollPane scroll = new JScrollPane(liste);
        scroll.setBorder(BorderFactory.createTitledBorder("Vols créés"));
        add(scroll, BorderLayout.CENTER);

        // === Bouton de déconnexion ===
        JButton logoutBtn = new JButton("Déconnexion");
        logoutBtn.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(LoginFrame::new);
        });

        JPanel bottom = new JPanel();
        bottom.add(logoutBtn);
        add(bottom, BorderLayout.SOUTH);
    }

    private void creerVol() {
        if (manager.getCompagnies().isEmpty() || manager.getPistes().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ajoutez d'abord des compagnies et des pistes.");
            return;
        }

        String code = JOptionPane.showInputDialog(this, "Code du vol :");
        if (code == null || code.isBlank()) return;

        CompagnieAerienne compagnie = (CompagnieAerienne) JOptionPane.showInputDialog(
                this,
                "Choisissez la compagnie :",
                "Compagnie",
                JOptionPane.QUESTION_MESSAGE,
                null,
                manager.getCompagnies().toArray(),
                null
        );

        Pave pave = (Pave) JOptionPane.showInputDialog(
                this,
                "Choisissez la piste :",
                "Piste",
                JOptionPane.QUESTION_MESSAGE,
                null,
                manager.getPistes().toArray(),
                null
        );

        if (compagnie == null || pave == null) return;

        Vol vol = new Vol(code.trim(), compagnie, pave);
        compagnie.ajouterVol(vol);
        manager.ajouterVol(vol);
        volsModel.addElement(vol.toString());
    }

    private void creerReclamation() {
        if (manager.getVols().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun vol disponible.");
            return;
        }

        Vol vol = (Vol) JOptionPane.showInputDialog(
                this,
                "Choisissez un vol :",
                "Vol",
                JOptionPane.QUESTION_MESSAGE,
                null,
                manager.getVols().toArray(),
                null
        );

        if (vol == null) return;

        String contenu = JOptionPane.showInputDialog(this, "Contenu de la réclamation :");
        if (contenu == null || contenu.isBlank()) return;

        vol.ajouterReclamation(new Reclamation(contenu.trim()));
        JOptionPane.showMessageDialog(this, "Réclamation ajoutée.");
    }

    private void voirReclamations() {
        if (manager.getVols().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun vol disponible.");
            return;
        }

        Vol vol = (Vol) JOptionPane.showInputDialog(
                this,
                "Choisissez un vol :",
                "Vol",
                JOptionPane.QUESTION_MESSAGE,
                null,
                manager.getVols().toArray(),
                null
        );

        if (vol == null) return;

        StringBuilder sb = new StringBuilder();
        for (Reclamation r : vol.getReclamations()) {
            sb.append("- ").append(r.getContenu()).append("\n");
        }

        JOptionPane.showMessageDialog(this,
                sb.length() == 0 ? "Aucune réclamation." : sb.toString(),
                "Réclamations",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void supprimerReclamation() {
        if (manager.getVols().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun vol disponible.");
            return;
        }

        Vol vol = (Vol) JOptionPane.showInputDialog(
                this,
                "Choisissez un vol :",
                "Vol",
                JOptionPane.QUESTION_MESSAGE,
                null,
                manager.getVols().toArray(),
                null
        );

        if (vol == null) return;

        if (vol.getReclamations().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucune réclamation pour ce vol.");
            return;
        }

        Reclamation reclamation = (Reclamation) JOptionPane.showInputDialog(
                this,
                "Choisissez la réclamation à supprimer :",
                "Supprimer réclamation",
                JOptionPane.QUESTION_MESSAGE,
                null,
                vol.getReclamations().toArray(),
                null
        );

        if (reclamation == null) return;

        vol.getReclamations().remove(reclamation);
        JOptionPane.showMessageDialog(this, "Réclamation supprimée.");
    }

    private void modifierReclamation() {

            if (manager.getVols().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Aucun vol disponible.");
                return;
            }

            Vol vol = (Vol) JOptionPane.showInputDialog(
                    this,
                    "Choisissez un vol :",
                    "Vol",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    manager.getVols().toArray(),
                    null
            );

            if (vol == null) return;

            if (vol.getReclamations().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Aucune réclamation pour ce vol.");
                return;
            }

            Reclamation reclamation = (Reclamation) JOptionPane.showInputDialog(
                    this,
                    "Choisissez la réclamation à modifier :",
                    "Modifier réclamation",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    vol.getReclamations().toArray(),
                    null
            );

            if (reclamation == null) return;

            String nouveauContenu = JOptionPane.showInputDialog(this, "Nouveau contenu :", reclamation.getContenu());
            if (nouveauContenu == null || nouveauContenu.isBlank()) return;

            reclamation.setContenu(nouveauContenu.trim());
            JOptionPane.showMessageDialog(this, "Réclamation modifiée.");
        }

}
