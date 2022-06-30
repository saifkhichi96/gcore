package com.saifkhichi.apis.gcore.physics;

/**
 * Defines the physics engine for the game.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
public class Physics {

    /**
     * The gravity of the game (in px/s^2).
     */
    public static final float GRAVITY = -9.8f;

    public static void update(RigidBody body, float delta) {
        // Apply acceleration to velocity
        body.velocity.addX(body.acceleration.getX() * delta);
        body.velocity.addY(body.acceleration.getY() * delta);

        // Apply gravity to velocity
        if (body.isGravitational) {
            body.velocity.addY(GRAVITY * delta);
        }

        // Update position according to velocity
        body.translateX(body.velocity.getX() * delta);
        body.translateY(body.velocity.getY() * delta);
    }

    public static void applyForce(RigidBody body, Vector2D force) {
        body.acceleration.addX(force.getX() / body.mass);
        body.acceleration.addY(force.getY() / body.mass);
    }

}
