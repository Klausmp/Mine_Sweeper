package util;

import graphics.Window;
import graphics.displays.GamePanel;

import java.awt.*;
/*
 * @author Klausmp
 */

public class Util {
    //public static BufferedImage skin, zero, one, two, three, four, five, six, seven, eight, top, bomb, flag, deadBomb, down;


    //Erkennung der Displayauflösung
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    //Liste in der die Welt gespeichert wird

    //Screen Layer für den Hintergrund (hinterste Ebene)
    public static void drawBackground(Graphics g, Color color) {
        //Setung der Farbe für den Hintergrunf
        g.setColor(color);
        //Zeichnung eines Rechhteckes am Rand des Fensters
        g.drawRect(0, 0, Window.getWindowSizeX(), Window.getWindowSizeY());
        //Zeichnet so viele Lienien vom oberene bis zum unteren ende des Bildes (in der Größe des Fensters)
        for (int i = 0; i <= Window.getWindowSizeX(); i++) {
            g.drawLine(i, 0, i, Window.getWindowSizeY());
        }
    }

    //Entfernung aller Listenelemente und somit Löschung aller Entitys
    public static void clearLists() {

    }

    public static int getTileDisplayPosX(int posX, int wight) {
        return (posX * (wight + 1)) + GamePanel.getWorld().getWorldPosX();
    }

    public static int getTileDisplayPosY(int posY, int height) {
        return (posY * (height + 1)) + GamePanel.getWorld().getWorldPosY();
    }

    public static int getDisplayPosX(int posX, int wight) {
        return (posX * wight) + GamePanel.getWorld().getWorldPosX();
    }

    public static int getDisplayPosY(int posY, int height) {
        return (posY * height) + GamePanel.getWorld().getWorldPosY();
    }

    public static Dimension getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(Dimension screenSize) {
        Util.screenSize = screenSize;
    }
}
