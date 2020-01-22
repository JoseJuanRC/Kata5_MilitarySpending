
package control;

import model.Histogram;
import model.Country;
import java.util.List;
import view.CountryHistogramBuilder;
import view.CountryReader;
import view.HistogramDisplayApplicationFrame;
import view.ObtainYearWindow;


public class Kata5_MilitarySpending {


    public static void main(String[] args) {
      
        int year=ObtainYearWindow.obtainYear();
        System.out.println(""+year);
        String url ="jdbc:sqlite:DB_SQLite\\MilitarySpending.db";
              
        String from = "MilitaryExpenditure";
        
        
        List<Country> countrylist = CountryReader.read(url, year, from);
        Histogram histogram = CountryHistogramBuilder.build(countrylist);
        
        HistogramDisplayApplicationFrame histDis = new HistogramDisplayApplicationFrame(histogram, year);
        histDis.execute();
    }
    
}
