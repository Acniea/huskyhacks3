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
        printChunk(w.get(0,0));
    }
    
    public static void printChunk(Chunk c){
        for(int x=0; x<Chunk.CHUNK_SIZE; x++){
            for(int y=0; y<Chunk.CHUNK_SIZE; y++){
                System.out.print((toStr(c.getHeight(x, y))));
            }
            System.out.println();
        }
    }
    
    public static String toStr(int height){
        int num = 5;
        if(height <= Chunk.MAX_HEIGHT/num){
            return "█";
        } else if(height <= 2*Chunk.MAX_HEIGHT/num){
            return "■";
        } else if(height <= 3*Chunk.MAX_HEIGHT/num){
            return "▩";
        } else if(height <= 4*Chunk.MAX_HEIGHT/num){
            return "◼";
        } else if(height <= 5*Chunk.MAX_HEIGHT/num){
            return "◾";
        }
        if(height <= Chunk.MAX_HEIGHT/4){
            return " ";
        } else if(height <= 2*Chunk.MAX_HEIGHT/4){
            return "◾";
        } else if(height <= 3*Chunk.MAX_HEIGHT/4){
            return "◼";
        } else if(height <= 4*Chunk.MAX_HEIGHT/4){
            return "■⬛■";
        }
        
        return "!";
    }
}
