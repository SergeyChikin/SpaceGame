package render;

import core.Window;
import javax.swing.*;
import java.awt.*;

public class Renderer extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        graphics.drawRect(100, 100, 100, 100);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) Window.getWinWidth() + 1, (int) Window.getWinHeight() + 1);
    }
}
