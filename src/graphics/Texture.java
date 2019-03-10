package graphics;

import graphics.Window;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public enum Texture {
    ZERO(TextureLoader.getZero()),
    ONE(TextureLoader.getOne()),
    TWO(TextureLoader.getTwo()),
    THREE(TextureLoader.getThree()),
    FOUR(TextureLoader.getFour()),
    FIVR(TextureLoader.getFive()),
    SIX(TextureLoader.getSix()),
    SEVEN(TextureLoader.getSeven()),
    EIGHT(TextureLoader.getEight()),
    TOP(TextureLoader.getTop()),
    DOWN(TextureLoader.getDown()),
    BOMB(TextureLoader.getBomb()),
    DEADBOMB(TextureLoader.getDeadBomb()),
    Flag(TextureLoader.getFlag());

    public BufferedImage texture;

    Texture(BufferedImage texture) {
        setTexture(texture);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public static class TextureLoader {
        public static BufferedImage skin, zero, one, two, three, four, five, six, seven, eight, top, bomb, flag, deadBomb, down;

        public static void loadTextures() {
            try {
                setSkin(ImageIO.read(Objects.requireNonNull(Window.class.getClassLoader().getResourceAsStream("gfx/skin.png"))));

                setZero(getSkin().getSubimage(0, 0, 15, 15));

                setOne(getSkin().getSubimage(16, 0, 15, 15));

                setTwo(getSkin().getSubimage(32, 0, 15, 15));

                setThree(getSkin().getSubimage(48, 0, 15, 15));

                setFour(getSkin().getSubimage(64, 0, 15, 15));

                setFive(getSkin().getSubimage(80, 0, 15, 15));

                setSix(getSkin().getSubimage(96, 0, 15, 15));

                setSeven(getSkin().getSubimage(112, 0, 15, 15));

                setEight(getSkin().getSubimage(128, 0, 15, 15));

                setTop(getSkin().getSubimage(0, 16, 15, 15));

                setDown(getSkin().getSubimage(16, 16, 15, 15));

                setBomb(getSkin().getSubimage(32, 16, 15, 15));

                setDeadBomb(getSkin().getSubimage(80, 16, 15, 15));

                setFlag(getSkin().getSubimage(48, 16, 15, 15));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static BufferedImage getSkin() {
            return skin;
        }

        public static void setSkin(BufferedImage skin) {
            TextureLoader.skin = skin;
        }

        public static BufferedImage getZero() {
            return zero;
        }

        public static void setZero(BufferedImage zero) {
            TextureLoader.zero = zero;
        }

        public static BufferedImage getOne() {
            return one;
        }

        public static void setOne(BufferedImage one) {
            TextureLoader.one = one;
        }

        public static BufferedImage getTwo() {
            return two;
        }

        public static void setTwo(BufferedImage two) {
            TextureLoader.two = two;
        }

        public static BufferedImage getThree() {
            return three;
        }

        public static void setThree(BufferedImage three) {
            TextureLoader.three = three;
        }

        public static BufferedImage getFour() {
            return four;
        }

        public static void setFour(BufferedImage four) {
            TextureLoader.four = four;
        }

        public static BufferedImage getFive() {
            return five;
        }

        public static void setFive(BufferedImage five) {
            TextureLoader.five = five;
        }

        public static BufferedImage getSix() {
            return six;
        }

        public static void setSix(BufferedImage six) {
            TextureLoader.six = six;
        }

        public static BufferedImage getSeven() {
            return seven;
        }

        public static void setSeven(BufferedImage seven) {
            TextureLoader.seven = seven;
        }

        public static BufferedImage getEight() {
            return eight;
        }

        public static void setEight(BufferedImage eight) {
            TextureLoader.eight = eight;
        }

        public static BufferedImage getTop() {
            return top;
        }

        public static void setTop(BufferedImage top) {
            TextureLoader.top = top;
        }

        public static BufferedImage getBomb() {
            return bomb;
        }

        public static void setBomb(BufferedImage bomb) {
            TextureLoader.bomb = bomb;
        }

        public static BufferedImage getFlag() {
            return flag;
        }

        public static void setFlag(BufferedImage flag) {
            TextureLoader.flag = flag;
        }

        public static BufferedImage getDeadBomb() {
            return deadBomb;
        }

        public static void setDeadBomb(BufferedImage deadBomb) {
            TextureLoader.deadBomb = deadBomb;
        }

        public static BufferedImage getDown() {
            return down;
        }

        public static void setDown(BufferedImage down) {
            TextureLoader.down = down;
        }
    }
}



/*
ZERO(0, 0),
    ONE (16, 0),
    TWO (32, 0),
    THREE(48, 0),
    FOUR (64, 0),
    FIVR (80, 0),
    SIX (96, 0),
    SEVEN (112, 0),
    EIGHT (128, 0),
    TOP (0, 16),
    DOWN(16, 16),
    BOMB (32, 16),
    DEADBOMB (80, 16),
    Flag(48, 16);
 */