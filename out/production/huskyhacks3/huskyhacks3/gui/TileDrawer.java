package huskyhacks3.gui;




import huskyhacks3.world.data.Chunk;
import java.awt.Graphics;

import java.awt.Graphics2D;


/**
 * Created by david on 9/29/2017.
 */
public abstract class TileDrawer {

    /**
     * Draws the tile at position (x, y) in the chunk
     */
    public abstract void drawTile(Chunk chunk, int x, int y, Graphics g);

    public abstract int getSize();
}