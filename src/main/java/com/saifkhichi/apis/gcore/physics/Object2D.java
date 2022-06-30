package com.saifkhichi.apis.gcore.physics;

public class Object2D {

    /**
     * Width of the object.
     */
    private int width;

    /**
     * Height of the object.
     */
    private int height;

    /**
     * The coordinates of the object's center.
     */
    private final Point2D position = new Point2D();

    public Object2D() {
        this.width = 0;
        this.height = 0;
    }

    public Object2D(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Object2D(int width, int height, float x, float y) {
        this.width = width;
        this.height = height;
        this.position.set(x, y);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getX() {
        return position.x;
    }

    public void setX(float x) {
        position.x = x;
    }

    public float getY() {
        return position.y;
    }

    public void setY(float y) {
        position.y = y;
    }

    public BoundingBox getBoundingBox() {
        return new BoundingBox(position, width, height);
    }

    public void translate(Point2D offset) {
        position.add(offset);
    }

    public void translate(float dx, float dy) {
        position.add(new Point2D(dx, dy));
    }

    public void translateX(float dx) {
        position.addX(dx);
    }

    public void translateY(float dy) {
        position.addY(dy);
    }

    public boolean isBelow(float y) {
        return position.y + height > y;
    }

    public boolean isAbove(float y) {
        return position.y < y;
    }

    public void putOn(float y) {
        position.y = y - height / 2f;
    }

    /**
     * Override this method to update the object's state.
     * <p>
     * This method is called by the game engine and should not be called
     * directly by the user. It updates the object's state before drawing
     * it again, and it is called at regular intervals.
     *
     * @param elapsedTime The time elapsed since the last update.
     */
    public void update(long elapsedTime) {
        // do nothing
    }

}
