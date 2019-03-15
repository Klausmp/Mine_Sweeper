package entity;

import graphics.displays.GamePanel;

public class BombCounter extends Counter {
    public BombCounter(int posX, int posY, boolean isRunning) {
        super(posX, posY, isRunning);
    }

    @Override
    public void update() {
        setNumber(getAmountofBombs());
        setLooks();
    }

    public int getAmountofBombs() {
        int result = 0;
        for (Tile tile : GamePanel.getWorld().getTileList()) {
            if (tile.isBomb()) {
                result++;
            }
            if (tile.isFlagged()){
                result--;
            }
        }

        return result;
    }
}