import javax.swing.*;
import java.awt.*;

enum ViewState {
    START_STATE, GAME_STATE;
}

class MyWindow extends JFrame{
    private static ViewState viewState;
    private static JPanel mainPanelBottom;
    private static JPanel mainPanelTop;
    private static JPanel setting;
    private static JPanel game;
    private static JPanel gameField;
    private static JPanel settingField;
    private static JFrame frame;
//    private static Image image;

    public MyWindow(){
        frame = new JFrame();
        mainPanelBottom = new JPanel();
        mainPanelTop = new JPanel();
        setting = new BottomPanelSetting();
        game = new BottomPanelGame();
        gameField = new GameField();
        settingField = new SettingField();

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanelBottom.setLayout(new BorderLayout());

        mainPanelBottom.add(game, BorderLayout.SOUTH);
        mainPanelBottom.add(setting, BorderLayout.SOUTH);
        mainPanelTop.add(gameField, BorderLayout.CENTER);
        mainPanelTop.add(settingField, BorderLayout.CENTER);

        gameField.setPreferredSize(new Dimension(400,340));
        settingField.setPreferredSize(new Dimension(400,340));
        game.setPreferredSize(new Dimension(1,40));
        setting.setPreferredSize(new Dimension(1,40));
        gameField.setBackground(Color.yellow);
        settingField.setBackground(Color.cyan);


        settingField.setLayout(new BorderLayout());
        gameField.setLayout(new BorderLayout());
        setting.setLayout(new GridLayout());
        game.setLayout(new GridLayout());

        frame.getContentPane().add(BorderLayout.SOUTH, mainPanelBottom);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanelTop);
        changeState(ViewState.START_STATE);
        frame.setVisible(true);
    }
    public static void changeState(ViewState state) {
        viewState = state;
        System.out.println("change state: " + viewState);

        switch (state) {
            case START_STATE:
                mainPanelBottom.removeAll();
                mainPanelTop.removeAll();
                mainPanelBottom.add(setting);
                mainPanelTop.add(settingField);
                mainPanelBottom.revalidate();
                mainPanelTop.revalidate();
                mainPanelBottom.repaint();
                mainPanelTop.repaint();
                break;
            case GAME_STATE:
                mainPanelBottom.removeAll();
                mainPanelTop.removeAll();
                mainPanelBottom.add(game);
                mainPanelTop.add(gameField);
                mainPanelBottom.revalidate();
                mainPanelTop.revalidate();
                mainPanelBottom.repaint();
                mainPanelTop.repaint();
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