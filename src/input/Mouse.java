package input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @author Klausmp
 */

public class Mouse implements MouseListener {
    public static int mouseReleasedX = -100;
    public static int mouseReleasedY = -100;

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
        setMouseReleasedX(e.getX());
        setMouseReleasedY(e.getY());
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
        setMouseReleasedX(-1000);
        setMouseReleasedY(-1000);
    }

    public static int getMousePosX() {
        return mouseReleasedX;
    }

    public static void setMousePosX(int mousePosX) {
        Mouse.mouseReleasedX = mousePosX;
    }

    public static int getMouseReleasedX() {
        return mouseReleasedX;
    }

    public static void setMouseReleasedX(int mouseReleasedX) {
        Mouse.mouseReleasedX = mouseReleasedX;
    }

    public static int getMouseReleasedY() {
        return mouseReleasedY;
    }

    public static void setMouseReleasedY(int mouseReleasedY) {
        Mouse.mouseReleasedY = mouseReleasedY;
    }
}