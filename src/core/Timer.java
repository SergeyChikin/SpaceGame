package core;

import render.Renderable;
import update.Updateable;
import update.Updater;

import java.io.IOException;

public class Timer implements Updateable {
    int setMillisTime = 0;
    int beginningMillisTime;

    public Timer(int setMillisTime) {
        this.beginningMillisTime = setMillisTime;

        Updater.addUpdateableObject(this);
    }

    @Override
    public void update() throws IOException {
        setMillisTime -= FPS.getDeltaTime() * 1000;
    }

    public boolean isRinging() {
        if (setMillisTime <= 0) {
            return true;
        }
        return false;
    }

    public void resetTimer() {
        setMillisTime = beginningMillisTime;
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
