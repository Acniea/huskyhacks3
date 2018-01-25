/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.gui;

import huskyhacks3.gui.Sprite;
import huskyhacks3.world.data.tile.Tile;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
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
    static int WATER_OPACITY = 100;
    static List<Sprite[]> sprites = new ArrayList<Sprite[]>();
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
        Color c = new Color(0,0,0,75);
        for(String s : files){
            temp = ImageIO.read(new File("C:\\Users\\Benjamin\\Desktop\\code\\java\\HuskyHacks3\\src\\resources\\"+s+".png"));
            Sprite spr = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                  temp.getHeight()/2-Tile.TILE_SIZE/2, temp, s);
            Sprite[] sprs = new Sprite[16];
            sprs[0] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, false, false, false),
                                 s);
            sprs[1] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, false, false, true),
                                 s);
            sprs[2] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, false, true, false),
                                 s);
            sprs[3] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, false, true, true),
                                 s);
            sprs[4] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, true, false, false),
                                 s);
            sprs[5] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, true, false, true),
                                 s);
            sprs[6] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, true, true, false),
                                 s);
            sprs[7] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, false, true, true, true),
                                 s);
            sprs[8] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, false, false, false),
                                 s);
            sprs[9] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, false, false, true),
                                 s);
            sprs[10] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, false, true, false),
                                 s);
            sprs[11] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, false, true, true),
                                 s);
            sprs[12] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, true, false, false),
                                 s);
            sprs[13] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, true, false, true),
                                 s);
            sprs[14] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, true, true, false),
                                 s);
            sprs[15] = new Sprite(temp.getWidth()/2-Tile.TILE_SIZE/2, 
                                 temp.getHeight()/2-Tile.TILE_SIZE/2,
                                 TileBorderifier.trumpify(deepCopy(spr.image), c, true, true, true, true),
                                 s);
            sprites.add(sprs);
        }
        for(int i=0; i<sprites.get(1).length; i++){
            BufferedImage image = sprites.get(1)[i].image;
            BufferedImage resultImg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    Color color = new Color(image.getRGB(x, y));
                    Color maskedColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), WATER_OPACITY);
                    resultImg.setRGB(x, y, maskedColor.getRGB());
                    Graphics g = resultImg.getGraphics();
                    g.setColor(maskedColor);
                    g.drawRect(x,y,0,0);
                }
            }
            sprites.get(1)[i].image = resultImg;
        }
    }
    
    public static BufferedImage getImage(Tile t){
        for(int i=0; i<sprites.size(); i++){
            if(sprites.get(i)[0].name.equals("tile_"+Integer.toString(t.id))){
                return sprites.get(i)[0].image;
            }
        }
        return null;
    }
    
    public static BufferedImage getImage(Tile t, boolean l, boolean r, boolean u, boolean d){
        int index=0;
        if(l) index+=8;
        if(r) index+=4;
        if(u) index+=2;
        if(d) index+=1;
        
        for(int i=0; i<sprites.size(); i++){
            if(sprites.get(i)[index].name.equals("tile_"+Integer.toString(t.id))){
                return sprites.get(i)[index].image;
            }
        }
        return null;
    }
    
    public static Sprite getSprite(Tile t){
        for(int i=0; i<sprites.size(); i++){
            if(sprites.get(i)[0].name.equals("tile_"+Integer.toString(t.id))){
                return sprites.get(i)[0];
            }
        }
        return null;
    }
    
    public static Sprite getSprite(Tile t, boolean l, boolean r, boolean u, boolean d){
        int index=0;
        if(l) index+=8;
        if(r) index+=4;
        if(u) index+=2;
        if(d) index+=1;
        
        for(int i=0; i<sprites.size(); i++){
            if(sprites.get(i)[index].name.equals("tile_"+Integer.toString(t.id))){
                return sprites.get(i)[index];
            }
        }
        return null;
    }
    
    static BufferedImage deepCopy(BufferedImage bi) {
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        return new BufferedImage(cm, raster, isAlphaPremultiplied, null);
    }
}
