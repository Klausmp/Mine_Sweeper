package input;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener {

    public static int mouseDraggedX;
    public static int MouseDraggedY;
    public static int mouseMovedX;
    public static int mouseMovedY;
    public static boolean isMouseDragt = false;

    @Override
    public void mouseDragged(MouseEvent e) {
        setMouseDragt(true);
        if (SwingUtilities.isLeftMouseButton(e)) {
            setMouseDraggedX(e.getX());
            setMouseDraggedY(e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        setMouseMovedX(e.getX());
        setMouseMovedY(e.getY());
    }

    public static void resetMouseMotion(){
        MouseMotion.setMouseDraggedX(-1000);
        MouseMotion.setMouseDraggedY(-1000);
        setMouseDragt(false);
    }

    public static int getMouseDraggedX() {
        return mouseDraggedX;
    }

    public static void setMouseDraggedX(int mouseDraggedX) {
        MouseMotion.mouseDraggedX = mouseDraggedX;
    }

    public static int getMouseDraggedY() {
        return MouseDraggedY;
    }

    public static void setMouseDraggedY(int mouseDraggedY) {
        MouseDraggedY = mouseDraggedY;
    }

    public static int getMouseMovedX() {
        return mouseMovedX;
    }

    public static void setMouseMovedX(int mouseMovedX) {
        MouseMotion.mouseMovedX = mouseMovedX;
    }

    public static int getMouseMovedY() {
        return mouseMovedY;
    }

    public static void setMouseMovedY(int mouseMovedY) {
        MouseMotion.mouseMovedY = mouseMovedY;
    }

    public static boolean isMouseDragt() {
        return isMouseDragt;
    }

    public static void setMouseDragt(boolean isMouseDragt) {
        MouseMotion.isMouseDragt = isMouseDragt;
    }
}
