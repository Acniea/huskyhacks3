/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.main;

import huskyhacks3.world.data.*;

/**
 *
 * @author Benjamin
 */
public class Main {
    public static void main(String[] args) {
        World w = new World();
        print(w.get(0,0));
    }
    
    public static void print(Chunk c){
        for(int x=0; x<Chunk.CHUNK_SIZE; x++){
            for(int y=0; y<Chunk.CHUNK_SIZE; y++){
                //Chunk.
            }
        }
    }
}
