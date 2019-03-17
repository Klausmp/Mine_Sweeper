package graphics.displays;

import entity.BombCounter;
import entity.StartButton;
import entity.Timer;
import entity.Tile;
import input.Mouse;
import input.MouseMotion;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
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
    public static Timer timer = new Timer(118, 7, false);
    public static BombCounter bombCounter = new BombCounter(26, 7, true);
    public static StartButton startButton = new StartButton(77, 5);

    public GamePanel() {
        screen.setVisible(true);
        setLayout(new BorderLayout());
        add(screen, BorderLayout.CENTER);
        addMouseListener(new Mouse());
        addMouseMotionListener(new MouseMotion());
        worldList.add(new World(26, 36, 8, 8, 10));
    }

    public static void update() {
        getStartButton().update();
        if (getWorldList().isEmpty()){
            worldList.add(new World(26, 36, 8, 8, 10));
            getTimer().reset();
            getBombCounter().reset();
        }
        Objects.requireNonNull(getWorld()).update();
        if (isGameStarted()){
            getTimer().start();
        } else {
            getTimer().stop();
        }
        getTimer().update();
        getBombCounter().update();
    }

    @Nullable
    public static World getWorld() {
        for (World world : getWorldList()) {
            return world;
        }
        System.out.println("ERROR: KEINE WOLRD VORHANDEN (GamePanel.getWolrd)");
        return null;
    }

    public static boolean isGameStarted(){
        for (Tile tile: Objects.requireNonNull(getWorld()).getTileList()){
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

    static class Screen extends JLabel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawBackground(g);
            drawGame(g);
        }

        public void drawBackground(Graphics g) {
            Util.drawBackground(g, new Color(26, 38, 42, 255));
        }

        public void drawGame(Graphics g) {
            for (Tile tile : Objects.requireNonNull(getWorld()).getTileList()) {
                g.drawImage(tile.getLook(), Util.getTileDisplayPosX(tile.getPosX(), tile.getWight()), Util.getTileDisplayPosY(tile.getPosY(), tile.getHeight()), tile.getWight(), tile.getHeight(), null);
            }
            getTimer().render(g);
            getBombCounter().render(g);
            getStartButton().render(g);
        }
    }

    @Contract(pure = true)
    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        GamePanel.screen = screen;
    }

    @Contract(pure = true)
    public static List<World> getWorldList() {
        return worldList;
    }

    public static void setWorldList(List<World> worldList) {
        GamePanel.worldList = worldList;
    }

    public static Timer getTimer() {
        return timer;
    }

    public static void setTimer(Timer timer) {
        GamePanel.timer = timer;
    }

    public static BombCounter getBombCounter() {
        return bombCounter;
    }

    public static void setBombCounter(BombCounter bombCounter) {
        GamePanel.bombCounter = bombCounter;
    }

    public static StartButton getStartButton() {
        return startButton;
    }

    public static void setStartButton(StartButton startButton) {
        GamePanel.startButton = startButton;
    }
}
