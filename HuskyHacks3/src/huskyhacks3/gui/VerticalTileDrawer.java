package huskyhacks3.gui;

import huskyhacks3.world.data.Chunk;

import java.awt.*;

/**
 * Created by david on 9/30/2017.
 */
public class VerticalTileDrawer extends TileDrawer{
    @Override
    public void drawTile(Chunk chunk, int x, int y, Graphics2D graphics2D) {
        int height = chunk.getHeight(x, y);
        //between 0 and 512
        Color c = new Color(height/2, 20, height/2);
        graphics2D.setColor(c);
        graphics2D.fillRect(x * getSize(), y * getSize() , getSize(), getSize());
    }

    @Override
    public int getSize() {
        return 10;
    }
}
