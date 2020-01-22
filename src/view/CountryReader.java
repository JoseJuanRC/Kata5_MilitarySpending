package view;

import persistence.DataBaseSQLite;
import persistence.DataBase;
import model.Country;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CountryReader {

    List<Country> list = new ArrayList<>();
    
    public static List<Country> read(String fileName, int year, String from) {
        DataBase db = new DataBaseSQLite(fileName);   
        db.open();

        List<Country> countrylist = listMaker(db.select(from,year));


        db.close();
        return countrylist;
    }

    private static List<Country> listMaker(Iterator i){
        List<Country> countrylist = new ArrayList<Country>();
        while (i.hasNext()){
            Country e = (Country) i.next();
            countrylist.add(e);
        }
        return countrylist;
    }
    
}
