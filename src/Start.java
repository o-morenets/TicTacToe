import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    static String text;
    private JPanel gameField;

    public Start(){
        gameField = new GameField();

        setSize(500, 620);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("крестики нолики");

        JPanel fieldWelcome = new JPanel();                                           //поле с приветствием
        JPanel fieldSetting = new JPanel();                                          //поле с настройками для игры
        JPanel background = new JPanel();                                          //

        JButton enter = new JButton("Запомнить");
        JButton start = new JButton("Играть");                                //для применения настроек
        JButton newGame = new JButton("Начать заново");                       //новая игра

        JTextField textName = new JTextField("Имя",20);             //главный игрок
        JTextField textName2 = new JTextField("Имя соперника",20); //имя соперника
        JLabel textWelcome = new JLabel("Добро пожаловать," +
                " пожалуйста вветите Ваше имя");                                         //Lable приветствия в окне fieldWelcome
        JLabel imageLabel = new JLabel(new ImageIcon("pictures/cross.png"));    //фоновое изображение для Welcome
        JLabel imageLabel2 = new JLabel(new ImageIcon("pictures/zero.png"));    //фоновое изображение для Setting
        JLabel textSetting = new JLabel("здравствуйте, выберите как вы желаете играть");    //приветствие в окне fieldSetting
        JRadioButton AI = new JRadioButton("с компьютером");                                //
        JRadioButton friend = new JRadioButton("с другом");                                 //

        //настройки цвета и размера
        textWelcome.setFont(new Font("Serif", Font.PLAIN, 22));
        enter.setPreferredSize(new Dimension(1,40));
        enter.setBackground(new Color(255, 251, 90));
        start.setPreferredSize(new Dimension(1,40));
        start.setBackground(new Color(255, 251, 90));
        newGame.setPreferredSize(new Dimension(1,40));
        newGame.setBackground(new Color(255, 251, 90));
        fieldWelcome.setBackground(Color.orange);
        fieldSetting.setBackground(Color.orange);
        textName.setBackground(new Color(248,255, 87));
        textName2.setBackground(new Color(248,255, 87));
        textSetting.setFont(new Font("Serif", Font.PLAIN, 20));
        AI.setFont(new Font("Serif", Font.PLAIN, 18));
        AI.setBackground(Color.orange);
        friend.setFont(new Font("Serif", Font.PLAIN, 18));
        friend.setBackground(Color.orange);
        friend.setSelected(true);
        background.setBackground(Color.orange);

        //добавление всех элементов
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(AI);
        buttonGroup.add(friend);
        add(enter, BorderLayout.SOUTH);
        fieldWelcome.add(textWelcome);
        fieldWelcome.add(textName);
        fieldWelcome.add(imageLabel);
        fieldSetting.add(textSetting);
        fieldSetting.add(AI);
        fieldSetting.add(friend);
        fieldSetting.add(textName2);
        textName2.setVisible(false);
        fieldSetting.add(imageLabel2);
        add(fieldWelcome);

        if (friend.isSelected()) {          //временный костыль
            textName2.setVisible(true);
        } else return;

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldWelcome.setVisible(false);
                enter.setVisible(false);
                add(fieldSetting);
                fieldSetting.setVisible(true);
                add(start, BorderLayout.SOUTH);
                text = textName.getText();                              //запись имени в переменную text,
                //для дальнейшего его использования
            }
        });

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(text + " " + textName.getText());    //вывел информацию в консоль для проверки,
                //что запись действительно происходит
                fieldSetting.setVisible(false);
                start.setVisible(false);
                add(newGame, BorderLayout.SOUTH);
                gameField = new GameField();
                add(gameField);
            }
        });

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(gameField);
                gameField = new GameField();
                add(gameField);
                gameField.revalidate();
            }
        });

        setVisible(true);
    }
}