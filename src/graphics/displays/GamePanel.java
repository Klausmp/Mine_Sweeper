package graphics.displays;

import entity.Tile;
import input.Mouse;
import input.MouseMotion;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public static Screen screen = new Screen();
    public static Tile tile = new Tile(50, 50, 15, 15, false);

    public GamePanel() {
        screen.setBounds(0, 0, 400, 400);
        screen.setVisible(true);
        setLayout(new BorderLayout());
        add(screen, BorderLayout.CENTER);
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMotion());
    }

    public static void update() {
        tile.update();
    }

    static class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBackground(g);
            drawGame(g);
        }

        public void drawBackground(Graphics g) {
            g.drawImage(tile.getLook(), tile.getPosX(), tile.getPosY(), tile.getWight(), tile.getHeight(), null) ;
        }

        public void drawGame(Graphics g) {

        }

    }

    public void setScreenBounds(int wight, int height){
        getScreen().setBounds(0, 0, wight, height);
    }

    public static void updateScreen() {
        screen.repaint();
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        GamePanel.screen = screen;
    }
}
