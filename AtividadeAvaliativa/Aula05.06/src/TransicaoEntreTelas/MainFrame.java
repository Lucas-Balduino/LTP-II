package TransicaoEntreTelas;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    CardLayout cardLayout;
    JPanel container;

    public MainFrame() {
        setTitle("Transição de Telas com Swing");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);

        TelaInicial tela1 = new TelaInicial(this);
        TelaSecundaria tela2 = new TelaSecundaria(this);

        container.add(tela1, "tela1");
        container.add(tela2, "tela2");

        add(container);
        setVisible(true);
    }

    public void mostrarTela(String nomeTela) {
        cardLayout.show(container, nomeTela);
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
