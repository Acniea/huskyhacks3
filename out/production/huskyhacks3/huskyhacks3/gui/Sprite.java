/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.gui;

import java.awt.image.BufferedImage;

/**
 *
 * @author Benjamin
 */
public class Sprite {
    public int xoff, yoff;
    public BufferedImage image;
    public String name;
    
    public Sprite(int x, int y, BufferedImage bi, String n){
        xoff = x;
        yoff = y;
        image = bi;
        name = n;
    }
}
