package ui.swing;

import auth.*;
import gestion.*;
import compagnie.CompagnieAerienne;
import moyens.Pave;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {
    private AeroportManager manager;
    private LoginService loginService;
    private DefaultListModel<String> compagnieModel;
    private DefaultListModel<String> pisteModel;

    public AdminFrame() {
        super("Menu Administrateur");
        this.manager = Session.getManager();
        this.loginService = Session.getLoginService();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // === Boutons d'action ===
        JButton ajouterCompagnie = new JButton("Ajouter une compagnie");
        ajouterCompagnie.addActionListener(e -> ajouterCompagnie());

        JButton ajouterPiste = new JButton("Ajouter une piste");
        ajouterPiste.addActionListener(e -> ajouterPiste());

        JButton ajouterUtilisateur = new JButton("Ajouter un utilisateur");
        ajouterUtilisateur.addActionListener(e -> ajouterUtilisateur());

        JPanel topPanel = new JPanel();
        topPanel.add(ajouterCompagnie);
        topPanel.add(ajouterPiste);
        topPanel.add(ajouterUtilisateur);
        add(topPanel, BorderLayout.NORTH);

        // === Listes compagnies et pistes ===
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

        // === Déconnexion ===
        JButton logoutBtn = new JButton("Déconnexion");
        logoutBtn.addActionListener(e -> {
            dispose();
            SwingUtilities.invokeLater(LoginFrame::new);
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(logoutBtn);
        add(bottomPanel, BorderLayout.SOUTH);
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

    private void ajouterUtilisateur() {
        String identifiant = JOptionPane.showInputDialog(this, "Identifiant :");
        if (identifiant == null || identifiant.isBlank()) return;

        String motDePasse = JOptionPane.showInputDialog(this, "Mot de passe :");
        if (motDePasse == null || motDePasse.isBlank()) return;

        String[] roles = {"Admin", "Agent", "Bagagiste", "Technicien"};
        String role = (String) JOptionPane.showInputDialog(
                this,
                "Choisissez un rôle :",
                "Rôle",
                JOptionPane.QUESTION_MESSAGE,
                null,
                roles,
                roles[0]
        );

        if (role == null) return;

        loginService.ajouterUtilisateur(identifiant.trim(), motDePasse.trim(), role);
        JOptionPane.showMessageDialog(this, "Utilisateur ajouté avec succès.");
    }
}


