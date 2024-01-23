package objects;

import core.FPS;
import core.Input;
import render.Renderable;
import render.Renderer;
import update.Updateable;
import update.Updater;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SpaceShip implements Renderable, Updateable {
    private static double width = 75;
    private static double height = 75;
    private double x;
    private double y;

    private int layer = 1;

    private static BufferedImage spaceShip;

    private double speed = 200;

    public SpaceShip(double x, double y) throws IOException {
        this.x = x;
        this.y = y;

        spaceShip = ImageIO.read(new File("res/spaceship-1_96126.png"));
        Renderer.addRenderableObject(this);
        Updater.addUpdateableObject(this);
    }

    public static double getWidth() {
        return width;
    }

    public static double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void draw(Graphics2D g) {
        g.drawImage(spaceShip, (int)x, (int)y, (int)width, (int)height, null );
    }

    @Override
    public int getLayer() {
        return layer;
    }

    @Override
    public void update() {
        if (Input.keys[Input.RIGHT]) {
            x += speed * FPS.getDeltaTime();
        }
        if (Input.keys[Input.LEFT]) {
            x -= speed * FPS.getDeltaTime();
        }
        if (Input.keys[Input.UP]) {
            y -= speed * FPS.getDeltaTime();
        }
        if (Input.keys[Input.DOWN]) {
            y += speed * FPS.getDeltaTime();
        }
    }
}
