package huskyhacks3.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Created by david on 10/1/2017.
 */
public class TileBorderifier {
    public static BufferedImage trumpify(BufferedImage image, Color color, boolean left, boolean right, boolean up, boolean down) {
        Graphics g = image.getGraphics();
        g.setColor(color);
        if (left) {
            g.drawRect(0, 0, 1, image.getHeight());
        }
        if (right) {
            g.drawRect(image.getWidth() - 1, 0, 1, image.getHeight());
        }
        if (up) {
            g.drawRect(0, 0, image.getWidth(), 1);
        }
        if (down) {
            g.drawRect(0, image.getHeight() - 1, image.getWidth(), 1);
        }
        return image;
    }
}