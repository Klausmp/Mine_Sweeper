package entity;

import graphics.Texture;
import graphics.displays.GamePanel;
import input.MouseMotion;

import java.awt.*;
import java.util.Objects;

public class StartButton extends Entity {
    public StartButton(int posX, int posY) {
        super(posX, posY, Texture.TextureLoader.getSMILYSIZE(), Texture.TextureLoader.getSMILYSIZE());
    }

    public void render(Graphics g) {
        if (!MouseMotion.isMouseDragt() && !Objects.requireNonNull(GamePanel.getWorld()).isGameOver() && !GamePanel.getWorld().isGameWon()) {
            g.drawImage(Texture.GRINSMILEY.getTexture(), getPosX(), getPosY(), null);
        }
        if (MouseMotion.isMouseDragt()) {
            g.drawImage(Texture.OSMILEY.getTexture(), getPosX(), getPosY(), null);
        }
        if (Objects.requireNonNull(GamePanel.getWorld()).isGameOver()){
            g.drawImage(Texture.DEADSMILEY.getTexture(), getPosX(), getPosY(), null);
        }
        if (GamePanel.getWorld().isGameWon()){
            g.drawImage(Texture.LAUGHTSMILEY.getTexture(), getPosX(), getPosY(), null);
        }
    }

    @Override
    public void update() {
        if (isLeftKlicked()) {
            Objects.requireNonNull(GamePanel.getWorld()).setDead(true);
            GamePanel.getWorldList().clear();
        }

    }
}
