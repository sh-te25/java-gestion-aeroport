package ui.swing;

import compagnie.CompagnieAerienne;
import gestion.AeroportManager;
import moyens.Pave;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {
    private AeroportManager manager;
    private DefaultListModel<String> compagnieModel;
    private DefaultListModel<String> pisteModel;

    public AdminFrame(AeroportManager manager) {
        super("Menu Administrateur");
        this.manager = manager;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();

        setVisible(true);
    }

    private void initComponents() {
        // === Boutons ===
        JButton ajouterCompagnie = new JButton("Ajouter une compagnie");
        ajouterCompagnie.addActionListener(e -> ajouterCompagnie());

        JButton ajouterPiste = new JButton("Ajouter une piste");
        ajouterPiste.addActionListener(e -> ajouterPiste());

        JPanel topPanel = new JPanel();
        topPanel.add(ajouterCompagnie);
        topPanel.add(ajouterPiste);
        add(topPanel, BorderLayout.NORTH);

        // === Listes ===
        compagnieModel = new DefaultListModel<>();
        JList<String> compagnieList = new JList<>(compagnieModel);
        JScrollPane compagnieScroll = new JScrollPane(compagnieList);
        compagnieScroll.setBorder(BorderFactory.createTitledBorder("Compagnies"));

        pisteModel = new DefaultListModel<>();
        JList<String> pisteList = new JList<>(pisteModel);
        JScrollPane pisteScroll = new JScrollPane(pisteList);
        pisteScroll.setBorder(BorderFactory.createTitledBorder("Pistes"));

        JPanel centerPanel = new JPanel(new GridLayout(1, 2));
        centerPanel.add(compagnieScroll);
        centerPanel.add(pisteScroll);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void ajouterCompagnie() {
        String nom = JOptionPane.showInputDialog(this, "Nom de la compagnie :");
        if (nom != null && !nom.trim().isEmpty()) {
            manager.ajouterCompagnie(nom.trim());
            compagnieModel.addElement(nom.trim());
        }
    }

    private void ajouterPiste() {
        String id = JOptionPane.showInputDialog(this, "Identifiant de la piste :");
        if (id != null && !id.trim().isEmpty()) {
            manager.ajouterPiste(id.trim());
            pisteModel.addElement(id.trim());
        }
    }
}
