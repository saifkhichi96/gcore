package com.saifkhichi.apis.gcore;

/**
 * Interface definition for the game's lifecycle callbacks.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 * @version 1.0.0
 * @since 2.0.0
 */
public interface GameCallbacks {

    void onStart();

    void update(long elapsedTime);

    void onDraw();

    void onPaused();

    void onResume();

    void onOver();

}