package objects;

import core.FPS;
import core.Window;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Asteroid implements Updateable, Renderable{
    private double width;
    private double height;
    private double x;
    private double y;

    private final int layer = 2;

    private static BufferedImage asteroid;

    private double speed = 150;

    Random rand = new Random();

    public Asteroid() throws IOException{
        int dimensions = rand.nextInt(75 + 1);
        if (dimensions < 35) {
            dimensions = 35;
        }

        width = dimensions;
        height = dimensions;

        int posX = rand.nextInt((int)Window.getWinWidth() - (int)getWidth() + 1);
        this.x = posX;
        this.y = -getHeight();

        asteroid = ImageIO.read(new File("res/asteroid_98597.png"));

        Renderer.addRenderableObject(this);
        Updater.addUpdateableObject(this);
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public double getX() {
        return x;
    }

    @Override
    public double getY() {
        return y;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public BufferedImage getBufferedImage() {
        return asteroid;
    }

    @Override
    public void update() throws IOException{
      y += speed * FPS.getDeltaTime();

        if (y >= Window.getWinHeight()) {
            Updater.removeUpdateableObject(this);
            Renderer.removeRenderableObject(this);
        }
    }

    @Override
    public String getID() {
        return "asteroid";
    }

    @Override
    public Renderable getRenderable() {
        return this;
    }

    @Override
    public boolean drawCollisionBox() {
        return true;
    }
}
