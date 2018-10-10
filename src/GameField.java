import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

enum Move {
    moveX, moveO;
}

public class GameField extends JPanel {
    private int width;
    private int height;
    private final int SIZE = 3;
    private int cellWidth;
    private int cellHeight;
    private char [][] map;
    private static ViewState move;

    public GameField() {
        setOpaque(false);
        map = new char[SIZE][SIZE];

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int clX = e.getX()/cellWidth;
                int clY = e.getY()/cellHeight;
                System.out.println((clX + 1) + " " + (clY + 1));
                map[clX][clY] = '*';
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        width = getWidth();
        height = getHeight();
        cellHeight = height/SIZE;
        cellWidth = width/SIZE;

        BufferedImage myPictureKrestic = null;
        try {
            myPictureKrestic = ImageIO.read(new File("pictures/krestic.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage myPictureNolik = null;
        try {
            myPictureNolik = ImageIO.read(new File("pictures/nolik.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < SIZE; i++) {
            g2d.setColor(Color.black);
            g2d.drawLine(0, i*cellHeight, width, i*cellHeight);
            g2d.drawLine(i*cellWidth,0,i*cellWidth,height);
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == '*') {
                    g2d.drawImage(myPictureKrestic, i*cellWidth, j*cellHeight, cellWidth,cellHeight, null);
                }
            }
        }
    }

    public static void firstMove(Move state) {

        switch (state) {
            case moveX:

                break;
            case moveO:

                break;
            default:
                System.out.println("UNKNOWN STATE!");
                break;
        }
    }

}