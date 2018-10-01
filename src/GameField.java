import javax.swing.*;
import java.awt.*;

class GameField extends JPanel {
    public GameField(){
        JPanel field = new JPanel();
        add(field, BorderLayout.CENTER);
        field.setBackground(Color.yellow);
        field.setLayout(new GridLayout());
        this.add(field);
    }
}