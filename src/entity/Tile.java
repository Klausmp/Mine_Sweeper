package entity;

import util.Texture;
import util.Util;

import java.awt.*;

public class Tile extends Entity {
    public boolean isFlagt;
    public boolean isBomb;
    public boolean isActiveted;

    public Tile(int posX, int posY, int wight, int height, boolean isFlagt) {
        super(posX, posY, wight, height);
        setLook(Util.getTexture(Texture.ONE));
        setBomb(false);
        setFlagt(isFlagt);
    }

    @Override
    public void update() {
        if (isMouseDraggedOver() && !isActiveted()) {
            setLook(Util.getTexture(Texture.DOWN));
        } else {
            if (!isActiveted()) {
                setLook(Util.getTexture(Texture.TOP));
            }
        }
        if (isKlicked() && ! isActiveted()) {
            setActiveted(true);
            setLook(Util.getTexture(Texture.BOMB));
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getLook(), getPosX(), getPosY(), getWight(), getHeight(), null);
    }

    public boolean isFlagt() {
        return isFlagt;
    }

    public void setFlagt(boolean flagt) {
        isFlagt = flagt;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isActiveted() {
        return isActiveted;
    }

    public void setActiveted(boolean activeted) {
        isActiveted = activeted;
    }
}
