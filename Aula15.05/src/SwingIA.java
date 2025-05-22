
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Exemplo utilizando Swing
public class SwingIA extends JFrame implements ActionListener {
    private JLabel label;
    private JTextField textField;
    private JButton button;

    public SwingIA() {
        // Configurações da janela
        setTitle("Exemplo Swing");
        setSize(350, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLayout(new FlowLayout());

        // Criação dos componentes
        label = new JLabel("Digite algo:");
        textField = new JTextField(15);
        button = new JButton("Enviar");

        // Adiciona componentes à janela
        add(label);
        add(textField);
        add(button);

        // Registra evento de clique
        button.addActionListener(this);

        // Mostra a janela
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = textField.getText();
        label.setText("Você digitou: " + texto);
    }

    public static void main(String[] args) {
        // Altera o Look and Feel para o padrão do sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        new SwingIA();
    }
}
