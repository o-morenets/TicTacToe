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

        JPanel top = new JPanel();
        settingField.add(top, BorderLayout.NORTH);
        top.setPreferredSize(new Dimension(1, 50));
        top.setBackground(Color.cyan);

        JPanel neTop = new JPanel();
        settingField.add(neTop, BorderLayout.SOUTH);
        neTop.setPreferredSize(new Dimension(1,250));
        neTop.setBackground(Color.orange);

        JPanel center = new JPanel();
        settingField.add(center, BorderLayout.CENTER);
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

        JPanel panelOne = new JPanel();
        JPanel panelTwo = new JPanel();

        panelOne.setBackground(Color.white);
        panelTwo.setBackground(new Color(31,255, 245));
        center.add(panelOne);
        center.add(panelTwo);

        JLabel settingOne = new JLabel("выберите с кем играть:");
        panelOne.add(settingOne);

        JRadioButton AI = new JRadioButton("с компуктером");
        panelOne.add(AI);
        JRadioButton friend = new JRadioButton("с другом");
        panelOne.add(friend);
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(AI);
        bg2.add(friend);

        JLabel settingTwo = new JLabel("выберите с кем играть:");
        panelTwo.add(settingTwo);

        JRadioButton easy = new JRadioButton("легкий");
        panelTwo.add(easy);
        JRadioButton hard = new JRadioButton("сложный");
        panelTwo.add(hard);
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(easy);
        bg1.add(hard);


        gameBackground.setLayout(new BorderLayout());
        setting.setLayout(new GridLayout());
        game.setLayout(new GridLayout());

//        setContentPane(gameBackground);
        gameBackground.setBackground(new Color(255, 246, 166));
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
