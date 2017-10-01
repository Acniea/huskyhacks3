/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.world.data;

import huskyhacks3.world.generation.Generator;

/**
 *
 * @author Benjamin
 */
public class World {
    InfiniteGrid<Chunk> data;
    int xoff, yoff;
    
    public World(){
        data = new InfiniteGrid();
        xoff = 0;
        yoff = 0;
    }
    
    private Chunk createChunk(int x, int y){
        Chunk c = Generator.generate(x,y);
        data.set(c,x,y);
        return c;
    }
    
    private Chunk requestChunk(int x, int y){
        Chunk c0 = data.get(x,y);
        if(c0==null){
            return createChunk(x, y);
        } else return c0;
    }
    
    public Chunk get(int x, int y){
        return requestChunk(x, y);
    }
}
