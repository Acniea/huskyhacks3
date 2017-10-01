package huskyhacks3.gui;

import huskyhacks3.world.data.Chunk;

import java.awt.*;

/**
 * Created by david on 9/30/2017.
 */
public class VerticalTileDrawer extends TileDrawer{
    @Override
    public void drawTile(Chunk chunk, int x, int y, Graphics2D graphics2D) {
        int height = 256*chunk.getHeight(x, y)/(Chunk.MAX_VALUE);
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
        graphics2D.setColor(c);
        graphics2D.fillRect(x * getSize(), y * getSize() , getSize(), getSize());
    }

    @Override
    public int getSize() {
        return 2;
    }
}