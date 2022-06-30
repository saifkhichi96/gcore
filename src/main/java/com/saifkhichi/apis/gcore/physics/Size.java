package com.saifkhichi.apis.gcore.physics;

/**
 *
 */
public class Size {

    private int width;
    private int height;
    private int radius;

    public Size() {
        this.width = 0;
        this.height = 0;
        this.radius = 0;
    }

    public Size(int radius) {
        this.set(radius);
    }

    public Size(int width, int height) {
        this.set(width, height);
    }

    public Size(int width, int height, int radius) {
        this.set(width, height, radius);
    }

    public void set(int radius) {
        this.width = radius;
        this.height = radius;
        this.radius = radius;
    }

    public void set(int width, int height) {
        this.width = width;
        this.height = height;
        this.radius = width > height ? width / 2 : height / 2;
    }

    public void set(int width, int height, int radius) {
        this.width = width;
        this.height = height;
        this.radius = radius;
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

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

}
