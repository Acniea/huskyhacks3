package huskyhacks3.gui;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by david on 9/30/2017.
 */
public class MyCanvas extends Canvas {
    Controller controller;


    private ChunkRecorder chunkRecorder;

    public MyCanvas(Dimension mainFrameSize, Controller controller, Controller.KeyboardListener keyboardListener) {
        this.controller = controller;
        chunkRecorder = new ChunkRecorder(controller);
        this.addKeyListener(keyboardListener);
        setSize((int) (mainFrameSize.width ), mainFrameSize.height);
        //for some reason x side runs off when set to full frame size
    }

    public void paint (Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(drawChunks(), 0, 0, null);
        g2.setColor(Color.red);
        g2.drawRect(0, 0, 50, 50);
    }

    private BufferedImage drawChunks(){
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) image.getGraphics();

        int xMin, xMax, yMin, yMax, xOffset, yOffset;
        int chunkSize = chunkRecorder.getChunkSize();

        int xPos = controller.getX(), yPos = controller.getY();

        System.out.println(Integer.toString(xPos) + ", " + Integer.toString(yPos));

        xMin = xPos / chunkSize;
        xMax = (xPos + getWidth()) / chunkSize;
        yMin = yPos  / chunkSize;
        yMax = (yPos + getHeight())/ chunkSize;

        xOffset = xPos % chunkSize;
        yOffset = yPos % chunkSize;

        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                g2d.drawImage(chunkRecorder.getChunkImage(x, y),
                        (x - xMin)*chunkSize - xOffset,
                        (y - yMin)*chunkSize - yOffset, null);
            }
        }
        return image;
    }

    private void focus(){
        this.requestFocus();
    }
}