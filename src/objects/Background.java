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
    private static double height = Window.getWinHeight() * 2;
    private static double x = 0;
    private double y;

    private final int layer = 0;

    private static BufferedImage background;

    private double speed = 200;

    public Background(double y) throws IOException {
        this.y = y;

//        background = ImageIO.read(new File("res/istockphoto-904278188-1024x1024.jpg"));
        background = ImageIO.read(new File("res/cosmos.jpg"));
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
    public void update() throws IOException{
        y += speed * FPS.getDeltaTime();

        if (y >= 0) {
            y = -Window.getWinHeight();
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

    @Override
    public boolean drawCollisionBox() {
        return false;
    }
}
