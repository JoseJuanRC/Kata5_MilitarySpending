package kata5_militaryspending;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private String url;
    private Connection connection = null;
    
    public DataBase(String url) {
        this.url = url;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.url);
            System.out.println("Base de Datos abierta...");
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::open (SQLException " + ex.getMessage());
        }
    }

    void close() {
        if (this.connection != null){
            try {
                this.connection.close();
                System.out.println("Base de Datos cerrada...");
            } catch (SQLException ex) {
                System.out.println("ERROR DataBase::close (SQLException " + ex.getMessage());
            }
        }
    }

    void select_COUNTRIES() {
        String SQL = "SELECT * FROM MilitaryExpenditure";        
        try {
            Statement statement = this.connection.createStatement();
            ResultSet res = statement.executeQuery(SQL);
            
            System.out.println("Name  \t Code \t  2000");
            System.out.println("--  \t ------ \t --------- \t ------------");
            while(res.next()){
                System.out.println(res.getString("Name") + " \t " + 
                        res.getString("Code") + " \t\t " + 
                        res.getInt("2000") + " \t\t ");
            }
        } catch (SQLException ex) {
            System.out.println("ERROR DataBase::select_PERSONAS (SQLException " + ex.getMessage());
        }
        
    }    
    
}
