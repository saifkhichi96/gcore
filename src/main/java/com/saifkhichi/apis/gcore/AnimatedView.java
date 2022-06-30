package com.saifkhichi.apis.gcore;

/**
 * AnimatedView is a Sprite with an animated view.
 * <p>
 * It is used to display frame-based animations. The view should be an instance
 * of {@link Animation}.
 *
 * @see Sprite
 * @see Animation
 */
public class AnimatedView extends Sprite<Animation> {

    public AnimatedView(Animation animation) {
        super(animation.getWidth(), animation.getHeight());
        setView(animation);
    }

    public void update(long elapsedTime) {
        getView().update(elapsedTime);
        super.update(elapsedTime);
    }

    public void animate() {
        getView().start();
    }

    public void setAnimationSpeed(float speed) {
        getView().setSpeed(speed);
    }

    public void stopAnimation() {
        getView().pause();
    }

}


