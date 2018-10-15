import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BottomPanelGame extends JPanel {

    public BottomPanelGame() {
        JPanel panel = new JPanel();
        JButton buttonSetting = new JButton("Настройки");
        JButton buttonExit = new JButton("Выход");
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout());

        buttonSetting.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                MyWindow.changeState(ViewState.START_STATE);
            }
        });

        buttonExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        panel.add(buttonSetting);
        panel.add(buttonExit);
        this.add(panel);
    }
}