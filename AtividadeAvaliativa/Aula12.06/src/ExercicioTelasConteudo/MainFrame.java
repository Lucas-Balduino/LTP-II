// MainFrame.java
package ExercicioTelasConteudo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Tela Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTextArea text = new JTextArea(5, 20);
        JButton botaoAbrir = new JButton("Enviar");

        // Layout
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(text);
        add(botaoAbrir);

        botaoAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaIndependente(text.getText());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
