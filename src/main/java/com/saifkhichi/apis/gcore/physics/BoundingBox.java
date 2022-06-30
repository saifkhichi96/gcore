package com.saifkhichi.apis.gcore.physics;

public class BoundingBox {

    public final float left;
    public final float right;
    public final float top;
    public final float bottom;
    public final Point2D center;

    public BoundingBox(Point2D center, int width, int height) {
        this.left = center.getX() - width / 2.0f;
        this.right = center.getX() + width / 2.0f;
        this.top = center.getY() + height / 2.0f;
        this.bottom = center.getY() - height / 2.0f;
        this.center = center;
    }

    public BoundingBox(float left, float right, float top, float bottom) {
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        this.center = new Point2D((left + right) / 2.0f, (top + bottom) / 2.0f);
    }

    public boolean intersects(BoundingBox other) {
        return !(this.left > other.right || this.right < other.left || this.top < other.bottom || this.bottom > other.top);
    }

    public boolean contains(Point2D point) {
        return !(this.left > point.getX() || this.right < point.getX() || this.top < point.getY() || this.bottom > point.getY());
    }

    public boolean contains(float x, float y) {
        return !(this.left > x || this.right < x || this.top < y || this.bottom > y);
    }

}
