import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame {
    public Win(){
        setTitle("ПОБЕДА");
        setSize(400, 150);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        setBackground(Color.white);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Это победа!!!");
        JButton button = new JButton("Все равно выпьем!!!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("тут надо сделать закрытие");
            }
        });
        add(panel, BorderLayout.NORTH);
        panel.setPreferredSize(new Dimension(1, 50));
        panel.add(label, BorderLayout.NORTH);
        panel.setBackground(Color.white);
        add(button, BorderLayout.CENTER);
        setVisible(true);
    }
}
