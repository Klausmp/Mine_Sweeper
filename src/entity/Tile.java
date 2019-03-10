package entity;

import graphics.displays.GamePanel;
import graphics.Texture;

public class Tile extends Entity {
    public int bombsAround;
    public boolean isFlaggt;
    public boolean isBomb;
    public boolean isActivated;
    public boolean isRemoteActivated;
    public boolean isFirstUpdate = true;

    public Tile(int posX, int posY, int wight, int height, boolean isFlaggt) {
        super(posX, posY, wight, height);
        setLook(Texture.TOP.getTexture());
        setBomb(false);
        setFlaggt(isFlaggt);
    }

    public Tile(int posX, int posY, int wight, int height) {
        super(posX, posY, wight, height);
        setLook(Texture.TOP.getTexture());
        setBomb(false);
        setFlaggt(false);
    }

    public int bombsAround() {
        int result = 0;
        for (Tile tile : GamePanel.getWorld().getTileList()) {
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() + 1 && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() && tile.getPosY() == getPosY() + 1 && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() + 1 && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() - 1 && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() && tile.getPosY() == getPosY() - 1 && tile.isBomb()) result++;
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() - 1 && tile.isBomb()) result++;
        }
        return result;
    }

    public void searchForZeroTiles() {
        for (Tile tile : GamePanel.getWorld().getTileList()) {
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() + 1 && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() && tile.getPosY() == getPosY() + 1 && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() + 1 && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() - 1 && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() && tile.getPosY() == getPosY() - 1 && tile.getBombsAround() == 0)
                tile.setActivated(true);
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() - 1 && tile.getBombsAround() == 0)
                tile.setActivated(true);
        }
    }

    public void searchForNormalTiles() {
        for (Tile tile : GamePanel.getWorld().getTileList()) {
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() + 1 && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() && tile.getPosY() == getPosY() + 1 && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() + 1 && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() - 1 && tile.getPosY() == getPosY() - 1 && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() && tile.getPosY() == getPosY() - 1 && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
            if (tile.getPosX() == getPosX() + 1 && tile.getPosY() == getPosY() - 1 && tile.getBombsAround() != 0) {
                tile.setActivated(true);
                tile.setRemoteActivated(true);
            }
        }
    }

    public void firstUpdate(){
        if (isFirstUpdate()) {
            setFirstUpdate(false);
            setBombsAround(bombsAround());
        }
    }

    public void mousDragtOver() {
        if (isMouseDraggedOver() && !isActivated() && !isRemoteActivated()) {
            setLook(Texture.DOWN.getTexture());
        } else {
            if (!isActivated() && !isRemoteActivated()) {
                setLook(Texture.TOP.getTexture());
            }
        }
    }

    public void gotActivated() {
        if ((isKlicked()) && !isActivated()) {
            setActivated(true);
            switch (getBombsAround()) {
                case 0:
                    setLook(Texture.ZERO.getTexture());
                    break;
                case 1:
                    setLook(Texture.ONE.getTexture());
                    break;
                case 2:
                    setLook(Texture.TWO.getTexture());
                    break;
                case 3:
                    setLook(Texture.THREE.getTexture());
                    break;
                case 4:
                    setLook(Texture.FOUR.getTexture());
                    break;
                case 5:
                    setLook(Texture.FIVR.getTexture());
                    break;
                case 6:
                    setLook(Texture.SIX.getTexture());
                    break;
                case 7:
                    setLook(Texture.SEVEN.getTexture());
                    break;
                case 8:
                    setLook(Texture.EIGHT.getTexture());
                    break;
                default:
                    System.out.println("ERROR: FALSCHE ANZAHL AN BOMBEN IN DER NÄHE (Tile.update)");
                    setLook(Texture.DOWN.getTexture());
                    break;
            }
        }
        if (isRemoteActivated()) {
            setRemoteActivated(false);
            switch (getBombsAround()) {
                case -1:
                    setLook(Texture.ZERO.getTexture());
                    break;
                case 0:
                    setLook(Texture.ZERO.getTexture());
                    break;
                case 1:
                    setLook(Texture.ONE.getTexture());
                    break;
                case 2:
                    setLook(Texture.TWO.getTexture());
                    break;
                case 3:
                    setLook(Texture.THREE.getTexture());
                    break;
                case 4:
                    setLook(Texture.FOUR.getTexture());
                    break;
                case 5:
                    setLook(Texture.FIVR.getTexture());
                    break;
                case 6:
                    setLook(Texture.SIX.getTexture());
                    break;
                case 7:
                    setLook(Texture.SEVEN.getTexture());
                    break;
                case 8:
                    setLook(Texture.EIGHT.getTexture());
                    break;
                default:
                    System.out.println("ERROR: FALSCHE ANZAHL AN BOMBEN IN DER NÄHE (Tile.update)");
                    setLook(Texture.DOWN.getTexture());
                    break;
            }
        }

        if (isActivated() && getBombsAround() == 0) {
            searchForZeroTiles();
            searchForNormalTiles();
            setLook(Texture.ZERO.getTexture());
            setBombsAround(-1);
        }
    }

    @Override
    public void update() {
        firstUpdate();
        mousDragtOver();
        gotActivated();
    }

    public int getBombsAround() {
        return bombsAround;
    }

    public void setBombsAround(int bombsAround) {
        this.bombsAround = bombsAround;
    }

    public boolean isFlaggt() {
        return isFlaggt;
    }

    public void setFlaggt(boolean flaggt) {
        isFlaggt = flaggt;
    }

    public boolean isBomb() {
        return isBomb;
    }

    public void setBomb(boolean bomb) {
        isBomb = bomb;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean activated) {
        isActivated = activated;
    }

    public boolean isRemoteActivated() {
        return isRemoteActivated;
    }

    public void setRemoteActivated(boolean remoteActivated) {
        isRemoteActivated = remoteActivated;
    }

    public boolean isFirstUpdate() {
        return isFirstUpdate;
    }

    public void setFirstUpdate(boolean firstUpdate) {
        isFirstUpdate = firstUpdate;
    }
}
