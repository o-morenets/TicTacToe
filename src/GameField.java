import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameField extends JPanel {
    private int width;
    private int height;
    private final int SIZE = 3;
    private int cellWidth;
    private int cellHeight;
    private char [][] map;
    private boolean moveX = true;
    int clX;
    int clY;

    public GameField() {
        setOpaque(false);
        map = new char[SIZE][SIZE];

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                clX = e.getX() / cellWidth;
                clY = e.getY() / cellHeight;
                System.out.println((clX + 1) + " " + (clY + 1));
                if (map[clX][clY] == 0) { // only if empty cell
                    if (moveX) {
                        map[clX][clY] = 'x';
                    } else {
                        map[clX][clY] = 'o';
                    }
                    moveX = !moveX;
                    repaint();
                }
                if (isMapFull()){
                    System.out.println("ничья");
                }
                if (checkWin(map[clX][clY])){
                    System.out.println("кто-то выйграл");
                }
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
            myPictureKrestic = ImageIO.read(new File("pictures/cross.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedImage myPictureNolik = null;
        try {
            myPictureNolik = ImageIO.read(new File("pictures/zero.png"));
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
                if ((map[i][j] == 'x')) {
                    g2d.drawImage(myPictureKrestic, i * cellWidth, j * cellHeight, cellWidth, cellHeight, null);
                } else if ((map[i][j] == 'o')) {
                    g2d.drawImage(myPictureNolik, i * cellWidth, j * cellHeight, cellWidth, cellHeight, null);
                }
            }
        }
    }

    public boolean isMapFull(){
        for(int i=0; i < SIZE; i++){
            for(int j=0;j <SIZE; j++){
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public boolean checkWin (char symb) {

        if(map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) return true;
        if(map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) return true;
        if(map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) return true;

        if(map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) return true;

        if(map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) return true;
        if(map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) return true;

        if(map[2][0] == symb && map[1][1] == symb && map[0][2] == symb) return true;
        if(map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) return true;

        return false;
    }
}