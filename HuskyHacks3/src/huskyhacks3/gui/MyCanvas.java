package huskyhacks3.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import huskyhacks3.world.data.Chunk;

import static java.lang.Math.floor;

/**
 * Created by david on 9/30/2017.
 */
public class MyCanvas extends Canvas {

    // represents the position of the top-left corner of the canvas
    int xPos = 0, yPos  = 0;


    private ChunkRecorder chunks;

    public MyCanvas (Dimension mainFrameSize, TileDrawer tileDrawer) {
        chunks = new ChunkRecorder(tileDrawer);
        setBackground (Color.WHITE);
        setSize((int) (mainFrameSize.width * .99), mainFrameSize.height);
        //for some reason x side runs off when set to full frame size
    }

    public void paint (Graphics g) {
        Graphics2D g2;
        g2 = (Graphics2D) g;
        drawChunks(g2);
        g2.setColor(Color.red);
        g2.drawRect(0, 0, 50, 50);
    }

    private void drawChunks(Graphics2D g2){
        int xMin, xMax, yMin, yMax, xOffset, yOffset;
        int chunkSize = chunks.getChunkSize();

        xMin = xPos / chunkSize;
        xMax = (xPos + getWidth()) / chunkSize;
        yMin = yPos  / chunkSize;
        yMax = (yPos + getHeight())/ chunkSize;

        xOffset = xPos % chunkSize;
        yOffset = yPos % chunkSize;

        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                g2.drawImage(chunks.getChunkImage(x, y),
                        (x - xMin)*chunkSize - xOffset,
                        (y - yMin)*chunkSize - yOffset, null);
            }
        }
    }

    private void focus(){
        this.requestFocus();
    }
}