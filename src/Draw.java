import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Draw extends JFrame {
    public Draw(){
        setTitle("ничья");
        setSize(400, 150);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        setBackground(Color.white);
        setLayout(new BorderLayout());
        JLabel label = new JLabel("Увы и ах господа, но это ничья. Так выпьем же за это!!!");
        JButton button = new JButton("Выпьем!!!");
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
