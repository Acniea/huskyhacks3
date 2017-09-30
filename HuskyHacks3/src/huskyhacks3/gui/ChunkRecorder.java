package huskyhacks3.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.GriddedList;
import huskyhacks3.world.data.InfiniteGrid;

/**
 * Created by david on 9/30/2017.
 */
public class ChunkRecorder {
    InfiniteGrid<SurfaceChunkImage> chunks;
    TileDrawer tileDrawer;

    public ChunkRecorder(TileDrawer tileDrawer) {
        chunks = new InfiniteGrid<>();
        this.tileDrawer = tileDrawer;
    }

    public BufferedImage getChunkImage(int x, int y) {
//        SurfaceChunkImage chunkImage = chunks.get(x, y);
//        if (chunkImage == null) {
//            SurfaceChunkImage newChunk = drawChunk(x, y);
//            chunks.set(newChunk, x, y);
//            return newChunk.getImage();
//        }
//        else {
//            return chunkImage.getImage();
//        }
        BufferedImage image = new BufferedImage(getChunkSize(), getChunkSize(), BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        g2.setColor(Color.cyan);
        g2.drawRect(5, 5, getChunkSize() - 10, getChunkSize() - 10);
        return image;
    }

    private SurfaceChunkImage drawChunk(int x, int y) {
        return new SurfaceChunkImage(tileDrawer, getChunk(x, y));
    }

    private Chunk getChunk(int x, int y) {
        //todo implement
        return null;
    }


    public int getChunkSize() {
        return Chunk.CHUNK_SIZE * 2;//tileDrawer.getSize();
    }


}