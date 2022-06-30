package com.saifkhichi.apis.gcore.render;

/**
 * Interface definition for the game's lifecycle callbacks.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 * @version 1.0.0
 * @since 2.0.0
 */
public interface SceneCallbacks {

    void onStart();

    void onUpdate(long elapsedTime);

    void onDraw();

    void onStop();

}