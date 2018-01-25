
package huskyhacks3.world.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GriddedList<E extends Object> {
    private List<E> data;
    private List<Integer> coords;
    
    public GriddedList(){
        data = new ArrayList<>();
        coords = new ArrayList<>();
    }
    
    public E get(int coord){
        int index = search(coord);
        if(index!=-1) return data.get(index);
        return null;
    }
    
    public boolean set(E newData, int coord){
        if(size()==0){
            data.add(newData);
            coords.add(coord);
            return false;
        }
        
        int l = 0;
        int h = coords.size() - 1;
        boolean foundAnEntry=false;
        while (l <= h) {
            int m = (h + l) / 2;
            if(coord < coords.get(m)){
                h = m - 1;
            } else if(coord > coords.get(m)){
                l = m + 1;
            } else if(coord==coords.get(m)){
                foundAnEntry=true;
                break;
            }
        }
        
        if(foundAnEntry){
            coords.set((h+l)/2, coord);
            data.set((h+l)/2, newData);
        } else {
            coords.add(l, coord);
            data.add(l, newData);
        }
        
        return foundAnEntry; 
    }
    
    private int search(int coord){
        int l = 0;
        int h = coords.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if(coord < coords.get(m)){
                h = m - 1;
            } else if (coord > coords.get(m)){
                l = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }
    
    public E remove(int coord){
        int index = search(coord);
        if(index!=-1){
            coords.remove(index);
            return data.remove(index);
        }
        
        return null;
    }
    
    private int min(){
        return coords.get(0);
    }
    
    private int max(){
        return coords.get(coords.size()-1);
    }
    
    public int size(){
        return coords.size();
    }
    
    private int range(){
        return max()-min();
    }
    
    public List<E> data(){
        return data;
    }
    
    public List<Integer> coords(){
        return coords;
    }
}
