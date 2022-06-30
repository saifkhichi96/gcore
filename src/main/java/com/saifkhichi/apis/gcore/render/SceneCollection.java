package com.saifkhichi.apis.gcore.render;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A collection of Scene objects.
 * <p>
 * This class is used to manage the scenes in the game, as well as to
 * handle the transitions between them. This class is also responsible
 * for telling the game loop about the current Scene for updating and
 * rendering.
 *
 * @author Saif Khan<saifkhichi96@gmail.com>
 */
public class SceneCollection {

    private final HashMap<Class<? extends Scene>, Scene> scenes = new HashMap<>();

    private Class<? extends Scene> currentScene = null;

    /**
     * Creates a new, empty SceneCollection object.
     */
    public SceneCollection() {
    }

    /**
     * Adds a Scene to the SceneCollection object.
     *
     * @param scene The Scene to add
     * @throws IllegalArgumentException If another Scene with the same name already exists
     * @throws NullPointerException     If the Scene is null
     */
    public void addScene(Scene scene) {
        if (scene == null) {
            throw new NullPointerException("Scene cannot be null");
        }

        if (scenes.containsKey(scene.getClass())) {
            throw new IllegalArgumentException("Scene with name " + scene.getClass().getName() + " already exists");
        }

        scenes.put(scene.getClass(), scene);
    }

    /**
     * Returns the current Scene.
     *
     * @return The current Scene
     */
    public Scene getCurrentScene() {
        return scenes.get(currentScene);
    }

    /**
     * Sets the current Scene to the specified Scene.
     *
     * @param sceneName The name of the Scene to set as the current Scene
     *                  (must already exist in the SceneCollection object)
     * @throws IllegalArgumentException If the Scene does not exist in the SceneCollection object
     */
    public void setCurrentScene(Class<? extends Scene> sceneName) {
        if (scenes.containsKey(sceneName)) {
            currentScene = sceneName;
        } else {
            throw new IllegalArgumentException("Scene " + sceneName + " does not exist.");
        }
    }

    /**
     * Returns the Scene with the specified name.
     *
     * @param sceneName The name of the Scene to return
     * @return The Scene with the specified name
     * @throws IllegalArgumentException If the Scene does not exist in the SceneCollection object
     */
    public Scene getScene(Class<? extends Scene> sceneName) {
        if (scenes.containsKey(sceneName)) {
            return scenes.get(sceneName);
        } else {
            throw new IllegalArgumentException("Scene " + sceneName + " does not exist.");
        }
    }

    /**
     * Returns the list of Scene names.
     *
     * @return The list of Scene names
     */
    public List<Class<? extends Scene>> listScenes() {
        return new ArrayList<>(scenes.keySet());
    }

}
