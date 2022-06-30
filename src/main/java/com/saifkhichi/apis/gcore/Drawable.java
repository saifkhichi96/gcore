package com.saifkhichi.apis.gcore;

/**
 * A drawable object.
 */
public interface Drawable {

    /**
     * Draws the object.
     * <p>
     * This method is called by the game engine. It should not be called
     * directly by the user.
     *
     * @see #onDraw()
     */
    void draw();

    /**
     * Called when the object is about to be drawn.
     * <p>
     * This method can be used to update the object's state before it is drawn.
     * It is called by the game engine and should not be called directly by the
     * user.
     *
     * @see #draw()
     */
    void onDraw();

}
