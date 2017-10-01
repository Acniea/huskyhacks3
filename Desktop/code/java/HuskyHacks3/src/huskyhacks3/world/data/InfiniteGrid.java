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
public class InfiniteGrid<T> {
    GriddedList<GriddedList<T>> ds;
    
    public InfiniteGrid(){
        ds = new GriddedList();
    }
    
    public void set(T t, int x, int y){
        GriddedList<T> g = ds.get(x);
        if(g==null){
            g = new GriddedList();
            ds.set(g, x);
        }
        g.set(t, y);
    }
    
    public T get(int x, int y){
        GriddedList<T> g = ds.get(x);
        if(g==null){
            return null;
        }
        return g.get(y);
    }
}
