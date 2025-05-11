package ui.swing;

import compagnie.Vol;
import gestion.AeroportManager;
import moyens.Bagage;

import javax.swing.*;
import java.awt.*;

public class BagagisteFrame extends JFrame {
    private AeroportManager manager;

    public BagagisteFrame(AeroportManager manager) {
        super("Menu Bagagiste");
        this.manager = manager;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JButton ajouterBagage = new JButton("Ajouter un bagage");
        ajouterBagage.addActionListener(e -> ajouterBagage());

        JButton voirBagages = new JButton("Voir les bagages d’un vol");
        voirBagages.addActionListener(e -> voirBagages());

        add(ajouterBagage);
        add(voirBagages);
    }

    private void ajouterBagage() {
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

        String id = JOptionPane.showInputDialog(this, "Identifiant du bagage :");
        if (id == null || id.trim().isEmpty()) return;

        vol.ajouterBagage(new Bagage(id.trim()));
        JOptionPane.showMessageDialog(this, "Bagage ajouté.");
    }

    private void voirBagages() {
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

        if (vol.getBagages().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun bagage.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Bagage b : vol.getBagages()) {
            sb.append("- ").append(b).append("\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Bagages", JOptionPane.INFORMATION_MESSAGE);
    }
}
