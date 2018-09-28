import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum ViewState {
    START_STATE, GAME_STATE;
}

@SuppressWarnings("serial")
class ButtomPanelSetting extends JPanel {
    public ButtomPanelSetting() {
        JPanel panel = new JPanel();
        JButton button = new JButton("ONE");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyWindow.changeState(ViewState.START_STATE);
            }
        });
        panel.add(button);
        this.add(panel);
    }
}

@SuppressWarnings("serial")
class ButtomPanelGame extends JPanel {
    public ButtomPanelGame() {
        JPanel panel = new JPanel();
        JButton button = new JButton("TWO");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyWindow.changeState(ViewState.GAME_STATE);
            }
        });
        panel.add(button);
        this.add(panel);
    }
}

class MyWindow extends JFrame{
    private static ViewState viewState;
    private static JPanel mpanel;
    private static JPanel setting;
    private static JPanel game;
    private static JFrame frame;

    public MyWindow(){
        frame = new JFrame();
        mpanel = new JPanel();
        setting = new ButtomPanelSetting();
        game = new ButtomPanelGame();

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changeState(ViewState.START_STATE);
        frame.add(mpanel);
        frame.setVisible(true);
    }
    public static void changeState(ViewState state) {
        viewState = state;
        System.out.println("change state: " + viewState);

        switch (state) {
            case START_STATE:
                mpanel.removeAll();
                mpanel.add(game);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            case GAME_STATE:
                mpanel.removeAll();
                mpanel.add(setting);
                mpanel.revalidate();
                mpanel.repaint();
                break;
            default:
                System.out.println("UNKNOWN STATE!");
                break;
        }
    }
}

class Main {
    public static void main(String[] args) {
        MyWindow start = new MyWindow();
    }
}