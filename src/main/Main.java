package main;

/**
 * @author Klausmp V 1.0
 */

public class Main {
    public static final String gameTitle = "Mine Sweeper";
    public static int highScore = 0;
    public static GameLoop gameLoop = new GameLoop();

    public static void main(String[] args) {
        gameLoop.init();
        gameLoop.run();
    }

    public static String getGameTitle() {
        return gameTitle;
    }

    public static int getHighScore() {
        return highScore;
    }

    public static void setHighScore(int highScore) {
        Main.highScore = highScore;
    }

    public static GameLoop getGameLoop() {
        return gameLoop;
    }

    public static void setGameLoop(GameLoop gameLoop) {
        Main.gameLoop = gameLoop;
    }
}