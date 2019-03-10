package entity;

import input.Mouse;
import input.MouseMotion;
import util.Util;

import java.awt.image.BufferedImage;

public abstract class Entity {
    public int posX;
    public int posY;
    public int wight;
    public int height;
    public BufferedImage look;

    public Entity(int posX, int posY, int wight, int height) {
        this.posX = posX;
        this.posY = posY;
        this.wight = wight;
        this.height = height;
    }

    public boolean isMouseDraggedOver() {
        return MouseMotion.getMouseDraggedX() >= Util.getTileDisplayPosX(getPosX(), getWight()) && MouseMotion.getMouseDraggedX() <= Util.getTileDisplayPosX(getPosX(), getWight()) + getWight() && MouseMotion.getMouseDraggedY() >= Util.getTileDisplayPosY(getPosY(), getHeight()) && MouseMotion.getMouseDraggedY() <= Util.getTileDisplayPosY(getPosY(), getHeight()) + getHeight();
    }

    public boolean isKlicked(){
        if (Mouse.getMouseReleasedLeftX() >= Util.getTileDisplayPosX(getPosX(), getWight()) && Mouse.getMouseReleasedLeftX() <= Util.getTileDisplayPosX(getPosX(), getWight()) + getWight() && Mouse.getMouseReleasedLeftY() >= Util.getTileDisplayPosY(getPosY(), getHeight()) && Mouse.getMouseReleasedLeftY() <= Util.getTileDisplayPosY(getPosY(), getHeight()) + getHeight()){
            Mouse.resetMouse();
            return true;
        } else {
            return false;
        }
    }



    public abstract void update();

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BufferedImage getLook() {
        return look;
    }

    public void setLook(BufferedImage look) {
        this.look = look;
    }
}
