/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.main;

import huskyhacks3.world.data.*;
import huskyhacks3.world.data.tile.Tile;

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
                System.out.print((toStr(c.getSurface(x, y))));
            }
            System.out.println();
        }
    }
    
    public static String toStr(Tile t){
        int num = 5;
        if(t == Tile.DIRT){
            return "▓";
        }
        if(t == Tile.WATER){
            return "≋"; //🌊
        }
        if(t == Tile.GRASS){
            return "▒";
        }
        if(t == Tile.SAND){
            return "░";
        }
        if(t == Tile.STONE){
            return "█";
        }
        
        
        if(t == Tile.TREE_NORMAL){
            return "🌳"; //🌳
        }
        if(t == Tile.TREE_PINE){
            return "🌲"; //🌲
        }
        if(t == Tile.TREE_PALM){
            return "🌴"; //🌴
        }
        if(t == Tile.BUSH){
            return "⌬";
        }
        if(t == Tile.BUSH){
            return "⏺";
        }
        
        
        return "!";
    }
    public static String toStr(int height){
        int num = 5;
        if(height <= Chunk.MAX_VALUE/num){
            return "█";
        } else if(height <= 2*Chunk.MAX_VALUE/num){
            return "▓";
        } else if(height <= 3*Chunk.MAX_VALUE/num){
            return "▒";
        } else if(height <= 4*Chunk.MAX_VALUE/num){
            return "░";
        } else if(height <= 5*Chunk.MAX_VALUE/num){
            return " ";
        }
        return "!";
    }
}
