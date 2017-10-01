
package huskyhacks3.world.data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GriddedList<T> {
    class Entry<T> {
        T t;
        int index;
        
        public Entry(T t0, int i0){
            t = t0;
            index = i0;
        }
    }
    
    LinkedList<Entry<T>> list;
    
    public GriddedList(){
        list = new LinkedList<>();
    }
    
    public int size(){
        return list.size();
    }
    
    public int min(){
        return list.getFirst().index;
    }
    
    public int max(){
        return list.getLast().index;
    }
    
    public void set(int index, T t){
        Entry<T> e = new Entry(t, index);
        if(list.isEmpty()){
            list.add(e);
        } else if(index<list.getFirst().index){
            list.addFirst(e);
        } else if(index > list.getLast().index){
            list.addLast(e);
        } else {
            for(int i=0; i<size(); i++){
                if(index>list.get(i).index){
                    list.add(i, e);
                }
            }
        }
    }
    
    public T get(int index){
        for(Entry<T> e : list){
            if(e.index == index){
                return e.t;
            }
        }
        return null;
    }
    
}
