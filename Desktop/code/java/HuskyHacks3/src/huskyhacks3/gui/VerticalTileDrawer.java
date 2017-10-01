package huskyhacks3.gui;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.World;
import huskyhacks3.world.data.tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by david on 9/30/2017.
 */
public class VerticalTileDrawer extends TileDrawer{
    @Override
    public void drawTile(World w, int cx, int cy, int x, int y, Graphics g) {
        Chunk chunk = w.get(cx, cy);
        /*int height = 256*chunk.getHeight(x, y)/(Chunk.MAX_VALUE);
        //between 0 and 512
        //Color c = new Color(height/2, height/2, height/2);
        Color c;
        int value = height-height%8;

        if(height<128){
            c = new Color(value/2,value/2,value*2); //water
        } else if(height<136){
            c = new Color(value*5/3,value*5/3,value); //sand
        } else if(height<208){
            c = new Color(value/2,value,value/2); //grass
        } else if(height<240){
            c = new Color(value,value*5/8,value*5/16); //dirt
        } else {
            c = new Color(value,value,value); //snow
        }
        g.setColor(c);
        g.fillRect(x * getSize(), y * getSize() , getSize(), getSize());*/
        int height = chunk.getHeight(x,y);
        boolean u=false, d=false, l=false, r=false;
        if(y==0){
            u = height<w.get(cx, cy-1).getHeight(x, Chunk.CHUNK_SIZE-1);
        } else {
            u = height<chunk.getHeight(x,y-1);
        }
        if(y==Chunk.CHUNK_SIZE-1){
            d = height<w.get(cx, cy+1).getHeight(x, 0);
        } else {
            d = height<chunk.getHeight(x,y+1);
        }
        if(x==0){
            l = height<w.get(cx-1, cy).getHeight(Chunk.CHUNK_SIZE-1, y);
        } else {
            l = height<chunk.getHeight(x-1,y);
        }
        if(x==Chunk.CHUNK_SIZE-1){
            r = height<w.get(cx+1, cy).getHeight(0, y);
        } else {
            r = height<chunk.getHeight(x+1,y);
        }
        /*if(x==0 || x == Chunk.CHUNK_SIZE-1 || y==0 || y == Chunk.CHUNK_SIZE-1){
            u=d=l=r=false;
        } else {
            u = chunk.getHeight(x,y)<chunk.getHeight(x,y-1);
            d = chunk.getHeight(x,y)<chunk.getHeight(x,y+1);
            l = chunk.getHeight(x,y)<chunk.getHeight(x-1,y);
            r = chunk.getHeight(x,y)<chunk.getHeight(x+1,y);
        }*/
        //System.out.println(x+" "+y);
        //System.out.println(u+" "+d+" "+l+" "+r);
        ImageImporter.getSprite(chunk.getSurface(x,y), l, r, u, d).draw(g,x*getSize(),y*getSize());
        ImageImporter.getSprite(chunk.getEnvironment(x,y)).draw(g,x*getSize(),y*getSize());
        if(chunk.getHeight(x, y)<=Chunk.OCEAN_LEVEL){
            g.drawImage(ImageImporter.getImage(Tile.WATER), x*getSize(), y*getSize(), null);
        }
    }

    @Override
    public int getSize() {
        return 12;
    }
}