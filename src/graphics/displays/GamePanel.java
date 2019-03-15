package graphics.displays;

import entity.BombCounter;
import entity.Timer;
import entity.Tile;
import input.Mouse;
import input.MouseMotion;
import util.Util;
import world.World;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GamePanel extends JPanel {
    public static Screen screen = new Screen();
    public static List<World> worldList = new ArrayList<World>();
    public static Timer timer = new Timer(200, 200, false);
    public static BombCounter bombCounter = new BombCounter(180, 100, true);

    public GamePanel() {
        screen.setVisible(true);
        setLayout(new BorderLayout());
        add(screen, BorderLayout.CENTER);
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMotion());
        worldList.add(new World(10, 10, 10, 10, 10));
    }

    public static void update() {
        Objects.requireNonNull(getWorld()).update();
        if (isGameStarted()){
            timer.start();
        } else {
            timer.stop();
        }
        timer.update();
        bombCounter.update();
    }

    static class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBackground(g);
            drawGame(g);
        }

        public void drawBackground(Graphics g) {
            Util.drawBackground(g, Color.BLACK);
        }

        public void drawGame(Graphics g) {
            for (Tile tile : getWorld().getTileList()) {
                g.drawImage(tile.getLook(), Util.getTileDisplayPosX(tile.getPosX(), tile.getWight()), Util.getTileDisplayPosY(tile.getPosY(), tile.getHeight()), tile.getWight(), tile.getHeight(), null);
            }
            timer.render(g);
            bombCounter.render(g);
        }
    }

    public static World getWorld() {
        for (World world : getWorldList()) {
            return world;
        }
        System.out.println("ERROR: KEINE WOLRD VORHANDEN (GamePanel.getWolrd)");
        return null;
    }

    public static boolean isGameStarted(){
        for (Tile tile: getWorld().getTileList()){
            if (tile.isActivated() && !getWorld().isGameWon() && !getWorld().isGameOver()){
                return true;
            }
        }
        return false;
    }

    public void setScreenBounds(int wight, int height) {
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

    public static List<World> getWorldList() {
        return worldList;
    }

    public static void setWorldList(List<World> worldList) {
        GamePanel.worldList = worldList;
    }

}
