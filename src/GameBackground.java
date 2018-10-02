import javax.swing.*;
import java.awt.*;

class GameBackground extends JPanel {
    public GameBackground(){
        JPanel field = new JPanel();
        add(field, BorderLayout.CENTER);
        field.setLayout(new GridLayout());
        this.add(field);
    }
}