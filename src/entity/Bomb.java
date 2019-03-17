package entity;

import graphics.Texture;
import graphics.displays.GamePanel;

import java.util.Objects;

public class Bomb extends Tile {
    public boolean gameEnd = false;

    public Bomb(int posX, int posY, int wight, int height) {
        super(posX, posY, wight, height, false);
        setBomb(true);
    }

    @Override
    public void update() {
        if (!Objects.requireNonNull(GamePanel.getWorld()).isGameOver()) {
            modsDragsOver();
            gotLeftKlicked();
            gotRightKlicked();
        } else {
            if (!isGameEnd()) {
                endOfGame();
            }
        }
    }

    public void endOfGame() {
        setGameEnd(true);
        if (isActivated()) {
            setLook(Texture.DEADBOMB.getTexture());
        } else {
            setLook(Texture.BOMB.getTexture());
        }
    }

    public boolean isGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(boolean gameEnd) {
        this.gameEnd = gameEnd;
    }
}