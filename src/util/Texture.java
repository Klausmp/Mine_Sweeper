package util;

public enum Texture {
    BLANK (0, 0),
    ONE (16, 0),
    TWO (32, 0),
    Three (48, 0),
    FOUR (64, 0),
    FIVR (80, 0),
    SIX (96, 0),
    SEVEN (112, 0),
    EIGHT (128, 0),
    TOP (0, 16),
    DOWN(16, 16),
    BOMB (32, 16),
    DEADBOMB (80, 16),
    FLAGK (48, 16);

    int posX;
    int posY;

    Texture(int posX, int posY) {
        setPosX(posX);
        setPosY(posY);
    }

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
}
