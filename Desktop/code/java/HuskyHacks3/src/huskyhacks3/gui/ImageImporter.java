/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.gui;

import huskyhacks3.gui.Sprite;
import huskyhacks3.world.data.tile.Tile;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Benjamin
 */
public class ImageImporter {
    
    static List<Sprite> sprites = new ArrayList<Sprite>();
    static String[] files = new String[]{"tile_0", "tile_1", "tile_2", "tile_3", "tile_4", "tile_5", "tile_6", "tile_7", 
                                         "tile_64", "tile_65", "tile_66", "tile_67", "tile_68", "tile_69", "tile_70", "tile_71"};
    static {
        try {
            importFiles();
        } catch (IOException ex) {
            Logger.getLogger(ImageImporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void importFiles() throws IOException {
        BufferedImage temp;
        for(String s : files){
            temp = ImageIO.read(new File("C:\\Users\\Benjamin\\Desktop\\code\\java\\HuskyHacks3\\src\\resources\\"+s+".png"));
            sprites.add(new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                  temp.getHeight()/2-Tile.TILE_SIZE/2, temp, s));
        }
    }
    
    public static BufferedImage getImage(Tile t){
        for(int i=0; i<sprites.size(); i++){
            if(sprites.get(i).name.equals("tile_"+Integer.toString(t.id))){
                return sprites.get(i).image;
            }
        }
        return null;
    }
}
