package com.saifkhichi.apis.gcore.physics;

public class PolarVector {

    private float radius;
    private float angle;

    public PolarVector() {
        this.radius = 0.0f;
        this.angle = 0.0f;
    }

    public PolarVector(float radius, float angle) {
        this.radius = radius;
        this.angle = angle;
    }

    /**
     * Create a polar vector from a Cartesian vector.
     *
     * @param v The Cartesian vector.
     * @return The polar vector.
     */
    public static PolarVector fromCartesian(Vector2D v) {
        PolarVector p = new PolarVector();
        p.set(v);
        return p;
    }

    /**
     * Convert the polar vector into a Cartesian vector.
     *
     * @return The Cartesian vector.
     */
    public Vector2D toCartesian() {
        return Vector2D.fromPolar(this);
    }

    public void set(Vector2D v) {
        this.radius = v.getMagnitude();
        this.angle = v.getDirection();
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void set(float radius, float angle) {
        this.radius = radius;
        this.angle = angle;
    }

    public void add(PolarVector p) {
        // Convert to cartesian vectors.
        Vector2D v1 = this.toCartesian();
        Vector2D v2 = p.toCartesian();

        // Add the vectors.
        v1.add(v2);

        // Convert back to polar vectors.
        this.set(v1);
    }

    public void subtract(PolarVector p) {
        // Convert to cartesian vectors.
        Vector2D v1 = this.toCartesian();
        Vector2D v2 = p.toCartesian();

        // Subtract the vectors.
        v1.subtract(v2);

        // Convert back to polar vectors.
        this.set(v1);
    }

    public void multiply(float s) {
        // Convert to cartesian vectors.
        Vector2D v1 = this.toCartesian();

        // Multiply the vector.
        v1.multiply(s);

        // Convert back to polar vectors.
        this.set(v1);
    }

    public void divide(float s) {
        // Convert to cartesian vectors.
        Vector2D v1 = this.toCartesian();

        // Divide the vector.
        v1.divide(s);

        // Convert back to polar vectors.
        this.set(v1);
    }

}
