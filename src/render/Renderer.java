package render;

import core.Window;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Renderer extends JPanel {
    private static ArrayList<Renderable> renderableObjects = new ArrayList<Renderable>();

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

       for(Renderable object: renderableObjects)
           object.draw(graphics2D);
    }

    public static void addRenderableObject(Renderable object) {
        renderableObjects.add(object);
        Collections.sort(renderableObjects);
    }

    public static void removeRenderableObject(Renderable object) {
        renderableObjects.remove(object);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) Window.getWinWidth() + 1, (int) Window.getWinHeight() + 1);
    }
}
