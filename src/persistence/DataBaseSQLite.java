package persistence;

import model.Country;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class DataBaseSQLite implements DataBase {

    private String url;
    private Connection connection = null;
    
    public DataBaseSQLite(String url) {
        this.url = url;
    }


    public void open() {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de Datos abierta...");
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::open (SQLException " + ex.getMessage());
        }
    }

    public void close() {
        if (this.connection != null){
            try {
                this.connection.close();
                System.out.println("Base de Datos cerrada...");
            } catch (SQLException ex) {
                System.out.println("ERROR DataBase::close (SQLException " + ex.getMessage());
            }
        }
    }

    public Iterator<Country> select(String from, int year) {
        String SQL = "SELECT * FROM " + from +" WHERE Type = \"Country\"";        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery(SQL);
            return queryResultIterator(res,year);            
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::select (SQLException " + ex.getMessage());
        }
        return null; 
    }

    private Iterator<Country> queryResultIterator(ResultSet res, int year) throws SQLException{

        return new Iterator<Country>() {
            
            Boolean hasNext;
            Country current;
            {
                hasNext = res.next();
                hasNext = res.next();
                while(hasNext && (res.getString(year+"").length() == 0)){
                    hasNext = res.next();
                }
                
                if (hasNext)
                    current = new Country(res.getString("Name"), 
                                            year, 
                                            (long) Double.parseDouble(res.getString(year+"")) );
                else 
                    current = null;
                
            }
            @Override
            public boolean hasNext() {
                return hasNext;
            }

            @Override
            public Country next() {
                Country result = current;
                try {
                    hasNext = res.next();
                    while(hasNext && (res.getString(year+"").length() == 0)){
                        hasNext = res.next();
                    }
                    
                    if (hasNext)
                        current = new Country(res.getString("Name"), 
                                                year, 
                                                (long) Double.parseDouble(res.getString(year+"")) );
                    else 
                        current = null;
                } catch (SQLException ex) {
                    System.out.println("ERROR DataBase::queryResultIterator (SQLException " + ex.getMessage());
                }
                return result;
                
            }
        
        };
        
    }


    
}
