import javax.swing.*;
import java.awt.*;

public class UsoSwing {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Uso AWT");
        JButton button = new JButton("Click Me");
        frame.add(button);
        frame.setSize(300,200);
        //frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Funcionamento do botao de fechar para encerrar o programa
        frame.setVisible(true);
    }
}

