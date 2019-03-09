package entity;

import java.awt.*;

public class Bomb extends Tile {

    public Bomb(int posX, int posY, int wight, int height) {
        super(posX, posY, wight, height, false);
        setBomb(true);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
