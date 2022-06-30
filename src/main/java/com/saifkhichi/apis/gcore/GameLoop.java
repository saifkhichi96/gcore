package com.saifkhichi.apis.gcore;

/**
 * The execution loop attached to an instance of {@link BaseGame}.
 * <p>
 * Every game runs inside this loop. It periodically refreshes the game state
 * after defined interval, and pauses or stops the execution with the game.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
class GameLoop extends Thread {

    /**
     * Game associated with this execution loop.
     */
    protected final BaseGame game;

    /**
     * Default constructor.
     * <p>
     * This class can only be instantiated through its subclasses.
     *
     * @param game game associated with this execution loop
     */
    public GameLoop(BaseGame game) {
        this.game = game;
    }

    /**
     * Performs the actual execution.
     * <p>
     * This method defines the game loop which repeats itself after a defined
     * time interval until the game is finished. It updates game states when
     * the game is not paused or finished.
     */
    @Override
    public void run() {
        long lastUpdate = System.currentTimeMillis();
        while (!game.isOver()) {
            try {
                long now = System.currentTimeMillis();
                long elapsed = now - lastUpdate;
                lastUpdate = now;

                // update game states if the game is not paused
                if (game.isRunning()) {
                    synchronized (game) {
                        game.update(elapsed);
                        game.onDraw();
                    }
                }

                // sleep for the remaining time interval to achieve the desired
                // refresh rate
                long waitTime = game.getUpdateInterval() - elapsed;
                if (waitTime > 0) Thread.sleep(waitTime);
            } catch (InterruptedException ignored) {
                // no-op
            }
        }
    }

}