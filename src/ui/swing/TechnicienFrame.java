package ui.swing;

import employe.Technicien;
import gestion.AeroportManager;
import moyens.Avion;

import javax.swing.*;
import java.awt.*;

public class TechnicienFrame extends JFrame {
    private AeroportManager manager;
    private Technicien technicien;
    private DefaultListModel<String> avionsModel;

    public TechnicienFrame(AeroportManager manager, Technicien technicien) {
        super("Menu Technicien");
        this.manager = manager;
        this.technicien = technicien;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JButton ajouterAvion = new JButton("Ajouter un avion");
        ajouterAvion.addActionListener(e -> ajouterAvion());

        JPanel topPanel = new JPanel();
        topPanel.add(ajouterAvion);
        add(topPanel, BorderLayout.NORTH);

        avionsModel = new DefaultListModel<>();
        JList<String> avionList = new JList<>(avionsModel);
        JScrollPane scroll = new JScrollPane(avionList);
        scroll.setBorder(BorderFactory.createTitledBorder("Avions affectés"));
        add(scroll, BorderLayout.CENTER);

        rafraichirAvions();
    }

    private void ajouterAvion() {
        String immat = JOptionPane.showInputDialog(this, "Immatriculation :");
        if (immat != null && !immat.trim().isEmpty()) {
            Avion avion = new Avion(immat.trim(), technicien);
            manager.ajouterAvion(avion);
            avionsModel.addElement(avion.toString());
        }
    }

    private void rafraichirAvions() {
        avionsModel.clear();
        for (Avion a : manager.getAvions()) {
            if (a.getTechnicien().getIdentifiant().equals(technicien.getIdentifiant())) {
                avionsModel.addElement(a.toString());
            }
        }
    }
}
