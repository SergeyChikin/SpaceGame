package update;

import java.util.ArrayList;

public class Updater {
    private static ArrayList<Updateable> updateableObjects = new ArrayList<>();
    private static ArrayList<Updateable> addUpdateableObjects = new ArrayList<>();
    private static ArrayList<Updateable> removeUpdateableObjects = new ArrayList<>();

    public static void update() {
        for (Updateable object : updateableObjects) {
            object.update();
        }

        updateableObjects.removeAll(removeUpdateableObjects);
        updateableObjects.addAll(addUpdateableObjects);

        addUpdateableObjects.clear();
        removeUpdateableObjects.clear();
    }

    public static void addUpdateableObject(Updateable object) {
        addUpdateableObjects.add(object);
    }

    public static void removeUpdateableObjects(Updateable object) {
        removeUpdateableObjects.add(object);
    }
}
