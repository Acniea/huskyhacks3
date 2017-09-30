package huskyhacks3.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

import huskyhacks3.world.data.Chunk;

/**
 * Created by david on 9/30/2017.
 */
public class SurfaceChunkImage {

    private BufferedImage image;
    private TileDrawer tileDrawer;
    private Chunk chunk;

    public SurfaceChunkImage(TileDrawer t, Chunk chunk) {
        this.tileDrawer = t;
        this.chunk = chunk;
        int length = Chunk.CHUNK_SIZE * tileDrawer.getSize();
        this.image = new BufferedImage(length, length, BufferedImage.TYPE_INT_ARGB);
        drawTiles();
    }

    private void drawTiles() {
        Graphics2D g2d = image.createGraphics();
        for (int x = 0; x < Chunk.CHUNK_SIZE; x++) {
            for (int y = 0; y < Chunk.CHUNK_SIZE; y++) {
                g2d.drawImage(tileDrawer.drawTile(chunk, x, y),
                        x * tileDrawer.getSize(), y * tileDrawer.getSize(), null);
            }
        }
    }

    public BufferedImage getImage(){
        return image;
    }
}
