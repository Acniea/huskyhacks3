/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.generation;

import huskyhacks3.world.data.tile.Tile;
import huskyhacks3.util.IFunc;
import huskyhacks3.util.NoiseUtils;
import huskyhacks3.world.data.*;

/**
 *
 * @author Benjamin
 */
public class Generator {
    
    //------------------------------------------------------------
    
    private static final int SEED = (int)(System.nanoTime());
    
    private static final int HASH(int x){
        return x*x*x*x;
    }
    
    private static final int HEIGHT_SEED_X = HASH(SEED);
    private static final int HEIGHT_SEED_Y = HASH(HEIGHT_SEED_X);
    private static final int PRECIP_SEED_X = HASH(HEIGHT_SEED_Y);
    private static final int PRECIP_SEED_Y = HASH(PRECIP_SEED_X);
    private static final int TEMP_SEED_X = HASH(PRECIP_SEED_Y);
    private static final int TEMP_SEED_Y = HASH(TEMP_SEED_X);
    
    //------------------------------------------------------------
    
    public static final IFunc h1 = IFunc.poly(3.5580e-3, 4.5929, -4.4055e1, 1.8019e2, -3.2980e2, 2.78016e2, -8.7943e1);
    
    
    public static final IFunc LERP = new IFunc(x -> 6*Math.pow(x,5)-15*Math.pow(x,4)+10*Math.pow(x,3));
    public static final IFunc HEIGHT_FUNC = LERP;
    public static final IFunc PRECIP_FUNC = LERP;
    public static final IFunc TEMP_FUNC = LERP;
    
    //------------------------------------------------------------
    
    public static final double SCALE = 0.03;
    public static final IFunc F_SCALE = IFunc.constant(SCALE);
    public static final IFunc F_ROUGHNESS = new IFunc(n -> 0.55 /*0.1f*n*/);
    
    public static int getHeight(int x, int y){
        return HEIGHT_FUNC.intOf(scaledNoise(x+HEIGHT_SEED_X, y+HEIGHT_SEED_Y, F_ROUGHNESS, F_SCALE));
    }
    
    public static int getPrecip(int x, int y){
        return PRECIP_FUNC.intOf(scaledNoise(x+PRECIP_SEED_X, y+PRECIP_SEED_Y, F_ROUGHNESS, F_SCALE));
    }
    
    public static int getTemp(int x, int y){
        return TEMP_FUNC.intOf(scaledNoise(x+TEMP_SEED_X, y+TEMP_SEED_Y, F_ROUGHNESS, F_SCALE));
    }
    
    public static Biome getBiome(int height, int precip, int temp){
        return Biome.getBiome(height, precip, temp);
    }
    
    //------------------------------------------------------------
    
    public static final int NUM_OCTAVES = 8;
    
    public static int scaledNoise(int x, int y, IFunc roughness, IFunc scale){
        return (int)(Chunk.MAX_VALUE * NoiseUtils.complex_noise2(x, y, NUM_OCTAVES, roughness, scale));
    }
    
    public static Chunk generate(int x, int y){
        Tile[][][] tiles = new Tile[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE][Chunk.MAX_VALUE];
        Biome[][] biomes = new Biome[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE];
        int[][] heights = new int[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE];
        int[][] precips = new int[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE];
        int[][] temps = new int[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE];
        for(int x0 = 0; x0<Chunk.CHUNK_SIZE; x0++){
            for(int y0 = 0; y0<Chunk.CHUNK_SIZE; y0++){
                
                int height = getHeight(x*Chunk.CHUNK_SIZE+x0,y*Chunk.CHUNK_SIZE+y0);
                int precip = getPrecip(x*Chunk.CHUNK_SIZE+x0,y*Chunk.CHUNK_SIZE+y0);
                int temp = getTemp(x*Chunk.CHUNK_SIZE+x0,y*Chunk.CHUNK_SIZE+y0);
                Biome biome = Biome.getBiome(height, precip, temp);
                
                Tile terrain = biome.getTTile(x*Chunk.CHUNK_SIZE+x0,y*Chunk.CHUNK_SIZE+y0);
                Tile environ = biome.getETile(x*Chunk.CHUNK_SIZE+x0,y*Chunk.CHUNK_SIZE+y0);
                
                tiles[x0][y0] = fillFromHeight(height, terrain);
                placeETile(height, tiles[x0][y0], environ);
                
                biomes[x0][y0] = biome;
                heights[x0][y0] = height;
                precips[x0][y0] = precip;
                temps[x0][y0] = temp;
            }
        }
        return new Chunk(tiles, biomes, heights, precips, temps);
    }
    
    private static Tile[] fillFromHeight(int height, Tile tile){
        Tile[] ts = new Tile[Chunk.MAX_VALUE];
        for(int i=0; i<height; i++){
            ts[i] = tile;
        }
        for(int i=height; i<Chunk.OCEAN_LEVEL; i++){
            ts[i] = Tile.WATER;
        }
        for(int i= (height>Chunk.OCEAN_LEVEL) ? height : Chunk.OCEAN_LEVEL; i<Chunk.MAX_VALUE; i++){
            ts[i] = Tile.EMPTY;
        }
        return ts;
    }
    
    private static void placeETile(int z, Tile[] ts, Tile t){
        if(z<Chunk.MAX_VALUE){
            ts[z] = t;
        }
    }
    
    public static int toHeight(double noise){
        return (int)(Chunk.MAX_VALUE*noise);
    }
    
    
}
