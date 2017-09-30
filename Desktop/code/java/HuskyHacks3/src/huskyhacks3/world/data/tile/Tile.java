/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.data.tile;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Benjamin
 */
public class Tile {
    public static final int TILE_SIZE = 12;
    
    //------------------------------------------------------------
    
    public static final Tile EMPTY = new Tile(0);
    
    public static final Tile DIRT = new TerrainTile(1);
    public static final Tile WATER = new TerrainTile(2);
    public static final Tile GRASS = new TerrainTile(3);
    public static final Tile SAND = new TerrainTile(4);
    public static final Tile STONE = new TerrainTile(5);
    public static final Tile SNOW = new TerrainTile(6);
    public static final Tile ICE = new TerrainTile(7);
    
    public static final Tile TALL_GRASS = new EnvironmentTile(64);
    public static final Tile TREE_NORMAL = new EnvironmentTile(65);
    public static final Tile TREE_PINE = new EnvironmentTile(66);
    public static final Tile TREE_PALM = new EnvironmentTile(67);
    public static final Tile BUSH = new EnvironmentTile(68);
    public static final Tile DEAD_BUSH = new EnvironmentTile(69);
    public static final Tile BOULDER = new EnvironmentTile(70);
    public static final Tile SEAWEED = new EnvironmentTile(71);
    
    
    //------------------------------------------------------------
    
    public final int id;
    protected Tile(int n){
        id = n;
    }
    
    public BufferedImage getImage(int height){
        BufferedImage image = new BufferedImage(TILE_SIZE, TILE_SIZE, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        g2d.setColor(heightToColor(height));
        g2d.fillRect(0,0,image.getWidth(), image.getHeight());
        return image;
    }
    
    private Color heightToColor(int height){
        Color c;
        height /= 2;
	int value = height-height%8;
        if(height<2*128){
		c = new Color(value/2,value/2,value*2); //water
	    } else if(height<2*136){
		c = new Color(value*5/3,value*5/3,value); //sand
	    } else if(height<2*208){
		c = new Color(value/2,value,value/2); //grass
	    } else if(height<2*240){
		c = new Color(value,value*5/8,value*5/16); //dirt
	    } else {
		c = new Color(value,value,value); //snow
	    }
        return c;
    }
}
