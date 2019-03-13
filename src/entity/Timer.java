package entity;

import main.GameLoop;

public class Timer extends Counter {
    public int timeCounter = 0;

    public Timer(int posX, int posY, boolean isRunning) {
        super(posX, posY, isRunning);
    }

    @Override
    public void update() {
        if (isRunning()) {
            addTime();
        }
        setLooks();
    }

    public void addTime() {
        setTimeCounter(getTimeCounter() + 1);
        if (getTimeCounter() >= GameLoop.getFPS()) {
            setNumber(getNumber() + 1);
            setTimeCounter(0);
        }
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void setTimeCounter(int timeCounter) {
        this.timeCounter = timeCounter;
    }
}
