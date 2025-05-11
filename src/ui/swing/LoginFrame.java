package ui.swing;

import auth.LoginService;
import auth.Utilisateur;
import employe.Agent;
import employe.Bagagiste;
import employe.Technicien;
import gestion.Session;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    private JTextField identifiantField;
    private JPasswordField motDePasseField;
    private JButton connexionButton;
    private LoginService loginService;

    public LoginFrame() {
        super("Connexion");
        this.loginService = new LoginService();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel idLabel = new JLabel("Identifiant :");
        identifiantField = new JTextField();

        JLabel mdpLabel = new JLabel("Mot de passe :");
        motDePasseField = new JPasswordField();

        connexionButton = new JButton("Connexion");
        connexionButton.addActionListener(e -> traiterConnexion());

        panel.add(idLabel);
        panel.add(identifiantField);
        panel.add(mdpLabel);
        panel.add(motDePasseField);
        panel.add(new JLabel()); // cellule vide
        panel.add(connexionButton);

        add(panel, BorderLayout.CENTER);
    }

    private void traiterConnexion() {
        String login = identifiantField.getText().trim();
        String mdp = new String(motDePasseField.getPassword()).trim();

        Utilisateur u = loginService.connecter(login, mdp);
        if (u != null) {
            JOptionPane.showMessageDialog(this, "Bienvenue, " + u.getRole() + "!");
            dispose();

            switch (u.getRole()) {
                case "Admin":
                    new AdminFrame();
                    break;
                case "Agent":
                    new AgentFrame();
                    break;
                case "Technicien":
                    Technicien technicien = new Technicien(u.getIdentifiant(), u.getIdentifiant(), u.getMotDePasse());
                    new TechnicienFrame(technicien);
                    break;
                case "Bagagiste":
                    new BagagisteFrame();
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Rôle non reconnu.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Identifiants incorrects.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}

