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

public class Background implements Renderable, Updateable {

    private static double width = Window.getWinWidth();
    private static double height = Window.getWinHeight();
    private static double x;
    private double y;

    private final int layer = 0;

    private static BufferedImage background;

    private double speed = 150;

    public Background(double y) throws IOException {
        this.y = y;

        background = ImageIO.read(new File("res/istockphoto-904278188-1024x1024.jpg"));
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
        return background;
    }

    @Override
    public void update() {
        y += speed * FPS.getDeltaTime();

        if (y >= Window.getWinHeight()) {
            y = -Window.getWinHeight();
        }
    }
}
