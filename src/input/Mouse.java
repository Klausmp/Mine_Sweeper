package input;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Klausmp
 */

public class Mouse implements MouseListener {
    public static int mouseReleasedLeftX = -100;
    public static int mouseReleasedLeftY = -100;
    public static int mouseReleasedRightX = -100;
    public static int mouseReleasedRightY = -100;

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)){
            setMouseReleasedRightX(e.getX());
            setMouseReleasedRightY(e.getY());
        }
        if (SwingUtilities.isLeftMouseButton(e)){
            setMouseReleasedLeftX(e.getX());
            setMouseReleasedLeftY(e.getY());
        }
        MouseMotion.resetMouseMotion();
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println(e.getX() + " " + e.getY());
    }

    public static void resetMouse() {
        setMouseReleasedLeftX(-1000);
        setMouseReleasedLeftY(-1000);
        setMouseReleasedRightX(-1000);
        setMouseReleasedRightY(-1000);
    }

    public static int getMouseReleasedLeftX() {
        return mouseReleasedLeftX;
    }

    public static void setMouseReleasedLeftX(int mouseReleasedLeftX) {
        Mouse.mouseReleasedLeftX = mouseReleasedLeftX;
    }

    public static int getMouseReleasedLeftY() {
        return mouseReleasedLeftY;
    }

    public static void setMouseReleasedLeftY(int mouseReleasedLeftY) {
        Mouse.mouseReleasedLeftY = mouseReleasedLeftY;
    }

    public static int getMouseReleasedRightX() {
        return mouseReleasedRightX;
    }

    public static void setMouseReleasedRightX(int mouseReleasedRightX) {
        Mouse.mouseReleasedRightX = mouseReleasedRightX;
    }

    public static int getMouseReleasedRightY() {
        return mouseReleasedRightY;
    }

    public static void setMouseReleasedRightY(int mouseReleasedRightY) {
        Mouse.mouseReleasedRightY = mouseReleasedRightY;
    }
}