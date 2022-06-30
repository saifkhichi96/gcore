package com.saifkhichi.apis.gcore;

import com.saifkhichi.apis.gcore.render.Scene;
import com.saifkhichi.apis.gcore.render.SceneCollection;

import java.util.List;

/**
 * Base class for all games.
 * <p>
 * This class saves game states and implements core functionality to properly
 * play of a game.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 * @version 2.0.0
 * @since 1.0.0
 */
public abstract class BaseGame implements GameCallbacks {

    /**
     * Collection of all game scenes.
     */
    private final SceneCollection scenes = new SceneCollection();

    /**
     * Refresh rate (frames per second) of the game.
     */
    private final int fps;

    /**
     * Execution loop for this game.
     */
    private final GameLoop loop;

    /**
     * Flag indicating whether the game is finished or not.
     */
    private boolean isOver = false;

    /**
     * Flag indicating if the game is currently paused.
     */
    private boolean isPaused = false;

    /**
     * Creates a new game with the given refresh rate.
     *
     * @param fps The refresh rate (in frames per second) of the game
     */
    protected BaseGame(int fps) {
        this.loop = new GameLoop(this);
        this.fps = fps;
    }

    protected abstract List<Scene> getScenes();

    protected abstract Class<? extends Scene> getInitialScene();

    /**
     * Get the current scene.
     *
     * @return Reference to the current scene
     */
    public Scene getCurrentScene() {
        return scenes.getCurrentScene();
    }

    /**
     * Get the update interval of the game.
     * <p>
     * Update interval is the time interval between two consecutive game
     * updates, or between two consecutive frames.
     *
     * @return update interval of the game in milliseconds
     */
    public long getUpdateInterval() {
        return 1000 / fps;
    }

    public Scene getActiveScene() {
        return scenes.getCurrentScene();
    }

    public void update(long elapsedTime) {
        getCurrentScene().onUpdate(elapsedTime);
    }

    public void onDraw() {
        getCurrentScene().onDraw();
    }

    public void startScene(Class<? extends Scene> sceneName) {
        Scene scene = scenes.getScene(sceneName);
        if (scene == null) {
            throw new RuntimeException("Scene not defined in scenes.");
        }

        try {
            scenes.setCurrentScene(sceneName);
            scene.onStart();  // might throw exception, but we don't care
        } catch (Exception ignored) {

        }
    }

    /**
     * Starts the game loop.
     * <p>
     * The game loop runs in a separate thread. The onStart() method of the game
     * is called right before starting the game loop. This is followed by a call
     * to onStart() of the current scene. And finally, the game loop is started.
     *
     * @throws RuntimeException if there is problem starting the game loop
     */
    public void start() throws RuntimeException {
        List<Scene> scenes = getScenes();

        if (scenes.isEmpty()) {
            throw new RuntimeException("No scenes defined.");
        }

        Class<? extends Scene> initialScene = getInitialScene();
        if (initialScene == null) {
            throw new RuntimeException("No initial scene defined.");
        }

        // Create game scenes
        for (Scene s : scenes) {
            this.scenes.addScene(s);
        }

        // Call the start callback
        this.onStart();

        // Set flags so that the game can start
        isOver = false;
        isPaused = false;

        // Start the initial scene
        startScene(initialScene);

        // Start the game loop
        loop.start();
    }

    /**
     * Pauses the game.
     * <p>
     * Game execution is paused and onPause() callback is invoked. This method has no
     * effect if the game is already paused or if the game is finished.
     */
    public void pause() {
        if (isOver || isPaused) return;

        isPaused = true;
        this.onPaused();
    }

    /**
     * Resumes the game.
     * <p>
     * The onResumed() callback is invoked and then the game execution is resumed.
     * This method has no effect if the game is not paused or already finished.
     */
    public void resume() {
        if (isOver || !isPaused) return;

        this.onResume();
        isPaused = false;
    }

    /**
     * Ends the game.
     * <p>
     * Game execution is ended and the finish callback invoked. This method has no
     * effect if the game already ended.
     */
    public void end() {
        if (isOver) return;

        isOver = true;
        isPaused = false;

        this.onOver();
    }

    /**
     * Checks whether the game is over or not.
     *
     * @return true if game is over, false otherwise
     */
    public boolean isOver() {
        return isOver;
    }

    /**
     * Checks whether the game is running or paused.
     *
     * @return true if game running, false if paused
     */
    public boolean isRunning() {
        return !isPaused;
    }

}