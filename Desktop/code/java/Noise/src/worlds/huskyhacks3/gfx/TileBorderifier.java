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
        int width = 2;
        g.setColor(color);
        if (left) {
            g.fillRect(0, 0, width, image.getHeight());
        }
        if (right) {
            g.fillRect(image.getWidth() - 1, 0, width, image.getHeight());
        }
        if (up) {
            g.fillRect(0, 0, image.getWidth(), width);
        }
        if (down) {
            g.fillRect(0, image.getHeight() - 1, image.getWidth(), width);
        }
        return image;
    }
}