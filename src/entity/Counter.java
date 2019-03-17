package entity;

import graphics.Texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Counter extends Entity {
    public BufferedImage look1;
    public BufferedImage look2;
    public BufferedImage look3;
    public int number = 0;
    public boolean isRunning = false;

    public Counter(int posX, int posY, boolean isRunning) {
        super(posX, posY, 35, 31);
        setRunning(isRunning);
    }

    @Override
    public abstract void update();

    public void setLooks() {
        for (int i = 1; i <= 3; i++) {
            setLook3(getLook2());
            setLook2(getLook1());
            switch (getSpecificNumber(getNumber(), i)) {
                case 0:
                    setLook1(Texture.NUMBERZERO.getTexture());
                    break;
                case 1:
                    setLook1(Texture.NUMBERONE.getTexture());
                    break;
                case 2:
                    setLook1(Texture.NUMBERTWO.getTexture());
                    break;
                case 3:
                    setLook1(Texture.NUMBERTHREE.getTexture());
                    break;
                case 4:
                    setLook1(Texture.NUMBERFOUR.getTexture());
                    break;
                case 5:
                    setLook1(Texture.NUMBERFIVE.getTexture());
                    break;
                case 6:
                    setLook1(Texture.NUMBERSIX.getTexture());
                    break;
                case 7:
                    setLook1(Texture.NUMBERSEVEN.getTexture());
                    break;
                case 8:
                    setLook1(Texture.NUMBEREIGHT.getTexture());
                    break;
                case 9:
                    setLook1(Texture.NUMBERNINE.getTexture());
                    break;
                default:
                    setLook1(Texture.MINUS.getTexture());
            }
        }

    }

    public int getSpecificNumber(int numbern, int position) {
        if (numbern < 0){
            numbern *= -1;
        }
        for (int i = 1; i < position; i++) {
            numbern /= 10;
        }
        return numbern % 10;
    }

    public void render(Graphics g) {
        if (getNumber() < 0) {
            g.drawImage(Texture.MINUS.getTexture(), getPosX(), getPosY(), null);
        } else {
            g.drawImage(getLook1(), getPosX(), getPosY(), null);
        }
        g.drawImage(getLook2(), getPosX() + getLook2().getWidth() + 1, getPosY(), null);
        g.drawImage(getLook3(), getPosX() + (getLook3().getWidth() * 2) + 2, getPosY(), null);

    }

    public void start() {
        setRunning(true);
    }

    public void stop() {
        setRunning(false);
    }

    public void reset() {
        setNumber(0);
    }

    public BufferedImage getLook1() {
        return look1;
    }

    public void setLook1(BufferedImage look1) {
        this.look1 = look1;
    }

    public BufferedImage getLook2() {
        return look2;
    }

    public void setLook2(BufferedImage look2) {
        this.look2 = look2;
    }

    public BufferedImage getLook3() {
        return look3;
    }

    public void setLook3(BufferedImage look3) {
        this.look3 = look3;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }
}