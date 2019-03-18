package graphics;

import graphics.displays.GamePanel;
import input.Keyboard;
import main.Main;
import util.Util;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Klausmp
 */

public class Window {
    public static int windowSizeX;
    public static int windowSizeY;
    public static GamePanel gamePanel = new GamePanel();
    public static JFrame window = new JFrame();
    public static List<JPanel> panelList = new ArrayList<JPanel>();

    public Window() {
        /*Configurations*/

        //Breite und Höhe der Texturen

        //Windowsize ETC

        //Window

        getWindow().setTitle(Main.gameTitle);
        getWindow().setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getWindow().setLocationRelativeTo(null);
        getWindow().setResizable(false);
        getWindow().setLayout(new BorderLayout());
        getWindow().add(getGamePanel(), BorderLayout.CENTER);
        getWindow().addKeyListener(new Keyboard());
        getWindow().setVisible(true);
        resizeWindow(183, 193);
        /*Buttons*/

    }

    public static void resizeWindow(int wight, int height) {
        Dimension dimension = new Dimension(wight, height);
        if (Util.getScreenSize().getWidth() == 1360 && Util.getScreenSize().getHeight() == 768) {
            wight = (wight + 2) - 10;
            height = (height + 2) + 12;
        }

        if (Util.getScreenSize().getWidth() == 1920 && Util.getScreenSize().getHeight() == 1080) {
            wight = (wight + 2);
            height = (height + 2) + 23;
        }

        if (Util.getScreenSize().getWidth() == 1280 && Util.getScreenSize().getHeight() == 720) {
            wight = (wight + 2);
            height = (height + 2) + 23;
        }
        getWindow().setSize(wight, height);
        getGamePanel().setSize(wight, height);

        if (System.getProperty("os.name").toLowerCase().equals("linux")) {
            getWindow().setSize(wight, (int) (height - (getWindow().getLocationOnScreen().getY() - getGamePanel().getLocationOnScreen().getY())));
        }
        setWindowSizeX(wight);
        setWindowSizeY(height);
    }

    public static int getWindowSizeX() {
        return windowSizeX;
    }

    public static void setWindowSizeX(int windowSizeX) {
        Window.windowSizeX = windowSizeX;
    }

    public static int getWindowSizeY() {
        return windowSizeY;
    }

    public static void setWindowSizeY(int windowSizeY) {
        Window.windowSizeY = windowSizeY;
    }

    public static JFrame getWindow() {
        return window;
    }

    public static void setWindow(JFrame window) {
        Window.window = window;
    }

    public static List<JPanel> getPanelList() {
        return panelList;
    }

    public static void setPanelList(List<JPanel> panelList) {
        Window.panelList = panelList;
    }

    public static GamePanel getGamePanel() {
        return gamePanel;
    }

    public static void setGamePanel(GamePanel gamePanel) {
        Window.gamePanel = gamePanel;
    }

}