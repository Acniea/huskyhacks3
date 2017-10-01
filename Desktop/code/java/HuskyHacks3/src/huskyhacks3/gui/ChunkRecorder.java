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
        this.tileDrawer = controller.getTileDrawer();
    }

    public BufferedImage getChunkImage(int x, int y) {
        BufferedImage image = chunkImages.get(x, y);
        if (image == null) {
            BufferedImage newChunkImage = drawChunk(getChunk(x, y));
            chunkImages.set(newChunkImage, x, y);
            return newChunkImage;
        } else {
            return image;
        }
    }


    private Chunk getChunk(int x, int y) {
        return controller.getChunk(x, y);
    }


    public int getChunkSize() {
        return Chunk.CHUNK_SIZE * tileDrawer.getSize();
    }

    private BufferedImage drawChunk(Chunk chunk) {
        BufferedImage image = new BufferedImage(getChunkSize(), getChunkSize(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        for (int x = 0; x < Chunk.CHUNK_SIZE; x++) {
            for (int y = 0; y < Chunk.CHUNK_SIZE; y++) {
                tileDrawer.drawTile(chunk, x, y, g2d);
            }
        }
//        g2d.setColor(Color.cyan);
//        g2d.drawRect(0, 0 , getChunkSize(), getChunkSize());
        return image;
    }
}