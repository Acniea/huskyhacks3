/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huskyhacks3.util;

import java.util.function.Function;

/**
 *
 * @author Benjamin
 */
public class IFunc {
    public static final IFunc IDEN = new IFunc(x -> x);
    
    public Function<Double, Double> f;
    
    public IFunc(Function<Double, Double> f0){
        f = f0;
    }
    
    public double of(double x){
        return f.apply(x);
    }
}
