package objects;

import core.Timer;
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

}
