package huskyhacks3.gui;

import java.awt.image.BufferedImage;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.tile.Tile;

/**
 * Created by david on 9/29/2017.
 */
public abstract class TileDrawer {

    public abstract BufferedImage drawTile(Chunk chunk, int x, int y);

    public abstract int getSize();
}
