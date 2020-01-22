package persistence;

import java.util.Iterator;

public interface DataBase {

    public void open();

    public Iterator select(String from, int year);
      
    public void close();
    
}
