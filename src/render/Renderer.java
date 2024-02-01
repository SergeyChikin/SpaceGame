package render;

import core.Window;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Renderer extends JPanel {
    private static ArrayList<Renderable> renderableObjects = new ArrayList<Renderable>();
    private static ArrayList<Renderable> addRenderableObjects = new ArrayList<Renderable>();
    private static ArrayList<Renderable> removeRenderableObjects = new ArrayList<Renderable>();

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

       for(Renderable object: renderableObjects)
           object.drawSprite(graphics2D);

        renderableObjects.removeAll(removeRenderableObjects);
        if (addRenderableObjects.size() > 0) {
            renderableObjects.addAll(addRenderableObjects);
            Collections.sort(renderableObjects);
        }

        addRenderableObjects.clear();
        removeRenderableObjects.clear();
    }

    public static void addRenderableObject(Renderable object) {
        addRenderableObjects.add(object);
//        Collections.sort(renderableObjects);
    }

    public static void removeRenderableObject(Renderable object) {
        removeRenderableObjects.add(object);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) Window.getWinWidth() , (int) Window.getWinHeight() );
    }
}
