import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BottomPanelSetting extends JPanel {
    public BottomPanelSetting() {

        JPanel panel = new JPanel();
        JButton buttonStart = new JButton("Играть");
        JButton buttonExit = new JButton("Выход");
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout());

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    MyWindow.changeState(ViewState.GAME_STATE);
                }
        });
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
        });
        panel.add(buttonStart);
        panel.add(buttonExit);
        this.add(panel);
    }
}

