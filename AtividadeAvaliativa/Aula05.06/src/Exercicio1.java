import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercicio1 {
    private JComboBox comboBox1;
    private JTextArea textArea1;
    private JButton button1;
    private JPanel panel;
    private String input;
    private String[] palavras;

    private String[] stringFormater(String input){
        return palavras = input.split(",");
    }

    Exercicio1() {

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                input = textArea1.getText();
                textArea1.setText("");
                comboBox1.removeAllItems();
                palavras = stringFormater(input);
                for (String palavra : palavras) {
                    comboBox1.addItem(palavra.trim());
                }
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exercicio1");
            frame.setContentPane(new Exercicio1().panel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
