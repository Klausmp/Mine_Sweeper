package entity;

import graphics.Texture;

public class Bomb extends Tile {

    public Bomb(int posX, int posY, int wight, int height) {
        super(posX, posY, wight, height, false);
        setBomb(true);
        setLook(Texture.BOMB.getTexture());
    }

    @Override
    public void update() {
    }
}