import javax.swing.*;
import java.awt.*;

class GameBackground extends JPanel {
    public GameBackground(){
        JPanel panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.setLayout(new GridLayout());
        this.add(panel);
    }
}