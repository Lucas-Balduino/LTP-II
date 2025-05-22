
import java.awt.*;
import java.awt.event.*;

// Exemplo utilizando AWT
public class AWTIA extends Frame implements ActionListener {
    private Label label;
    private TextField textField;
    private Button button;

    public AWTIA() {
        // Configurações da janela
        setTitle("Exemplo AWT");
        setSize(300, 150);
        //setLayout(new FlowLayout());

        // Criação dos componentes
        label = new Label("Digite algo:");
        textField = new TextField(15);
        button = new Button("Enviar");

        // Adiciona componentes à janela
        add(label);
        add(textField);
        add(button);

        // Registra evento de clique
        button.addActionListener(this);

        // Mostra a janela
        setVisible(true);

        // Fecha aplicação ao fechar a janela
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String texto = textField.getText();
        label.setText("Você digitou: " + texto);
    }

    public static void main(String[] args) {
        new AWTIA();
    }
}

