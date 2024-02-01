package core;

import objects.AsteroidSpawner;
import objects.Background;
import objects.SpaceShip;
import render.Renderer;
import update.Updater;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class Entry {
    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Window window = new Window("SPACE GAME", Window.getWinWidth(), Window.getWinHeight());
        Renderer renderer = new Renderer();
        Updater updater = new Updater();

        window.addKeyListener(new Input());
        window.add(renderer);
        window.packWindow();
        window.setVisible(true);

        boolean runGame = true;

        new SpaceShip((Window.getWinWidth() / 2) - (SpaceShip.width / 2),
                Window.getWinHeight() - 150);
        new Background(-Window.getWinHeight());
        new AsteroidSpawner();


        FPS.calcBeginTime();
        while (runGame) {
            updater.update();
            renderer.repaint();
            FPS.calcDeltaTime();
        }
    }
}
