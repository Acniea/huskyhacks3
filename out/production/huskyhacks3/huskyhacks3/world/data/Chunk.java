/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.data;

import huskyhacks3.world.data.tile.Tile;

/**
 *
 * @author Benjamin
 */
public class Chunk {
    public static final int CHUNK_SIZE = 32;
    public static final int MAX_VALUE = 512;
    public static final int OCEAN_LEVEL = 256;
    
    
    private final TileColumn[][] tiles;
    
    public Chunk(Tile[][][] ts, Biome[][] bs, int[][] heights, int[][] precips, int[][] temp){
        tiles = new TileColumn[CHUNK_SIZE][CHUNK_SIZE];
        for(int x=0; x<CHUNK_SIZE; x++){
            for(int y=0; y<CHUNK_SIZE; y++){
                tiles[x][y] = new TileColumn(ts[x][y], bs[x][y], heights[x][y], precips[x][y], temp[x][y]);
            }
        }
    }
    
    public Tile get(int x, int y, int z){
        return tiles[x][y].get(z);
    }
    
    public Tile getSurface(int x, int y){
        return tiles[x][y].getSurface();
    }
    public Tile getEnvironment(int x, int y){
        return tiles[x][y].getEnvironment();
    }
    
    public int getHeight(int x, int y){
        return tiles[x][y].height;
    }
    
    public int getPrecip(int x, int y){
        return tiles[x][y].height;
    }
    
    public int getTemp(int x, int y){
        return tiles[x][y].height;
    }
    
    private static class TileColumn {
        Tile[] tiles;
        Biome biome;
        int height;
        int precip;
        int temp;
        
        public TileColumn(Tile[] t, Biome b, int h, int p, int te){
            tiles = t;
            biome = b;
            height = h;
            precip = p;
            temp = te;
        }
        
        Tile get(int z){
            return tiles[z];
        }
        
        Tile getSurface(){
            return tiles[height-1];
        }
        
        Tile getEnvironment(){
            if(height > MAX_VALUE) return Tile.EMPTY;
            return tiles[height];
        }
        
        boolean lessThanOcean(){
            return height<OCEAN_LEVEL;
        }
    }

    public boolean adjacentLoaded() {
        //todo implement
        return false;
    }
    
}
