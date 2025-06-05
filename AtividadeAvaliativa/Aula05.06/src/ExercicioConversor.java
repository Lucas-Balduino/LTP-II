import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExercicioConversor {
    private JTextField textField1;
    private JComboBox opcoesConversao;
    private JButton converterButton;
    private JPanel panel;
    private JLabel mostrador;

    public double conversorUnidade(double segundos, boolean horas) {
        if (horas) {
            return segundos/3600;
        } else {
            return segundos/60;
        }
    }

    public ExercicioConversor() {
        converterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opcoesConversao.getSelectedIndex() == 0) {
                    mostrador.setText("Tempo: "+String.valueOf(conversorUnidade(Double.parseDouble(textField1.getText()), true)));
                }
                if (opcoesConversao.getSelectedIndex() == 1) {
                    mostrador.setText("Tempo: "+String.valueOf(conversorUnidade(Double.parseDouble(textField1.getText()), false)));
                }
            }
        });

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exercicio1");
            frame.setContentPane(new ExercicioConversor().panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
