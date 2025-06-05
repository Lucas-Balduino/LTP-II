package ExercicioTelasCardLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaNovo extends JPanel {
    public TelaNovo(MainFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Tela Alterar");
        JButton btnVoltar = new JButton("Voltar");
        JButton btnNovo = new JButton("Novo Perfil");

        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarTela("tela1");
            }
        });

        add(label);
        add(btnVoltar);
    }
}
