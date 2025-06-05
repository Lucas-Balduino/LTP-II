package TransicaoEntreTelas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSecundaria extends JPanel {
    public TelaSecundaria(MainFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Tela Secundária");
        JButton btn = new JButton("Voltar para Tela Inicial");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarTela("tela1");
            }
        });

        add(label);
        add(btn);
    }
}
