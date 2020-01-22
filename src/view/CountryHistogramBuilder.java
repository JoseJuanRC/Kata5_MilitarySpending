
package view;

import model.Histogram;
import model.Country;
import java.util.List;


public class CountryHistogramBuilder { 
    
    public static Histogram build(List<Country> countrylist){
        Histogram<String> histogram = new Histogram();
        for (Country country : countrylist) {
            histogram.set(country.getName(),country.getMilitarySpending());
        }
        return histogram;
    }
}
