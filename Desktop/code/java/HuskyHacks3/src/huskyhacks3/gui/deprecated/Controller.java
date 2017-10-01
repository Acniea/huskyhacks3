package huskyhacks3.gui.deprecated;

import huskyhacks3.gui.TileDrawer;
import huskyhacks3.gui.VerticalTileDrawer;
import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.World;

/**
 * Created by david on 9/30/2017.
 */
public class Controller {

    World world;
    MyGUI gui;
    TileDrawer tileDrawer;

    public Controller(){
        this.tileDrawer = new VerticalTileDrawer();
        this.world = new World();
        this.gui = new MyGUI(this);
    }

    public Chunk getChunk(int x, int y) {
        return world.get(x, y);
    }

    public TileDrawer getTileDrawer(){
        return tileDrawer;
    }




}