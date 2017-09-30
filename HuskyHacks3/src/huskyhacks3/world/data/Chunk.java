/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.data;

/**
 *
 * @author Benjamin
 */
public class Chunk {
    public static int CHUNK_SIZE = 32;
    public static int MAX_HEIGHT = 512;
    
    public Chunk(Tile[][][] ts){
        tiles = ts;
        indices_of_heights = new int[CHUNK_SIZE][CHUNK_SIZE];
        for(int x=0; x<CHUNK_SIZE; x++){
            for(int y=0; y<CHUNK_SIZE; y++){
                int z_max = 0;
                for(int z=MAX_HEIGHT-1; z>=0; z++){
                    if(tiles[x][y][z] != Tile.EMPTY){
                        z_max = z;
                        break;
                    }
                }
                indices_of_heights[x][y] = z_max;
            }
        }
    }
    
    private Tile[][][] tiles;
    private int[][] indices_of_heights;
    
    public Tile get(int x, int y, int z){
        return tiles[x][y][z];
    }
    
    public Tile getAtHeight(int x, int y){
        return tiles[x][y][indices_of_heights[x][y]];
    }
    
    
}
