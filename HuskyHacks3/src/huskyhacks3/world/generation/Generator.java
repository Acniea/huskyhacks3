/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.generation;

import huskyhacks3.util.IFunc;
import huskyhacks3.util.NoiseUtils;
import huskyhacks3.world.data.*;

/**
 *
 * @author Benjamin
 */
public class Generator {
    private static final int SEED = (int)(System.nanoTime());
    
    public static Chunk generate(int x, int y){
        Tile[][][] tiles = new Tile[Chunk.CHUNK_SIZE][Chunk.CHUNK_SIZE][Chunk.MAX_HEIGHT];
        for(int x0 = x; x0<x+Chunk.CHUNK_SIZE; x0++){
            for(int y0 = y; y0<y+Chunk.CHUNK_SIZE; y0++){
                
                int height = toHeight(NoiseUtils.complex_noise2(x0+SEED, y0+SEED, 8, new IFunc(n -> 0.55f + 0.4f*n), IFunc.constant(0.03)));
                            //toHeight(NoiseUtils.complex_noise2(x0+SEED, y0+SEED, 8, IFunc.constant(0.6f), IFunc.constant(0.03)));
                
                tiles[x0][y0] = fillFromHeight(height);
            }
        }
        return new Chunk(tiles);
    }
    
    private static Tile[] fillFromHeight(int height){
        Tile[] ts = new Tile[Chunk.MAX_HEIGHT];
        for(int i=0; i<height; i++){
            ts[i] = Tile.SOLID;
        }
        for(int i=height; i<Chunk.MAX_HEIGHT; i++){
            ts[i] = Tile.EMPTY;
        }
        return ts;
    }
    
    
    public static int toHeight(double noise){
        noise = lerp.of(noise);
        return (int)(Chunk.MAX_HEIGHT*noise);
    }
    
    
    public static IFunc lerp = new IFunc(x -> 6*Math.pow(x,5)-15*Math.pow(x,4)+10*Math.pow(x,3));
}
