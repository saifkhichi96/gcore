package com.saifkhichi.apis.gcore.physics;


/**
 * A two-dimensional point.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
public class Point2D {

    /**
     * The x coordinate of the point.
     */
    protected float x;

    /**
     * The y coordinate of the point.
     */
    protected float y;

    /**
     * Initialise a default point with 0,0 coordinates.
     */
    public Point2D() {
        this.x = 0.0f;
        this.y = 0.0f;
    }

    /**
     * Initialise a point with the given coordinates.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public Point2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Calculate the Euclidean distance between two points.
     *
     * @param x1 x coordinate of the first point
     * @param y1 y coordinate of the first point
     * @param x2 x coordinate of the second point
     * @param y2 y coordinate of the second point
     * @return sqrt(( x2 - x1)^2 + (y2-y1)^2)
     */
    public static double distance(float x1, float y1, float x2, float y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    /**
     * Set the point coordinates.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     */
    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Get the x coordinate of the point.
     *
     * @return The x coordinate.
     */
    public float getX() {
        return x;
    }

    /**
     * Set the x coordinate of the point.
     *
     * @param x The x coordinate.
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Get the y coordinate of the point.
     *
     * @return The y coordinate.
     */
    public float getY() {
        return y;
    }

    /**
     * Set the y coordinate of the point.
     *
     * @param y The y coordinate.
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * Add a point to this point.
     *
     * @param p The point to add.
     */
    public void add(Point2D p) {
        this.x += p.x;
        this.y += p.y;
    }

    /**
     * Add a value to the x coordinate of this point.
     *
     * @param dx The value to add.
     */
    public void addX(float dx) {
        this.x += dx;
    }

    /**
     * Add a value to the y coordinate of this point.
     *
     * @param dy The value to add.
     */
    public void addY(float dy) {
        this.y += dy;
    }

    /**
     * Subtract a point from this point.
     *
     * @param v The vector to subtract.
     */
    public void subtract(Point2D v) {
        this.x -= v.x;
        this.y -= v.y;
    }

    /**
     * Subtract a value from the x coordinate of this point.
     *
     * @param dx The value to subtract.
     */
    public void subtractX(float dx) {
        this.x -= dx;
    }

    /**
     * Subtract a value from the y coordinate of this point.
     *
     * @param dy The value to subtract.
     */
    public void subtractY(float dy) {
        this.y -= dy;
    }

    /**
     * Calculate the Euclidean distance between this point and another point.
     *
     * @param px x coordinate of the second point
     * @param py y coordinate of the second point
     * @return sqrt(( px - x)^2 + (py-y)^2)
     */
    public double distance(float px, float py) {
        return distance(this.x, this.y, px, py);
    }

    /**
     * Calculate the Euclidean distance between this point and another point.
     *
     * @param p the second point
     * @return sqrt(( pt.x - x)^2 + (pt.y-y)^2)
     */
    public double distance(Point2D p) {
        return distance(this.x, this.y, p.x, p.y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        if (Float.compare(point2D.x, x) != 0) return false;
        return Float.compare(point2D.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Float.floatToIntBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Float.floatToIntBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("Point2D(x=%s, y=%s)", x, y);
    }

}
