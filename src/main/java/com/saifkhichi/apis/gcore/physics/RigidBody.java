package com.saifkhichi.apis.gcore.physics;

/**
 * RigidBody represents a solid object whose position, orientation and velocity
 * obey the laws of physics.
 * <p>
 * A rigid body has a size consisting of width and height. All points inside the
 * bounding box of the rigid body are considered to be part of the rigid body,
 * and the position of these points is fixed relative to each other.
 * <p>
 * It also has a position, velocity and acceleration. The position is the center
 * of the rigid body. The velocity is the rate of change of the position. The
 * acceleration is the rate of change of the velocity.
 * <p>
 * The position of the body changes according to its velocity. The velocity is
 * zero when the body is at rest. The acceleration is zero when the body is either
 * at rest or moving with a constant velocity. The acceleration is a function of
 * the forces applied to the body and its mass. The forces are applied to the body
 * according to the laws of physics.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
public class RigidBody extends Object2D {

    /**
     * The linear velocity of the object in units per second.
     */
    public final Velocity velocity;

    /**
     * The acceleration of the object in units per second squared.
     */
    public final Point2D acceleration;

    /**
     * The mass of the object in grams.
     */
    public final float mass;

    /**
     * Is the object affected by gravity?
     */
    public boolean isGravitational = false;

    public RigidBody() {
        super();
        this.velocity = new Velocity();
        this.acceleration = new Point2D();
        this.mass = 1.0f;
    }

    public RigidBody(int width, int height, float mass) {
        super(width, height);
        this.velocity = new Velocity();
        this.acceleration = new Point2D();
        this.mass = mass;
    }

    public RigidBody(int width, int height, float x, float y) {
        super(width, height, x, y);
        this.velocity = new Velocity();
        this.acceleration = new Point2D();
        this.mass = 1.0f;
    }

    public RigidBody(int width, int height, float x, float y, float mass) {
        super(width, height, x, y);
        this.velocity = new Velocity();
        this.acceleration = new Point2D();
        this.mass = mass;
    }

    public void update(long elapsedTime) {
        super.update(elapsedTime);
        Physics.update(this, elapsedTime);
    }

    public void stop() {
        velocity.setX(0);
        velocity.setY(0);
    }

}