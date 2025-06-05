package TransicaoEntreTelas;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JPanel {
    public TelaInicial(MainFrame frame) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel label = new JLabel("Tela Inicial");
        JButton btn = new JButton("Ir para Tela Secundária");

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.mostrarTela("tela2");
            }
        });

        add(label);
        add(btn);
    }
}
