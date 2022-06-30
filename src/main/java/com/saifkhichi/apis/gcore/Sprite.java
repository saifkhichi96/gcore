package com.saifkhichi.apis.gcore;

import com.saifkhichi.apis.gcore.physics.Object2D;

/**
 * Sprite is a drawable 2D object with a custom view.
 * <p>
 * The view can be any object that implements the Drawable interface, and
 * is used to draw the sprite. The view is not drawn directly, but is
 * instead passed to the draw() method of the sprite.
 *
 * @param <View>
 */
public class Sprite<View extends Drawable> extends Object2D implements Drawable {

    /**
     * The view of the sprite.
     */
    private View view;

    public Sprite(int width, int height) {
        super(width, height);
    }

    /**
     * Sets the view of the sprite.
     *
     * @param view The view of the sprite.
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * Gets the view of the sprite.
     *
     * @return The view of the sprite.
     */
    public View getView() {
        return view;
    }

    public void update(long elapsedTime) {
        view.onDraw();
        view.draw();
    }

    @Override
    public void draw() {
        if (view != null) {
            view.draw();
        }
    }

    @Override
    public void onDraw() {
        if (view != null) {
            view.onDraw();
        }
    }
}
