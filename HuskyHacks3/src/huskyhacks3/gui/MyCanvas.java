package huskyhacks3.gui;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import huskyhacks3.world.data.Chunk;

import static java.lang.Math.floor;

/**
 * Created by david on 9/30/2017.
 */
public class MyCanvas extends Canvas {

    // represents the position of the top-left corner of the canvas
    int xPos, yPos;


    private ChunkRecorder chunks;

    public MyCanvas (Dimension mainFrameSize) {
        setBackground (Color.BLUE);
        setSize(mainFrameSize);
    }

    public void paint (Graphics g) {
        Graphics2D g2;
        g2 = (Graphics2D) g;
        drawChunks(g2);
        g2.setColor(Color.blue);
        g2.drawString ("It is a custom canvas area", 70, 70);
    }

    private void drawChunks(Graphics2D g2){
        int xMin, xMax, yMin, yMax, xOffset, yOffset;
        int chunkSize = chunks.getChunkSize();

        xMin = xPos / chunkSize;
        xMax = (xPos + getHeight()) / chunkSize;
        yMin = (yPos + getWidth()) / chunkSize;
        yMax = yPos / chunkSize;

        xOffset = xPos % chunkSize;
        yOffset = (yPos - getHeight()) % chunkSize;

        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                g2.drawImage(chunks.getChunkImage(x, y),
                        (x - xMin)*chunkSize - xOffset,
                        (y - yMin)*chunkSize - yOffset, null);
            }
        }
    }
}