package world;

import entity.Bomb;
import entity.Tile;

import java.util.ArrayList;
import java.util.List;

public class World {
    public boolean[][] map;
    public int worldPosX;
    public int worldPosY;
    public int wight;
    public int height;
    public int amountOfBombs;
    public List<Tile> tileList = new ArrayList<Tile>();

    public World(int worldPosX, int worldPosY, int wight, int height, int amountOfBombs) {
        setWorldPosX(worldPosX);
        setWorldPosY(worldPosY);
        setWight(wight);
        setHeight(height);
        setAmountOfBombs(amountOfBombs);
        map = new boolean[wight][height];
        fillMapWithBombs();
        fillTileList();
    }

    public void update() {
        for (Tile tile : getTileList()) {
            tile.update();
        }
    }

    public boolean isGameWon() {
        for (Tile tile : getTileList()) {
            if (!tile.isActivated() && !tile.isBomb()){
                return false;
            }
        }
        return true;
    }
    public boolean isGameOver(){
        for (Tile tile: getTileList()) {
            if (tile.isBomb() && tile.isActivated()){
                return true;
            }
        }
        return false;
    }

    public void fillMapWithBombs() {
        int posX;
        int posY;
        for (int i = 1; i <= getAmountOfBombs(); i++) {
            posX = (int) (Math.random() * wight);
            posY = (int) (Math.random() * height);
            while (map[posX][posY]) {
                posX = (int) (Math.random() * wight);
                posY = (int) (Math.random() * height);
            }
            map[posX][posY] = true;
        }
    }

    public void fillTileList() {
        for (int wight = 0; wight <= getWight() - 1; wight++) {
            for (int height = 0; height <= getHeight() - 1; height++) {
                if (getMap()[wight][height]) {
                    getTileList().add(new Bomb(wight, height, 15, 15));
                } else {
                    getTileList().add(new Tile(wight, height, 15, 15));
                }
            }

        }

    }

    public boolean[][] getMap() {
        return map;
    }

    public void setMap(boolean[][] map) {
        this.map = map;
    }

    public int getWorldPosX() {
        return worldPosX;
    }

    public void setWorldPosX(int worldPosX) {
        this.worldPosX = worldPosX;
    }

    public int getWorldPosY() {
        return worldPosY;
    }

    public void setWorldPosY(int worldPosY) {
        this.worldPosY = worldPosY;
    }

    public int getWight() {
        return wight;
    }

    public void setWight(int wight) {
        this.wight = wight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAmountOfBombs() {
        return amountOfBombs;
    }

    public void setAmountOfBombs(int amountOfBombs) {
        this.amountOfBombs = amountOfBombs;
    }

    public List<Tile> getTileList() {
        return tileList;
    }

    public void setTileList(List<Tile> tileList) {
        this.tileList = tileList;
    }
}
