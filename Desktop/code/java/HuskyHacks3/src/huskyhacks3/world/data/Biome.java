/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.data;

import huskyhacks3.util.IFunc;
import huskyhacks3.world.data.tile.EnvironmentTile;
import huskyhacks3.world.data.tile.TerrainTile;
import huskyhacks3.world.data.tile.Tile;
import huskyhacks3.world.generation.Generator;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Benjamin
 */
public class Biome {
    static IFunc F_BIOME_ROUGHNESS = IFunc.constant(0);
    static IFunc F_BIOME_SCALE = IFunc.constant(0.3);
    
    public static final List<Biome> BIOMES = new ArrayList<>();
    
    public static final Biome OCEAN_TRENCH = new Biome(new Tile[]{Tile.EMPTY}, new double[]{1}, 
                                                new Tile[]{Tile.STONE}, new double[]{1});
    public static final Biome DEEP_OCEAN = new Biome(new Tile[]{Tile.EMPTY}, new double[]{1}, 
                                                new Tile[]{Tile.SAND, Tile.STONE}, new double[]{0.9, 0.1});
    public static final Biome MID_OCEAN = new Biome(new Tile[]{Tile.EMPTY}, new double[]{1}, 
                                                new Tile[]{Tile.SAND, Tile.STONE}, new double[]{0.9, 0.1});
    public static final Biome SHALLOW_OCEAN = new Biome(new Tile[]{Tile.EMPTY}, new double[]{1}, 
                                                new Tile[]{Tile.SAND, Tile.STONE}, new double[]{0.9, 0.1});
    public static final Biome BEACH = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_PALM}, new double[]{.95, .05}, 
                                               new Tile[]{Tile.SAND}, new double[]{1});
    public static final Biome FOREST = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_NORMAL, Tile.TREE_PINE, Tile.BUSH, Tile.TALL_GRASS}, new double[]{.05, .15, .15, 0.1, 0.55}, 
                                               new Tile[]{Tile.GRASS, Tile.DIRT}, new double[]{0.9, 0.1});
    public static final Biome RAIN_FOREST = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_NORMAL, Tile.TREE_PINE, Tile.BUSH, Tile.TALL_GRASS}, new double[]{.05, .3, .3, 0.15, 0.2}, 
                                               new Tile[]{Tile.GRASS, Tile.DIRT}, new double[]{0.9, 0.1});
    public static final Biome TAIGA = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_NORMAL, Tile.TREE_PINE, Tile.BUSH, Tile.TALL_GRASS}, new double[]{.05, .15, .15, 0.1, 0.55}, 
                                               new Tile[]{Tile.GRASS, Tile.DIRT, Tile.SNOW}, new double[]{0.1, 0.1, 0.8});
    public static final Biome PLAIN = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_NORMAL, Tile.TREE_PINE, Tile.TALL_GRASS, Tile.BUSH, Tile.BOULDER}, new double[]{.35, .01, .01, .6, 0.02, 0.01}, 
                                               new Tile[]{Tile.GRASS, Tile.DIRT}, new double[]{0.9, 0.1});
    public static final Biome DESERT = new Biome(new Tile[]{Tile.EMPTY, Tile.DEAD_BUSH, Tile.BOULDER}, new double[]{.95, .04, 0.01}, 
                                               new Tile[]{Tile.SAND, Tile.DIRT}, new double[]{0.9, 0.1});
    public static final Biome LOW_MOUNTAIN = new Biome(new Tile[]{Tile.EMPTY, Tile.DEAD_BUSH}, new double[]{.95, .05}, 
                                               new Tile[]{Tile.DIRT, Tile.GRASS, Tile.STONE}, new double[]{.33,.33,.34});
    public static final Biome MOUNTAIN = new Biome(new Tile[]{Tile.EMPTY, Tile.DEAD_BUSH}, new double[]{.95, .05}, 
                                               new Tile[]{Tile.STONE}, new double[]{1});
    public static final Biome HIGH_MOUNTAIN = new Biome(new Tile[]{Tile.EMPTY}, new double[]{1}, 
                                               new Tile[]{Tile.STONE, Tile.SNOW, Tile.ICE}, new double[]{0.2, 0.6, 0.2});
    
    
    public static final int HEIGHT_GRADATION = 16;
    public static final int PRECIP_GRADATION = 4;
    public static final int TEMP_GRADATION = 4;
    public static final Biome[][][] THE_CUBE = new Biome[HEIGHT_GRADATION][PRECIP_GRADATION][TEMP_GRADATION];
    static {
        for(int precip=0; precip < PRECIP_GRADATION; precip++){
            for(int temp=0; temp < TEMP_GRADATION; temp++){
                THE_CUBE[0][precip][temp] = OCEAN_TRENCH;
                THE_CUBE[1][precip][temp] = DEEP_OCEAN;
                THE_CUBE[2][precip][temp] = DEEP_OCEAN;
                THE_CUBE[3][precip][temp] = DEEP_OCEAN;
                THE_CUBE[4][precip][temp] = MID_OCEAN;
                THE_CUBE[5][precip][temp] = MID_OCEAN;
                THE_CUBE[6][precip][temp] = MID_OCEAN;
                THE_CUBE[7][precip][temp] = SHALLOW_OCEAN;
                THE_CUBE[8][precip][temp] = BEACH;
            }
        }
        
        for(int precip=0; precip < PRECIP_GRADATION; precip++){
            for(int temp=0; temp < TEMP_GRADATION; temp++){
                if(precip<PRECIP_GRADATION/2 && temp<TEMP_GRADATION/2){
                    THE_CUBE[9][precip][temp] = PLAIN;
                    THE_CUBE[10][precip][temp] = PLAIN;
                    THE_CUBE[11][precip][temp] = PLAIN;
                    THE_CUBE[12][precip][temp] = PLAIN;
                    THE_CUBE[13][precip][temp] = LOW_MOUNTAIN;
                    THE_CUBE[14][precip][temp] = MOUNTAIN;
                    THE_CUBE[15][precip][temp] = HIGH_MOUNTAIN;
                }
                if(precip<PRECIP_GRADATION/2 && temp>=TEMP_GRADATION/2){
                    THE_CUBE[9][precip][temp] = DESERT;
                    THE_CUBE[10][precip][temp] = DESERT;
                    THE_CUBE[11][precip][temp] = DESERT;
                    THE_CUBE[12][precip][temp] = DESERT;
                    THE_CUBE[13][precip][temp] = LOW_MOUNTAIN;
                    THE_CUBE[14][precip][temp] = MOUNTAIN;
                    THE_CUBE[15][precip][temp] = HIGH_MOUNTAIN;
                }
                if(precip>=PRECIP_GRADATION/2 && temp<TEMP_GRADATION/2){
                    THE_CUBE[9][precip][temp] = TAIGA;
                    THE_CUBE[10][precip][temp] = TAIGA;
                    THE_CUBE[11][precip][temp] = TAIGA;
                    THE_CUBE[12][precip][temp] = TAIGA;
                    THE_CUBE[13][precip][temp] = LOW_MOUNTAIN;
                    THE_CUBE[14][precip][temp] = MOUNTAIN;
                    THE_CUBE[15][precip][temp] = HIGH_MOUNTAIN;
                }
                if(precip>=PRECIP_GRADATION/2 && temp>=TEMP_GRADATION/2){
                    THE_CUBE[9][precip][temp] = RAIN_FOREST;
                    THE_CUBE[10][precip][temp] = RAIN_FOREST;
                    THE_CUBE[11][precip][temp] = RAIN_FOREST;
                    THE_CUBE[12][precip][temp] = RAIN_FOREST;
                    THE_CUBE[13][precip][temp] = LOW_MOUNTAIN;
                    THE_CUBE[14][precip][temp] = MOUNTAIN;
                    THE_CUBE[15][precip][temp] = HIGH_MOUNTAIN;
                }
            }
        }
        /*
        THE_CUBE[8][0][0] = MID_OCEAN;
        THE_CUBE[8][0][1] = MID_OCEAN;
        THE_CUBE[8][0][2] = MID_OCEAN;
        THE_CUBE[8][0][3] = MID_OCEAN;
        THE_CUBE[8][1][0] = MID_OCEAN;
        THE_CUBE[8][1][1] = MID_OCEAN;
        THE_CUBE[8][1][2] = MID_OCEAN;
        THE_CUBE[8][1][3] = MID_OCEAN;
        THE_CUBE[8][2][0] = MID_OCEAN;
        THE_CUBE[8][2][1] = MID_OCEAN;
        THE_CUBE[8][2][2] = MID_OCEAN;
        THE_CUBE[8][2][3] = MID_OCEAN;
        THE_CUBE[8][3][0] = MID_OCEAN;
        THE_CUBE[8][3][1] = MID_OCEAN;
        THE_CUBE[8][3][2] = MID_OCEAN;
        THE_CUBE[8][3][3] = MID_OCEAN;*/
        
        
    }
    
    public static final Biome getBiome(int height, int precip, int temp){
        int h = height/(Chunk.MAX_VALUE/HEIGHT_GRADATION);
        int p = precip/(Chunk.MAX_VALUE/PRECIP_GRADATION);
        int t = temp/(Chunk.MAX_VALUE/TEMP_GRADATION);
        return THE_CUBE[h][p][t];
    }
    
    
    private final int X_OFF, Y_OFF;
    private final List<TileEntry> eTileEntries;
    private final List<TileEntry> tTileEntries;
    
    private Biome(Tile[] e_tiles, double[] e_probs, Tile[] t_tiles, double[] t_probs){
        if(e_tiles.length != e_probs.length || t_tiles.length != t_probs.length){
            throw new Error("array dim mismatch");
        }
        BIOMES.add(this);
        eTileEntries = new ArrayList<>();
        tTileEntries = new ArrayList<>();
        
        double epSum = 0;
        for(int i=0; i<e_probs.length; i++){
            epSum += e_probs[i];
        }        
        for(int i=0; i<e_probs.length; i++){
            e_probs[i] /= epSum;
        }
        
        for(int i=0; i<e_tiles.length; i++){
            eTileEntries.add(new TileEntry(e_tiles[i], e_probs[i]));
        }
        
        
        double tpSum = 0;
        for(int i=0; i<t_probs.length; i++){
            tpSum += t_probs[i];
        }        
        for(int i=0; i<t_probs.length; i++){
            t_probs[i] /= tpSum;
        }
        
        for(int i=0; i<t_tiles.length; i++){
            tTileEntries.add(new TileEntry(t_tiles[i], t_probs[i]));
        }
        
        X_OFF = (int)((Math.random()-0.5)*2*Integer.MAX_VALUE);
        Y_OFF = (int)((Math.random()-0.5)*2*Integer.MAX_VALUE);
    }
    
    public Tile getETile(int x, int y){
        return getETileFromRandom(x, y);
    }
    
    public Tile getTTile(int x, int y){
        return getTTileFromRandom(x, y);
    }
    
    private Tile getETileFromRandom(int x, int y){
        double d0 = Math.random();
        
        for(int i=0; i<eTileEntries.size(); i++){
            d0 -= eTileEntries.get(i).prob;
            if(d0 < 0){
                return eTileEntries.get(i).tile;
            }
        }
        return eTileEntries.get(eTileEntries.size()-1).tile;
    }
    
    private Tile getTTileFromRandom(int x, int y){
        double d0 = Math.random();
        
        for(int i=0; i<tTileEntries.size(); i++){
            d0 -= tTileEntries.get(i).prob;
            if(d0 < 0){
                return tTileEntries.get(i).tile;
            }
        }
        return tTileEntries.get(tTileEntries.size()-1).tile;
    }
    
    private Tile getETileFromCoords(int x, int y){
        int max = eTileEntries.get(0).value(x, y);
        TileEntry maxTileEntry = eTileEntries.get(0);
        
        for(int i=1; i<eTileEntries.size(); i++){
            TileEntry te = eTileEntries.get(i);
            int val = te.value(x, y);
            if(max<val){
                max = val;
                maxTileEntry = te;
            }
        }
        
        return maxTileEntry.tile;
    }
    
    private Tile getTTileFromCoords(int x, int y){
        int max = tTileEntries.get(0).value(x, y);
        TileEntry maxTileEntry = tTileEntries.get(0);
        
        for(int i=1; i<tTileEntries.size(); i++){
            TileEntry te = tTileEntries.get(i);
            int val = te.value(x, y);
            if(max<val){
                max = val;
                maxTileEntry = te;
            }
        }
        
        return maxTileEntry.tile;
    }
    
    private static class TileEntry {
        static IFunc F_TILE_ROUGHNESS = IFunc.constant(0);
        static IFunc F_TILE_SCALE = IFunc.constant(0.03);
        
        Tile tile;
        double prob;
        int x_off, y_off;
        
        public TileEntry(Tile t0, double p0){
            tile = t0;
            prob = p0;
            
            x_off = (int)((Math.random()-0.5)*2*Integer.MAX_VALUE);
            y_off = (int)((Math.random()-0.5)*2*Integer.MAX_VALUE);
        }
        
        public int value(int x, int y){
            return (int)(prob*Generator.scaledNoise(x+x_off, y+y_off, F_TILE_ROUGHNESS, F_TILE_SCALE));
        }
    }
    
    public int value(int x, int y){
        return Generator.scaledNoise(x+X_OFF, y+Y_OFF, F_BIOME_ROUGHNESS, F_BIOME_SCALE);
    }
}
