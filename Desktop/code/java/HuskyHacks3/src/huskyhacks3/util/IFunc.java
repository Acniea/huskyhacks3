/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.util;

import huskyhacks3.world.data.Chunk;
import java.util.function.Function;

/**
 *
 * @author Benjamin
 */
public class IFunc {
    public static final IFunc IDEN = new IFunc(x -> x);
    
    public Function<Double, Double> f;
    public int[] f2;
    
    public IFunc(Function<Double, Double> f0){
        f = f0;
        f2 = new int[Chunk.MAX_VALUE];
        for(int i=0; i<Chunk.MAX_VALUE; i++){
            f2[i] = (int)(Chunk.MAX_VALUE*of(1.0*i/Chunk.MAX_VALUE));
        }
    }
    
    public static IFunc constant(double c){
        return new IFunc(x -> c);
    }
    
    public static IFunc poly(double... coeff){
        return new IFunc(x -> {
            double y=0;
            for(int i=0; i<coeff.length; i++){
                y += coeff[i]*Math.pow(x,i);
            }
            return y;
        });
    }
    
    public double of(double x){
        return f.apply(x);
    }
    
    public int intOf(int x){
        return f2[x];
    }
}
