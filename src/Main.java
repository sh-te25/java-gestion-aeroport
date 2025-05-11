package app;

import javax.swing.SwingUtilities;
import ui.swing.LoginFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginFrame::new);
    }
}
