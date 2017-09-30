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
    
    public World(){
        data = new InfiniteGrid();
    }
    
    public Chunk get(int x, int y){
        Chunk c0 = data.get(x,y);
        if(c0==null){
            Chunk c = Generator.generate(x,y);
            data.set(c,x,y);
            return c;
        } else return c0;
    }
}
