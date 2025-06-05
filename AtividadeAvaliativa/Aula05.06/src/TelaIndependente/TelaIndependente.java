package TelaIndependente;
import javax.swing.*;
import java.awt.event.*;

public class TelaIndependente extends JFrame {
    public TelaIndependente() {
        setTitle("Nova Tela");
        setSize(250, 150);
        // Fecha só essa janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Nova janela" , SwingConstants.CENTER); add(label);

        setVisible(true);
    }
}
