
package kata5_militaryspending;


public class Kata5_MilitarySpending {


    public static void main(String[] args) {
        String url ="jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\Kata5_MilitarySpending\\DB_SQLite\\MilitarySpending.db";
        DataBase db = new DataBase(url);        
        db.open();
        
                

        db.close();
    }
    
}
