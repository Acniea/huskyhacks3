package huskyhacks3.gui;

import huskyhacks3.world.data.Chunk;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by david on 9/30/2017.
 */
public class VerticalTileDrawer extends TileDrawer{
    @Override
    public BufferedImage drawTile(Chunk chunk, int tileX, int tileY) {
        System.out.println("hello");
        BufferedImage image = new BufferedImage(getSize(), getSize(), BufferedImage.TYPE_INT_ARGB);
        int height = chunk.getHeight(tileX, tileY);
        //between 0 and 512
        Color c = new Color(height/2, height/2, height/2);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(c);
        g2.fillRect(0, 0, getSize(), getSize());
        return image;
    }

    @Override
    public int getSize() {
        return 5;
    }
}
