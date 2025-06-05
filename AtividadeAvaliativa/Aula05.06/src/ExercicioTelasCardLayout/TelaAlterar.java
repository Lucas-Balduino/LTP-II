package ExercicioTelasCardLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaAlterar extends JPanel {
    public TelaAlterar(MainFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Tela Alterar");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnAlterar = new JButton("Alterar Perfil");

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarTela("tela1");
            }
        });

        add(label);
        add(btnVoltar);
    }
}
