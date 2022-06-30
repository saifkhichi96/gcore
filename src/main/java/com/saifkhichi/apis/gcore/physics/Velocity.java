package com.saifkhichi.apis.gcore.physics;

/**
 * Velocity of an object.
 * <p>
 * This class is used to represent the velocity of an object. Velocity has a
 * magnitude and a direction. The magnitude is the speed of the object and the
 * direction is the angle of the object's motion.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
public class Velocity extends PolarVector {

    /**
     * The x and y components of the velocity.
     */
    private Vector2D components;

    /**
     * Creates a new velocity with 0 magnitude and 0 direction.
     */
    public Velocity() {
        components = new Vector2D();
    }

    /**
     * Creates a new velocity with the specified magnitude and direction.
     *
     * @param speed The magnitude of the velocity (i.e. speed).
     * @param angle The direction of the velocity in degrees.
     */
    public Velocity(float speed, float angle) {
        super(speed, angle);
        components = Vector2D.fromPolar(this);
    }

    /**
     * Set the direction in degrees. Does not change the magnitude.
     *
     * @param a The direction of the velocity in degrees.
     */
    public void setAngle(float a) {
        super.setAngle(a);
        components.set(this);  // Update the components
    }

    /**
     * Get the speed.
     *
     * @return The speed.
     */
    public float getSpeed() {
        return super.getRadius();
    }

    /**
     * Set the speed. Does not change the direction.
     *
     * @param s The magnitude of the velocity.
     */
    public void setSpeed(float s) {
        super.setRadius(s);
        components.set(this);  // Update the components
    }

    /**
     * Get the x component of the velocity.
     *
     * @return The x component of the velocity.
     */
    public float getX() {
        return components.getX();
    }

    /**
     * Set the x component of the velocity. Changes both the magnitude and
     * direction.
     *
     * @param x The x component of the velocity.
     */
    public void setX(float x) {
        components.setX(x);
        this.set(components);  // Update the speed and direction
    }

    /**
     * Get the y component of the velocity.
     *
     * @return The y component of the velocity.
     */
    public float getY() {
        return components.getY();
    }

    /**
     * Set the y component of the velocity. Changes both the magnitude and
     * direction.
     *
     * @param y The y component of the velocity.
     */
    public void setY(float y) {
        components.setY(y);
        this.set(components);  // Update the speed and direction
    }

    /**
     * Add the specified velocity to this velocity.
     *
     * @param v The velocity to add.
     */
    public void add(Velocity v) {
        super.add(v);
        components.set(this);  // Update the components
    }

    public void addX(float x) {
        components.addX(x);
        this.set(components);  // Update the speed and direction
    }

    public void addY(float y) {
        components.addY(y);
        this.set(components);  // Update the speed and direction
    }

    /**
     * Subtract the specified velocity from this velocity.
     *
     * @param v The velocity to subtract.
     */
    public void subtract(Velocity v) {
        super.subtract(v);
        components.set(this);  // Update the components
    }

    public void subtractX(float x) {
        components.subtractX(x);
        this.set(components);  // Update the speed and direction
    }

    public void subtractY(float y) {
        components.subtractY(y);
        this.set(components);  // Update the speed and direction
    }

    /**
     * Multiply this velocity by the specified scalar.
     *
     * @param s The scalar to multiply by.
     */
    public void multiply(float s) {
        super.multiply(s);
        components.set(this);  // Update the components
    }

    /**
     * Divide this velocity by the specified scalar.
     *
     * @param s The scalar to divide by.
     */
    public void divide(float s) {
        super.divide(s);
        components.set(this);  // Update the components
    }

}
