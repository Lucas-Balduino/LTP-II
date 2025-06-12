// TelaIndependente.java
package ExercicioTelasConteudo;

import javax.swing.*;

public class TelaIndependente extends JFrame {
    public TelaIndependente(String informacao) {
        setTitle("Nova Tela");
        setSize(250, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel(informacao, SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
}
