import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

enum ViewState {
    START_STATE, GAME_STATE;
}

class MyWindow extends JFrame{
    private static ViewState viewState;
    private static JPanel mainPanelBottom;
    private static JPanel mainPanelTop;
    private static JPanel setting;
    private static JPanel game;
    private static JPanel gameBackground;
    private static JPanel settingField;
    private static JFrame frame;
    private int width;
    private int height;
    private final int SIZE = 3;
    private int cellWidth;
    private int cellHeight;
    private char[][] map;
//    private static JPanel gameField;

    public MyWindow(){
        frame = new JFrame();
        mainPanelBottom = new JPanel();
        mainPanelTop = new JPanel();
        setting = new BottomPanelSetting();
        game = new BottomPanelGame();
        gameBackground = new GameBackground();
        settingField = new SettingField();
//        gameField = new GameField();

        frame.setSize(600, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainPanelBottom.setLayout(new BorderLayout());

        mainPanelBottom.add(game, BorderLayout.SOUTH);
        mainPanelBottom.add(setting, BorderLayout.SOUTH) ;
        mainPanelTop.add(gameBackground, BorderLayout.CENTER);
        mainPanelTop.add(settingField, BorderLayout.CENTER);

        gameBackground.setPreferredSize(new Dimension(600,660));
        settingField.setPreferredSize(new Dimension(600,660));
        game.setPreferredSize(new Dimension(1,40));
        setting.setPreferredSize(new Dimension(1,40));
        settingField.setBackground(new Color(233,245,180));

        settingField.setLayout(new BorderLayout());
        gameBackground.setLayout(new BorderLayout());
        setting.setLayout(new GridLayout());
        game.setLayout(new GridLayout());

        BufferedImage myPicture = null;
        try {
            myPicture = ImageIO.read(new File("pictures/field.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        gameBackground.add(picLabel);

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
