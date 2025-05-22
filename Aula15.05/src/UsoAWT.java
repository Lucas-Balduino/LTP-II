import java.awt.*;

public class UsoAWT {
    public static void main(String[] args) {
        Frame frame = new Frame("Uso AWT");
        Button button = new Button("Click Me");
        frame.add(button);
        frame.setSize(300,200);
        //frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
