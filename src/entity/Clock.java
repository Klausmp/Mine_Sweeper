package entity;

import graphics.Texture;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Clock extends Entity {
    public BufferedImage look1;
    public BufferedImage look2;
    public BufferedImage look3;
    public int time = 0;
    public boolean isClockRunning = true;


    public Clock(int posX, int posY) {
        super(posX, posY, 35, 31);
    }

    @Override
    public void update() {
        if (getTime() >= 999) {
            stop();
        }
        if (isClockRunning()) {
            time++;
        }
        setLooks();
    }

    public void setLooks() {
        for (int i = 1; i <= 3; i++) {
            setLook3(getLook2());
            setLook2(getLook1());
            switch (getSpecificNumber(getTime(), i)) {
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
            }
        }

    }

    public int getSpecificNumber(int numbern, int position) {
        for (int i = 1; i < position; i++) {
            numbern /= 10;
        }
        return numbern % 10;
    }

    public void render(Graphics g) {
        g.drawImage(getLook1(), getPosX(), getPosY(), null);
        g.drawImage(getLook2(), getPosX() + getLook2().getWidth() + 1, getPosY(), null);
        g.drawImage(getLook3(), getPosX() + (getLook3().getWidth() * 2) + 1, getPosY(), null);

    }

    public void start() {
        setClockRunning(true);
    }

    public void stop() {
        setClockRunning(false);
    }

    public void reset() {

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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isClockRunning() {
        return isClockRunning;
    }

    public void setClockRunning(boolean clockRunning) {
        isClockRunning = clockRunning;
    }
}
