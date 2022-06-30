package com.saifkhichi.apis.gcore.physics;

/**
 * A two-dimensional vector in Cartesian coordinates.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
public class Vector2D extends Point2D {

    public Vector2D() {
        super(0.0f, 0.0f);
    }

    public Vector2D(float x, float y) {
        super(x, y);
    }

    public static Vector2D fromPolar(PolarVector p) {
        Vector2D v = new Vector2D();
        v.set(p);
        return v;
    }

    public PolarVector toPolar() {
        return PolarVector.fromCartesian(this);
    }

    /**
     * Set the vector coordinates from a polar coordinate.
     *
     * @param p The polar coordinate.
     */
    public void set(PolarVector p) {
        float x = p.getRadius() * (float) Math.cos(Math.toRadians(p.getAngle()));
        float y = p.getRadius() * (float) Math.sin(Math.toRadians(p.getAngle()));
        this.set(x, y);
    }

    /**
     * Multiply this vector by a scalar.
     *
     * @param s The scalar to multiply by.
     */
    public void multiply(float s) {
        this.x *= s;
        this.y *= s;
    }

    /**
     * Divide this vector by a scalar.
     *
     * @param s The scalar to divide by.
     */
    public void divide(float s) {
        this.x /= s;
        this.y /= s;
    }

    /**
     * Get the magnitude of this vector.
     *
     * @return The magnitude.
     */
    public float getMagnitude() {
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /**
     * Get the direction of this vector.
     *
     * @return The direction in degrees.
     */
    public float getDirection() {
        return (float) Math.toDegrees(Math.atan2(y, x));
    }

}
