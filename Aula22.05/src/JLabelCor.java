import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JLabelCor {
    private JLabel corLabel;
    private JTextField textField;
    private JButton aplicarButton;
    private JPanel panel;
    private String cor;

    public JLabelCor() {
        $$$setupUI$$$();

        aplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText());
                cor = textField.getText();
                corLabel.setText(cor);
                switch (cor){
                    case "yellow":
                        panel.setBackground(Color.yellow);
                        break;
                    case "red":
                        panel.setBackground(Color.red);
                        break;
                    case "black":
                        panel.setBackground(Color.BLACK);
                        break;
                }
            }
        });
        aplicarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora");
            JLabelCor jLabelCor = new JLabelCor();
            frame.setContentPane(jLabelCor.panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    /**
     * ESTE MÉTODO DEVE SER REPLENCHIDO COM O CÓDIGO GERADO PELO GUI DESIGNER (.form).
     * Ele **instancia** todos os componentes, incluindo 'panel', 'visor' e botões,
     * define layout e adiciona os componentes ao painel.
     * Substitua este comentário pelo conteúdo completo de $$$setupUI$$$() gerado.
     */
    private void $$$setupUI$$$() {
        // TODO: Cole aqui o método completo gerado pelo IntelliJ GUI Designer,
        // incluindo linhas como:
        //   panel = new JPanel();
        //   panel.setLayout(...);
        //   visor = new JTextField(...);
        //   button7 = new JButton("7");
        //   panel.add(button7, ...);
        //   ...
    }
}
