package huskyhacks3.gui;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.World;
import huskyhacks3.world.data.tile.Tile;

import java.awt.*;

/**
 * Created by david on 9/30/2017.
 */
public class VerticalTileDrawer extends TileDrawer{
    @Override
    public void drawTile(Chunk chunk, int x, int y, Graphics g) {
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
        if(x==0 || x == Chunk.CHUNK_SIZE-1 || y==0 || y == Chunk.CHUNK_SIZE-1){
            u=d=l=r=false;
        } else {
            u = /*((height - chunk.getHeight(x,y-1))>=1) && */(height == chunk.getHeight(x,y-1));
            d = /*((height - chunk.getHeight(x,y+1))>=1) && */(height == chunk.getHeight(x,y+1));
            l = /*((height - chunk.getHeight(x-1,y))>=1) && */(height == chunk.getHeight(x-1,y));
            r = /*((height - chunk.getHeight(x+1,y))>=1) && */(height == chunk.getHeight(x+1,y));
        }
//        u = !u;
//        r = !r;
//        d = !d;
//        l = !l;
        if(chunk.getHeight(x, y)>Chunk.OCEAN_LEVEL){
            g.drawImage(TileBorderifier.trumpify(ImageImporter.getImage(chunk.getSurface(x,y)), Color.BLACK, l, r, u, d),x*getSize(),y*getSize(),null);
            g.drawImage(ImageImporter.getImage(chunk.getEnvironment(x,y)),x*getSize(),y*getSize(),null);
        } else {
            g.drawImage(ImageImporter.getImage(Tile.WATER), x*getSize(), y*getSize(), null);
        }
        if(height == 280){
            g.drawImage(TileBorderifier.trumpify(ImageImporter.getImage(Tile.WATER), Color.BLACK, l, r, u, d), x*getSize(), y*getSize(), null);
        }
    }

    @Override
    public int getSize() {
        return 12;
    }
}