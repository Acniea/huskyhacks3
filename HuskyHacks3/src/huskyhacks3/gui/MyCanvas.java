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


    public MyCanvas (Dimension mainFrameSize) {
        setBackground (Color.BLUE);
        setSize(mainFrameSize);
    }

    public void paint (Graphics g) {
        Graphics2D g2;
        g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        g2.drawString ("It is a custom canvas area", 70, 70);
    }
}