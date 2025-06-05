package ExercicioTelasCardLayout;
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

        TelaInicial telaInicial = new TelaInicial(this);
        TelaNovo telaNovo = new TelaNovo(this);
        TelaAlterar telaAlterar = new TelaAlterar(this);

        container.add(telaInicial, "tela1");
        container.add(telaNovo, "tela2");
        container.add(telaAlterar, "tela3");

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
