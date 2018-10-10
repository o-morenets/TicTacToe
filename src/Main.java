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
    private static JPanel settingField;
    private static JFrame frame;
    private static JPanel gameBackground;
    private static JPanel gameField;

    public MyWindow(){
        frame = new JFrame();
        mainPanelBottom = new JPanel();
        mainPanelTop = new JPanel();
        setting = new BottomPanelSetting();
        game = new BottomPanelGame();
        settingField = new SettingField();
        gameField = new GameField();
        gameBackground = new GameBackground();

        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanelBottom.setLayout(new BorderLayout());
        mainPanelTop.setLayout(new BorderLayout());
        gameBackground.setPreferredSize(new Dimension(600,660));
        settingField.setPreferredSize(new Dimension(600,660));
//        settingField.setBackground(new Color(233,245,180));
        game.setPreferredSize(new Dimension(1,40));
        setting.setPreferredSize(new Dimension(1,40));

        settingField.setLayout(new BorderLayout());
        JPanel mainData = new JPanel();
        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        mainData.setLayout(new BoxLayout(mainData, BoxLayout.Y_AXIS));
        mainData.setBackground(Color.cyan);
        panelOne.setPreferredSize(new Dimension(40,40));
        panelTwo.setPreferredSize(new Dimension(40,40));
        panelOne.setBackground(Color.white);
        panelTwo.setBackground(Color.white);
        mainData.add(panelOne);
        mainData.add(panelTwo);
        settingField.add(mainData);


        gameBackground.setLayout(new BorderLayout());
        setting.setLayout(new GridLayout());
        game.setLayout(new GridLayout());

//        setContentPane(gameBackground);
        gameBackground.setBackground(Color.white);
        gameBackground.add(gameField, BorderLayout.CENTER);

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
                mainPanelTop.add(gameBackground);
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
