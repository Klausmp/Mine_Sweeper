package graphics;

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
    Flag(TextureLoader.getFlag()),
    NUMBERZERO(TextureLoader.getNumberZero()),
    NUMBERONE(TextureLoader.getNumberOne()),
    NUMBERTWO(TextureLoader.getNumberTwo()),
    NUMBERTHREE(TextureLoader.getNumberThree()),
    NUMBERFOUR(TextureLoader.getNumberFour()),
    NUMBERFIVE(TextureLoader.getNumberFive()),
    NUMBERSIX(TextureLoader.getNumberSix()),
    NUMBERSEVEN(TextureLoader.getNumberSeven()),
    NUMBEREIGHT(TextureLoader.getNumberEight()),
    NUMBERNINE(TextureLoader.getNumberNine());

    public BufferedImage texture;

    Texture(BufferedImage texture) {
        setTexture(texture);
    }

    public BufferedImage getTexture() {
        //System.out.println("used");
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public static class TextureLoader {
        public static BufferedImage
                skin, zero, one, two, three, four, five, six, seven, eight,
                numberZero, numberOne, numberTwo, numberThree, numberFour, numberFive, numberSix, numberSeven, numberEight, numberNine,
                top, bomb, flag, deadBomb, down;
        public static final int TILESIZE = 15;
        public static final int CLOCKWIGHT = 11;
        public static final int CLOCKHEIGHT = 21;

        public static void loadTextures() {
            try {
                setSkin(ImageIO.read(Objects.requireNonNull(Window.class.getClassLoader().getResourceAsStream("gfx/skin.png"))));

                setZero(getSkin().getSubimage(0, 0, getTILESIZE(), getTILESIZE()));

                setOne(getSkin().getSubimage(16, 0, getTILESIZE(), getTILESIZE()));

                setTwo(getSkin().getSubimage(32, 0, getTILESIZE(), getTILESIZE()));

                setThree(getSkin().getSubimage(48, 0, getTILESIZE(), getTILESIZE()));

                setFour(getSkin().getSubimage(64, 0, getTILESIZE(), getTILESIZE()));

                setFive(getSkin().getSubimage(80, 0, getTILESIZE(), getTILESIZE()));

                setSix(getSkin().getSubimage(96, 0, getTILESIZE(), getTILESIZE()));

                setSeven(getSkin().getSubimage(112, 0, getTILESIZE(), getTILESIZE()));

                setEight(getSkin().getSubimage(128, 0, getTILESIZE(), getTILESIZE()));

                setTop(getSkin().getSubimage(0, 16, getTILESIZE(), getTILESIZE()));

                setDown(getSkin().getSubimage(16, 16, getTILESIZE(), getTILESIZE()));

                setBomb(getSkin().getSubimage(32, 16, getTILESIZE(), getTILESIZE()));

                setDeadBomb(getSkin().getSubimage(80, 16, getTILESIZE(), getTILESIZE()));

                setFlag(getSkin().getSubimage(48, 16, getTILESIZE(), getTILESIZE()));

                setNumberZero(getSkin().getSubimage(0, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberOne(getSkin().getSubimage(12, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberTwo(getSkin().getSubimage(24, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberThree(getSkin().getSubimage(36, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberFour(getSkin().getSubimage(48, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberFive(getSkin().getSubimage(60, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberSix(getSkin().getSubimage(72, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberSeven(getSkin().getSubimage(84, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberEight(getSkin().getSubimage(96, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

                setNumberNine(getSkin().getSubimage(108, 33, getCLOCKWIGHT(), getCLOCKHEIGHT()));

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

        public static BufferedImage getNumberZero() {
            return numberZero;
        }

        public static void setNumberZero(BufferedImage numberZero) {
            TextureLoader.numberZero = numberZero;
        }

        public static BufferedImage getNumberOne() {
            return numberOne;
        }

        public static void setNumberOne(BufferedImage numberOne) {
            TextureLoader.numberOne = numberOne;
        }

        public static BufferedImage getNumberTwo() {
            return numberTwo;
        }

        public static void setNumberTwo(BufferedImage numberTwo) {
            TextureLoader.numberTwo = numberTwo;
        }

        public static BufferedImage getNumberThree() {
            return numberThree;
        }

        public static void setNumberThree(BufferedImage numberThree) {
            TextureLoader.numberThree = numberThree;
        }

        public static BufferedImage getNumberFour() {
            return numberFour;
        }

        public static void setNumberFour(BufferedImage numberFour) {
            TextureLoader.numberFour = numberFour;
        }

        public static BufferedImage getNumberFive() {
            return numberFive;
        }

        public static void setNumberFive(BufferedImage numberFive) {
            TextureLoader.numberFive = numberFive;
        }

        public static BufferedImage getNumberSix() {
            return numberSix;
        }

        public static void setNumberSix(BufferedImage numberSix) {
            TextureLoader.numberSix = numberSix;
        }

        public static BufferedImage getNumberSeven() {
            return numberSeven;
        }

        public static void setNumberSeven(BufferedImage numberSeven) {
            TextureLoader.numberSeven = numberSeven;
        }

        public static BufferedImage getNumberEight() {
            return numberEight;
        }

        public static void setNumberEight(BufferedImage numberEight) {
            TextureLoader.numberEight = numberEight;
        }

        public static BufferedImage getNumberNine() {
            return numberNine;
        }

        public static void setNumberNine(BufferedImage numberNine) {
            TextureLoader.numberNine = numberNine;
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

        public static int getTILESIZE() {
            return TILESIZE;
        }

        public static int getCLOCKWIGHT() {
            return CLOCKWIGHT;
        }

        public static int getCLOCKHEIGHT() {
            return CLOCKHEIGHT;
        }
    }
}