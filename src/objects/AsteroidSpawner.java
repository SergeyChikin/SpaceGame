package objects;

import core.Timer;
import render.Renderable;
import update.Updateable;
import update.Updater;

import java.io.IOException;

public class AsteroidSpawner implements Updateable {
    Timer timer = new Timer(500);

    public AsteroidSpawner() {
        Updater.addUpdateableObject(this);
    }

    @Override
    public void update() throws IOException {
        if (timer.isRinging()) {
            new Asteroid();
            timer.resetTimer();
        }
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public Renderable getRenderable() {
        return null;
    }

}
