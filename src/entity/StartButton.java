package entity;

import graphics.Texture;
import graphics.displays.GamePanel;

import java.awt.*;
import java.util.Objects;

public class StartButton extends Entity {
    public StartButton(int posX, int posY) {
        super(posX, posY, Texture.TextureLoader.getSMILYSIZE(), Texture.TextureLoader.getSMILYSIZE());
    }

    public void render(Graphics g){
        g.drawImage(Texture.GRINSMILY.getTexture(), getPosX(), getPosY(), null);
    }

    @Override
    public void update() {
        if (isLeftKlicked()){
            Objects.requireNonNull(GamePanel.getWorld()).setDead(true);
            GamePanel.getWorldList().clear();
        }

    }
}
