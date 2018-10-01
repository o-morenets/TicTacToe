import javax.swing.*;
import java.awt.*;

class SettingField extends JPanel {
    public SettingField(){
        JPanel field = new JPanel();
        add(field, BorderLayout.CENTER);
        field.setBackground(Color.cyan);
        field.setLayout(new GridLayout());
        this.add(field);
    }
}