package huskyhacks3.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.InfiniteGrid;

/**
 * Created by david on 9/30/2017.
 */
public class ChunkRecorder {
    InfiniteGrid<BufferedImage> chunkImages;
    TileDrawer tileDrawer;
    Controller controller;

    public ChunkRecorder(Controller controller) {
        chunkImages = new InfiniteGrid<>();
        this.controller = controller;
        this.tileDrawer = controller.tileDrawer;
    }

    public BufferedImage getChunkImage(int x, int y) {
        BufferedImage image = chunkImages.get(x, y);
        if (image == null) {
            BufferedImage newChunkImage = chunkImage(getChunk(x, y));
            chunkImages.set(newChunkImage, x, y);
            return newChunkImage;
        } else {
            return image;
        }
    }


    private Chunk getChunk(int x, int y) {
        return controller.world.get(x, y);
    }


    public int getChunkSize() {
        return Chunk.CHUNK_SIZE * tileDrawer.getSize();
    }

    private BufferedImage chunkImage(Chunk chunk) {
        BufferedImage image = new BufferedImage(getChunkSize(), getChunkSize(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = image.getGraphics();
        for (int x = 0; x < Chunk.CHUNK_SIZE; x++) {
            for (int y = 0; y < Chunk.CHUNK_SIZE; y++) {
                tileDrawer.drawTile(chunk, x, y, g);
            }
        }
        g.setColor(Color.cyan);
        g.drawRect(0, 0 , getChunkSize(), getChunkSize());
        return image;
    }
    
    
}