/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.gui;

import huskyhacks3.world.data.tile.Tile;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Benjamin
 */
public class ImageImporter {
    
    static List<Sprite> inputs;
    static String[] files = new String[]{"tile_00", "tile_01", "tile_02", "tile_03", "tile_04", "tile_05", "tile_06", "tile_07", 
                                         "tile_64", "tile_65", "tile_66", "tile_67", "tile_68", "tile_69", "tile_70", "tile_71"};
    
    public static void importFiles() throws IOException {
        BufferedImage temp;
        for(String s : files){
            temp = ImageIO.read(new File("\\resources\\"+s));
            inputs.add(new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                  temp.getHeight()/2-Tile.TILE_SIZE/2, temp, s));
        }
    }
}
