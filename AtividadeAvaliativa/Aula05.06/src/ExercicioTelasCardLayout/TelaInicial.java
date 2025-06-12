package ExercicioTelasCardLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    public TelaInicial(MainFrame frame) {
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Tela Inicial");
        JButton btnNovo = new JButton("Ir para Tela Novo");
        JButton btnAlterar = new JButton("Ir para Tela Alterar");

        btnNovo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarTela("tela2");
            }
        });
        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarTela("tela2");
            }
        });

        add(label);
        add(btnAlterar);
        add(btnNovo);
    }
}