import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ExercicioCheckBox {
    private JCheckBox checkBoxNacional;
    private JCheckBox checkBoxEstrangeiro;
    private JLabel labelCpfPassaporte;
    private JPanel panel;
    private JTextField textField;
    private JButton enviarButton;
    private String mensagem;

    ExercicioCheckBox() {
        $$$setupUI$$$();

        ImageIcon icon = new ImageIcon(getClass().getResource("IconeCurtida.png"));


        checkBoxNacional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCpfPassaporte.setText("CPF");
                checkBoxEstrangeiro.setSelected(false);

            }
        });
        checkBoxEstrangeiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelCpfPassaporte.setText("Passaporte");
                checkBoxNacional.setSelected(false);
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,textField.getText());
            }
        });

        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora");
            ExercicioCheckBox exercicioCheckBox= new ExercicioCheckBox();
            frame.setContentPane(exercicioCheckBox.panel);
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

    private void createUIComponents() {
        //Button enviarButton = new Button("Enviar", icon);
    }
}
