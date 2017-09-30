package huskyhacks3.gui;

import java.awt.image.BufferedImage;

import huskyhacks3.world.data.Tile;

/**
 * Created by david on 9/29/2017.
 */
public abstract class TileDrawer {
    public abstract BufferedImage drawTile(Tile tile);
    public abstract int getSize();
}
