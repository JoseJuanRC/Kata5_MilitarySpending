package view;

import javax.swing.JOptionPane;

public class ObtainYearWindow {
    public static int obtainYear() {        
        return (int) JOptionPane.showInputDialog(
                            null,
                            "Select a year",
                            "Year",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            yearRange(1960,2018), 
                            1960);

    }
    
    private static Object[] yearRange(int first,int last) {
        Object[] range = new Object[last-first+1];
        
        for (int i = 0; i < range.length; i++) {
            range[i] = first+i;
            
        }
        return range;
    }
}
