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
    static IFunc F_BIOME_SCALE = IFunc.constant(0.03);
    
    public static final List<Biome> BIOMES = new ArrayList<>();
    
    public static final Biome OCEAN = new Biome(new Tile[]{Tile.EMPTY}, new double[]{1}, 
                                                new Tile[]{Tile.SAND, Tile.STONE}, new double[]{0.9, 0.1});
    public static final Biome FOREST = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_NORMAL, Tile.TREE_PINE, Tile.BUSH}, new double[]{.6, .2, .15, .05}, 
                                               new Tile[]{Tile.GRASS, Tile.DIRT}, new double[]{0.9, 0.1});
    public static final Biome LAND = new Biome(new Tile[]{Tile.EMPTY, Tile.TREE_NORMAL, Tile.TREE_PINE, Tile.BUSH}, new double[]{.35, .3, .3, 0.05}, 
                                               new Tile[]{Tile.GRASS, Tile.DIRT}, new double[]{0.9, 0.1});
    
    public static final int HEIGHT_GRADATION = 8;
    public static final int PRECIP_GRADATION = 4;
    public static final int TEMP_GRADATION = 4;
    public static final Biome[][][] THE_CUBE = new Biome[HEIGHT_GRADATION][PRECIP_GRADATION][TEMP_GRADATION];
    static {
        THE_CUBE[0][0][0] = OCEAN;
        THE_CUBE[0][0][1] = OCEAN;
        THE_CUBE[0][0][2] = OCEAN;
        THE_CUBE[0][0][3] = OCEAN;
        THE_CUBE[0][1][0] = OCEAN;
        THE_CUBE[0][1][1] = OCEAN;
        THE_CUBE[0][1][2] = OCEAN;
        THE_CUBE[0][1][3] = OCEAN;
        THE_CUBE[0][2][0] = OCEAN;
        THE_CUBE[0][2][1] = OCEAN;
        THE_CUBE[0][2][2] = OCEAN;
        THE_CUBE[0][2][3] = OCEAN;
        THE_CUBE[0][3][0] = OCEAN;
        THE_CUBE[0][3][1] = OCEAN;
        THE_CUBE[0][3][2] = OCEAN;
        THE_CUBE[0][3][3] = OCEAN;
        
        THE_CUBE[1][0][0] = OCEAN;
        THE_CUBE[1][0][1] = OCEAN;
        THE_CUBE[1][0][2] = OCEAN;
        THE_CUBE[1][0][3] = OCEAN;
        THE_CUBE[1][1][0] = OCEAN;
        THE_CUBE[1][1][1] = OCEAN;
        THE_CUBE[1][1][2] = OCEAN;
        THE_CUBE[1][1][3] = OCEAN;
        THE_CUBE[1][2][0] = OCEAN;
        THE_CUBE[1][2][1] = OCEAN;
        THE_CUBE[1][2][2] = OCEAN;
        THE_CUBE[1][2][3] = OCEAN;
        THE_CUBE[1][3][0] = OCEAN;
        THE_CUBE[1][3][1] = OCEAN;
        THE_CUBE[1][3][2] = OCEAN;
        THE_CUBE[1][3][3] = OCEAN;
        
        THE_CUBE[2][0][0] = OCEAN;
        THE_CUBE[2][0][1] = OCEAN;
        THE_CUBE[2][0][2] = OCEAN;
        THE_CUBE[2][0][3] = OCEAN;
        THE_CUBE[2][1][0] = OCEAN;
        THE_CUBE[2][1][1] = OCEAN;
        THE_CUBE[2][1][2] = OCEAN;
        THE_CUBE[2][1][3] = OCEAN;
        THE_CUBE[2][2][0] = OCEAN;
        THE_CUBE[2][2][1] = OCEAN;
        THE_CUBE[2][2][2] = OCEAN;
        THE_CUBE[2][2][3] = OCEAN;
        THE_CUBE[2][3][0] = OCEAN;
        THE_CUBE[2][3][1] = OCEAN;
        THE_CUBE[2][3][2] = OCEAN;
        THE_CUBE[2][3][3] = OCEAN;
        
        THE_CUBE[3][0][0] = OCEAN;
        THE_CUBE[3][0][1] = OCEAN;
        THE_CUBE[3][0][2] = OCEAN;
        THE_CUBE[3][0][3] = OCEAN;
        THE_CUBE[3][1][0] = OCEAN;
        THE_CUBE[3][1][1] = OCEAN;
        THE_CUBE[3][1][2] = OCEAN;
        THE_CUBE[3][1][3] = OCEAN;
        THE_CUBE[3][2][0] = OCEAN;
        THE_CUBE[3][2][1] = OCEAN;
        THE_CUBE[3][2][2] = OCEAN;
        THE_CUBE[3][2][3] = OCEAN;
        THE_CUBE[3][3][0] = OCEAN;
        THE_CUBE[3][3][1] = OCEAN;
        THE_CUBE[3][3][2] = OCEAN;
        THE_CUBE[3][3][3] = OCEAN;
        
        THE_CUBE[4][0][0] = LAND;
        THE_CUBE[4][0][1] = LAND;
        THE_CUBE[4][0][2] = LAND;
        THE_CUBE[4][0][3] = LAND;
        THE_CUBE[4][1][0] = LAND;
        THE_CUBE[4][1][1] = LAND;
        THE_CUBE[4][1][2] = LAND;
        THE_CUBE[4][1][3] = LAND;
        THE_CUBE[4][2][0] = LAND;
        THE_CUBE[4][2][1] = LAND;
        THE_CUBE[4][2][2] = LAND;
        THE_CUBE[4][2][3] = LAND;
        THE_CUBE[4][3][0] = LAND;
        THE_CUBE[4][3][1] = LAND;
        THE_CUBE[4][3][2] = LAND;
        THE_CUBE[4][3][3] = LAND;
        
        THE_CUBE[5][0][0] = LAND;
        THE_CUBE[5][0][1] = LAND;
        THE_CUBE[5][0][2] = LAND;
        THE_CUBE[5][0][3] = LAND;
        THE_CUBE[5][1][0] = LAND;
        THE_CUBE[5][1][1] = LAND;
        THE_CUBE[5][1][2] = LAND;
        THE_CUBE[5][1][3] = LAND;
        THE_CUBE[5][2][0] = LAND;
        THE_CUBE[5][2][1] = LAND;
        THE_CUBE[5][2][2] = LAND;
        THE_CUBE[5][2][3] = LAND;
        THE_CUBE[5][3][0] = LAND;
        THE_CUBE[5][3][1] = LAND;
        THE_CUBE[5][3][2] = LAND;
        THE_CUBE[5][3][3] = LAND;
        
        THE_CUBE[6][0][0] = LAND;
        THE_CUBE[6][0][1] = LAND;
        THE_CUBE[6][0][2] = LAND;
        THE_CUBE[6][0][3] = LAND;
        THE_CUBE[6][1][0] = LAND;
        THE_CUBE[6][1][1] = LAND;
        THE_CUBE[6][1][2] = LAND;
        THE_CUBE[6][1][3] = LAND;
        THE_CUBE[6][2][0] = LAND;
        THE_CUBE[6][2][1] = LAND;
        THE_CUBE[6][2][2] = LAND;
        THE_CUBE[6][2][3] = LAND;
        THE_CUBE[6][3][0] = LAND;
        THE_CUBE[6][3][1] = LAND;
        THE_CUBE[6][3][2] = LAND;
        THE_CUBE[6][3][3] = LAND;
        
        THE_CUBE[7][0][0] = LAND;
        THE_CUBE[7][0][1] = LAND;
        THE_CUBE[7][0][2] = LAND;
        THE_CUBE[7][0][3] = LAND;
        THE_CUBE[7][1][0] = LAND;
        THE_CUBE[7][1][1] = LAND;
        THE_CUBE[7][1][2] = LAND;
        THE_CUBE[7][1][3] = LAND;
        THE_CUBE[7][2][0] = LAND;
        THE_CUBE[7][2][1] = LAND;
        THE_CUBE[7][2][2] = LAND;
        THE_CUBE[7][2][3] = LAND;
        THE_CUBE[7][3][0] = LAND;
        THE_CUBE[7][3][1] = LAND;
        THE_CUBE[7][3][2] = LAND;
        THE_CUBE[7][3][3] = LAND;
        
        
        
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
    
    private Biome(Tile[] etiles, double[] eprobs, Tile[] ttiles, double[] tprobs){
        BIOMES.add(this);
        eTileEntries = new ArrayList<>();
        tTileEntries = new ArrayList<>();
        
        double epSum = 0;
        for(int i=0; i<eprobs.length; i++){
            epSum += eprobs[i];
        }        
        for(int i=0; i<eprobs.length; i++){
            eprobs[i] /= epSum;
        }
        
        for(int i=0; i<etiles.length; i++){
            eTileEntries.add(new TileEntry(etiles[i], eprobs[i]));
        }
        
        
        double tpSum = 0;
        for(int i=0; i<tprobs.length; i++){
            tpSum += tprobs[i];
        }        
        for(int i=0; i<tprobs.length; i++){
            tprobs[i] /= tpSum;
        }
        
        for(int i=0; i<ttiles.length; i++){
            tTileEntries.add(new TileEntry(ttiles[i], tprobs[i]));
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
        static IFunc F_TILE_SCALE = IFunc.constant(1);
        
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
