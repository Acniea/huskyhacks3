package huskyhacks3.gui;

import java.awt.image.BufferedImage;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.InfiniteGrid;

/**
 * Created by david on 9/30/2017.
 */
public class ChunkRecorder {
    InfiniteGrid<SurfaceChunkImage> chunkImages;
    TileDrawer tileDrawer;
    Controller controller;

    public ChunkRecorder(Controller controller) {
        chunkImages = new InfiniteGrid<>();
        this.controller = controller;
        this.tileDrawer = controller.getTileDrawer();
    }

    public BufferedImage getChunkImage(int x, int y) {
        SurfaceChunkImage chunkImage = chunkImages.get(x, y);
        if (chunkImage == null) {
            SurfaceChunkImage newChunkImage = drawChunk(x, y);
            chunkImages.set(newChunkImage, x, y);
            return newChunkImage.getImage();
        } else {
            return chunkImage.getImage();
        }
    }

    private SurfaceChunkImage drawChunk(int x, int y) {
        return new SurfaceChunkImage(tileDrawer, getChunk(x, y));
    }

    private Chunk getChunk(int x, int y) {
        return controller.getChunk(x, y);
    }


    public int getChunkSize() {
        return Chunk.CHUNK_SIZE * tileDrawer.getSize();
    }


}