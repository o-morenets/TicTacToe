import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

enum ViewState {
    START_STATE, GAME_STATE;
}

//@SuppressWarnings("serial")
class ButtomPanelSetting extends JPanel {
    public ButtomPanelSetting() {

        JPanel panel = new JPanel();
        JButton buttonStart = new JButton("Играть");
        JButton buttonExit = new JButton("Выход");
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout());

        buttonStart.addActionListener(new ActionListener() {
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
        panel.add(buttonStart);
        panel.add(buttonExit);
        this.add(panel);
    }
}

//@SuppressWarnings("serial")
class ButtomPanelGame extends JPanel {
    public ButtomPanelGame() {
        JPanel panel = new JPanel();
        JButton buttonSetting = new JButton("Настройки");
        JButton buttonExit = new JButton("Выход");
        add(panel, BorderLayout.SOUTH);
        panel.setLayout(new GridLayout());

        buttonSetting.addActionListener(new ActionListener() {
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
        panel.add(buttonSetting);
        panel.add(buttonExit);
        this.add(panel);
    }
}

class SettingField extends JPanel {
    public SettingField(){
        JPanel field = new JPanel();
        add(field, BorderLayout.CENTER);
        field.setBackground(Color.cyan);
        field.setLayout(new GridLayout());
        this.add(field);
    }
}

class GameField extends JPanel{
    public GameField(){
        JPanel field = new JPanel();
        add(field, BorderLayout.CENTER);
        field.setBackground(Color.yellow);
        field.setLayout(new GridLayout());
        this.add(field);
    }
}

class MyWindow extends JFrame{
    private static ViewState viewState;
    private static JPanel mpanel;
    private static JPanel mpanel2;
    private static JPanel setting;
    private static JPanel game;
    private static JPanel gameField;
    private static JPanel settingField;
    private static JFrame frame;


    public MyWindow(){
        frame = new JFrame();
        mpanel = new JPanel();
        mpanel2 = new JPanel();
        setting = new ButtomPanelSetting();
        game = new ButtomPanelGame();
        gameField = new GameField();
        settingField = new SettingField();



        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        changeState(ViewState.START_STATE);

        mpanel.setLayout(new BorderLayout());

        mpanel.add(game, BorderLayout.SOUTH);
        mpanel.add(setting, BorderLayout.SOUTH);
        mpanel2.add(gameField, BorderLayout.CENTER);
        mpanel2.add(settingField, BorderLayout.CENTER);

        gameField.setPreferredSize(new Dimension(400,360));
        settingField.setPreferredSize(new Dimension(400,360));
        game.setPreferredSize(new Dimension(1,40));
        setting.setPreferredSize(new Dimension(1,40));
        gameField.setBackground(Color.yellow);
        settingField.setBackground(Color.cyan);

        settingField.setLayout(new BorderLayout());
        gameField.setLayout(new BorderLayout());
        setting.setLayout(new GridLayout());
        game.setLayout(new GridLayout());

        frame.getContentPane().add(BorderLayout.SOUTH, mpanel);
        frame.getContentPane().add(BorderLayout.CENTER, mpanel2);
        frame.setVisible(true);
    }
    public static void changeState(ViewState state) {
        viewState = state;
        System.out.println("change state: " + viewState);

        switch (state) {
            case START_STATE:
                mpanel.removeAll();
                mpanel2.removeAll();
                mpanel.add(game);
                mpanel2.add(gameField);
                mpanel.revalidate();
                mpanel2.revalidate();
                mpanel.repaint();
                mpanel2.repaint();
                break;
            case GAME_STATE:
                mpanel.removeAll();
                mpanel2.removeAll();
                mpanel.add(setting);
                mpanel2.add(settingField);
                mpanel.revalidate();
                mpanel2.revalidate();
                mpanel.repaint();
                mpanel2.repaint();
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