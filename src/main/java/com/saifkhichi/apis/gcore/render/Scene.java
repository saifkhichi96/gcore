package com.saifkhichi.apis.gcore.render;

import com.saifkhichi.apis.gcore.BaseGame;

public abstract class Scene implements SceneCallbacks {

    /**
     * The game this scene belongs to.
     */
    public final BaseGame game;

    /**
     * Creates a new scene.
     *
     * @param game The game this scene belongs to.
     */
    public Scene(BaseGame game) {
        this.game = game;
    }

}
