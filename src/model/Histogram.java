
package model;

import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedSet;
import java.util.TreeMap;


public class Histogram<T> {
    private final NavigableMap<T, Long> map = new TreeMap<T, Long>();
    
    public Long get (T key){
        return map.get(key);
    }
    
    public void set(T key, Long value){
        map.put(key, value);
    }
    
    public SortedSet<T> keySet() {        
        return map.navigableKeySet();
    }
    
    public Histogram<T> getTop10Hist() {
        Map<T, Long> mapTop10 = this.sortByValues();
        int tipLim = 0;
        Histogram<T> histogram = new Histogram<T>();
        System.out.println("Hola");
        for (T t : mapTop10.keySet()) {
            if (tipLim > 9) break;
            histogram.set(t,mapTop10.get(t));
            tipLim+=1;
        }
        return histogram;
    }
    
    
    
    private Map<T,Long> sortByValues(){
        Map<T, Long> sortedMap = new TreeMap<T, Long>(new Comparator<T>() {
            @Override
            public int compare(T t1, T t2) {
                return map.get(t2).compareTo(map.get(t1));
            }            
        });
        sortedMap.putAll(map);
        return sortedMap;
    }
    
    
}
