package entity;

import graphics.Texture;
import graphics.displays.GamePanel;

import java.util.Objects;

public class Tile extends Entity {
    public int bombsAround;
    public boolean isFlagged;
    public boolean isBomb;
    public boolean isActivated;
    public boolean isRemoteActivated;
    public boolean isFirstUpdate = true;

    public Tile(int posX, int posY, int wight, int height, boolean isFlagged) {
        super(posX, posY, wight, height);
        setLook(Texture.TOP.getTexture());
        setBomb(false);
        setFlagged(isFlagged);
    }

    public Tile(int posX, int posY, int wight, int height) {
        super(posX, posY, wight, height);
        setLook(Texture.TOP.getTexture());
        setBomb(false);
        setFlagged(false);
    }

    public int bombsAround() {
        int result = 0;
        for (Tile tile : Objects.requireNonNull(GamePanel.getWorld()).getTileList()) {
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
        for (Tile tile : Objects.requireNonNull(GamePanel.getWorld()).getTileList()) {
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
        for (Tile tile : Objects.requireNonNull(GamePanel.getWorld()).getTileList()) {
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

    public void firstUpdate() {
        if (isFirstUpdate()) {
            setFirstUpdate(false);
            setBombsAround(bombsAround());
        }
    }

    public void modsDragsOver() {
        if (isMouseDraggedOver() && !isActivated() && !isRemoteActivated() && !isFlagged()) {
            if (getLook() != Texture.DOWN.getTexture()) {
                setLook(Texture.DOWN.getTexture());
            }
        } else {
            if (!isActivated() && !isRemoteActivated() && !isFlagged()) {
                if (getLook() != Texture.TOP.getTexture()) {
                    setLook(Texture.TOP.getTexture());
                }
            }
        }
    }

    public void gotLeftKlicked() {
        if (!isBomb() && !isFlagged()) {
            if ((isTileLeftKlicked()) && !isActivated()) {
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
                setActivated(true);
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
        } else {
            if (isTileLeftKlicked() && !isFlagged()) {
                setActivated(true);
                setLook(Texture.DEADBOMB.getTexture());
            }
        }
    }

    public void gotRightKlicked() {
        if (isFlagged()) {
            if (isTileRightKlicked() && !isActivated()){
                setLook(Texture.TOP.getTexture());
                setFlagged(false);
            }
        } else {
            if (isTileRightKlicked() && !isActivated()){
                setLook(Texture.FLAG.getTexture());
                setFlagged(true);
            }
        }
    }

    @Override
    public void update() {
        if (!Objects.requireNonNull(GamePanel.getWorld()).isGameOver()) {
            firstUpdate();
            modsDragsOver();
            gotLeftKlicked();
            gotRightKlicked();
        }
    }

    public int getBombsAround() {
        return bombsAround;
    }

    public void setBombsAround(int bombsAround) {
        this.bombsAround = bombsAround;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
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
