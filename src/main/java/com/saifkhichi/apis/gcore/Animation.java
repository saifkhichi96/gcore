package com.saifkhichi.apis.gcore;

import com.saifkhichi.apis.gcore.physics.Object2D;

import java.util.ArrayList;

public class Animation extends Object2D implements Drawable {

    private final ArrayList<Frame> frames = new ArrayList<>();

    /**
     * Total duration of the animation in milliseconds.
     */
    private long duration = 0;

    /**
     * Time elapsed since the animation started.
     */
    private long elapsedTime = 0;

    /**
     * Multiplier for the animation speed.
     * <p>
     * For example, 1.0f means the animation will play at the normal speed.
     * 2.0f means the animation will play twice as fast. 0.5f means the animation
     * will play half as fast. Default value is 1.0f.
     */
    private float speed = 1.0f;

    /**
     * Index of the current frame.
     * <p>
     * Valid values are 0 to frames.size() - 1.
     */
    private int currentFrame = 0;

    /**
     * Whether the animation is playing.
     * <p>
     * This flag is set to false when the animation is paused, and set to true
     * when the animation is resumed.
     */
    private boolean isPlaying = true;

    /**
     * Whether the animation should loop.
     * <p>
     * Animation will stop after the last frame if this is false. If this is true,
     * the animation will restart from the first frame after the last frame.
     * Default is true.
     */
    private boolean isRepeating = true;

    /**
     * Whether the animation has already looped at least once.
     */
    private boolean hasLooped = false;

    /**
     * Index of the frame to stop at. If this is -1, the animation will
     * stop normally.
     */
    private int indexPauseAt = -1;

    public Animation(int width, int height) {
        super(width, height);
    }

    /**
     * Adds an image to the animation with the specified
     * duration (time to display the image).
     *
     * @param image    The image to add
     * @param duration The time it should be displayed for
     */
    public void addFrame(int image, long duration) {
        this.duration += duration;
        frames.add(new Frame(image, this.duration));
    }

    /**
     * Works out which frame to display, incorporating
     * the offset.
     *
     * @param i The frame index to get
     * @return The animation frame corresponding to the index
     */
    private Frame getFrame(int i) {
        return frames.get(i);
    }

    /**
     * Set the animation to frame 'f'.
     *
     * @param f The frame to shift to.
     */
    public void setCurrentFrame(int f) {
        if (f < 0 || f >= frames.size()) return;
        currentFrame = f;
    }

    /**
     * Get the image associated with frame 'i'.
     *
     * @param i The index of the frame to request
     * @return A reference to the image at index 'i', or -1 if the index is out of range.
     */
    public int getFrameImage(int i) {
        if (i < 0 || i >= frames.size()) return -1;
        Frame frame = frames.get(i);
        return frame.image;
    }

    /**
     * Get the image associated with current frame.
     *
     * @return A reference to the image at index 'i', or -1 if there is no current frame.
     */
    public int getCurrentFrameImage() {
        return getFrameImage(currentFrame);
    }

    /**
     * Change the animation 'rate'. E.g. 2 would be twice as fast.
     *
     * @param rate The rate to animate at.
     */
    public void setSpeed(float rate) {
        speed = rate;
    }

    /**
     * Tell an animation to repeat continuously or not.
     *
     * @param repeating True if it should repeat continuously.
     */
    public void setRepeating(boolean repeating) {
        this.isRepeating = repeating;
    }

    /**
     * Has this animation looped at least once?
     *
     * @return True if this animation has looped at least once.
     */
    public boolean hasLooped() {
        return hasLooped;
    }

    /**
     * Start playing the animation.
     * <p>
     * The animation will start playing from the current frame.
     */
    public void start() {
        isPlaying = true;
    }

    /**
     * Restart the animation from the first frame.
     */
    public void restart() {
        elapsedTime = 0;
        currentFrame = 0;
        hasLooped = false;
        isPlaying = true;
    }

    /**
     * Pause the animation.
     */
    public void pause() {
        isPlaying = false;
    }

    /**
     * Pause the animation at given 'frame'
     *
     * @param frame The frame to pause at
     */
    public void pauseAt(int frame) {
        if (frame < 0 || frame >= frames.size()) {
            indexPauseAt = 0;
        } else {
            indexPauseAt = frame;
        }
    }

    @Override
    public void onDraw() {

    }

    @Override
    public void draw() {

    }

    /**
     * Updates this animation's current image (frame) based
     * on how much time has elapsed.
     *
     * @param elapsedTime Time that has elapsed since last call
     */
    public synchronized void update(long elapsedTime) {
        if (isPlaying) {
            elapsedTime = (long) (elapsedTime * speed);
            if (frames.size() > 1) {
                this.elapsedTime += elapsedTime;
                if (this.elapsedTime >= duration) {
                    if (isRepeating) {
                        this.elapsedTime %= duration;
                        currentFrame = 0;
                    } else {
                        this.elapsedTime = duration;
                    }
                    hasLooped = true;
                }
                while (this.elapsedTime > getFrame(currentFrame).endTime) {
                    currentFrame++;
                }

                // If we hit a stopFrame, pause the animation
                // It will be -1 if we should not stop at this point
                if (currentFrame == indexPauseAt) {
                    isPlaying = false;
                    indexPauseAt = -1;
                }
            }
        }
    }

    /**
     * Private class to hold information about a given animation frame.
     */
    static class Frame {

        /**
         * Resource id of the image for this frame.
         */
        int image;

        /**
         * Time in milliseconds when this frame ends.
         */
        long endTime;

        /**
         * Constructor.
         *
         * @param image   Resource id of the image for this frame.
         * @param endTime Time in milliseconds when this frame ends.
         */
        public Frame(int image, long endTime) {
            this.image = image;
            this.endTime = endTime;
        }

    }

}
