import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExercicioBorderLayout {
    private JPanel painel;
    private JTextArea areaDeTexto;
    private JButton botãoSulButton;
    private JRadioButton opçãoRadioButton;
    private JList Lista;
    private JTextArea textInput;

    public ExercicioBorderLayout() {
        botãoSulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = textInput.getText();
                areaDeTexto.setText(texto);
                JOptionPane.showMessageDialog(null, "Olá: " + texto);
            }
        });
    }
}


