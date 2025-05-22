import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculadoraPanel {
    private JPanel panel;
    private JTextField visor;
    private JButton button7, button8, button9, buttonDivide;
    private JButton button4, button5, button6, buttonMultiply;
    private JButton button1, button2, button3, buttonMinus;
    private JButton buttonCE, button0, buttonEqual, buttonAdd;

    private Integer num1;
    private Integer num2;
    private String operation;

    public CalculadoraPanel() {
        // Este bloco foi gerado pelo GUI Designer e instancia TODOS os componentes,
        // inclusive 'panel', 'visor' e botões.
        $$$setupUI$$$();

        // Inicializar variáveis de cálculo
        num1 = null;
        num2 = null;
        operation = "";

        // Adicionar listeners a cada botão
        button7.addActionListener(e -> appendNumber(7));
        button8.addActionListener(e -> appendNumber(8));
        button9.addActionListener(e -> appendNumber(9));
        button4.addActionListener(e -> appendNumber(4));
        button5.addActionListener(e -> appendNumber(5));
        button6.addActionListener(e -> appendNumber(6));
        button1.addActionListener(e -> appendNumber(1));
        button2.addActionListener(e -> appendNumber(2));
        button3.addActionListener(e -> appendNumber(3));
        button0.addActionListener(e -> appendNumber(0));

        buttonAdd.addActionListener(e -> setOperation("+"));
        buttonMinus.addActionListener(e -> setOperation("-"));
        buttonMultiply.addActionListener(e -> setOperation("*"));
        buttonDivide.addActionListener(e -> setOperation("/"));

        buttonCE.addActionListener(e -> clear());
        buttonEqual.addActionListener(e -> calculate());
    }

    private void appendNumber(int n) {
        if (operation.isEmpty()) {
            num1 = (num1 == null ? 0 : num1 * 10) + n;
            visor.setText(num1.toString());
        } else {
            num2 = (num2 == null ? 0 : num2 * 10) + n;
            visor.setText(num2.toString());
        }
    }

    private void setOperation(String op) {
        operation = op;
        visor.setText("");
    }

    private void clear() {
        num1 = null;
        num2 = null;
        operation = "";
        visor.setText("");
    }

    private void calculate() {
        if (num1 != null && num2 != null) {
            switch (operation) {
                case "+": num1 += num2; break;
                case "-": num1 -= num2; break;
                case "*": num1 *= num2; break;
                case "/": if (num2 != 0) num1 /= num2; break;
            }
            visor.setText(num1.toString());
            num2 = null;
            operation = "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Calculadora");
            CalculadoraPanel calculadoraPanel = new CalculadoraPanel();
            frame.setContentPane(calculadoraPanel.panel);
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
