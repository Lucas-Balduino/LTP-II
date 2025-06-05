package TelaIndependente;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame2 extends JFrame {
    public MainFrame2() {
        setTitle("Tela Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton botaoAbrir = new JButton("Abrir nova tela");

        botaoAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TelaIndependente(); // Abre a nova janela
            }
        });

        add(botaoAbrir);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainFrame2();
    }
}
