
package view;

import model.Histogram;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleEdge;

public class HistogramDisplayApplicationFrame extends ApplicationFrame implements HistogramDisplay  {

    private Histogram<String> histogram;
    private int year;
    public HistogramDisplayApplicationFrame(Histogram<String> histogram, int year) {
        super("MilitarySpending "+year);
        this.year = year;
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    
    
    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Top 10 Countries by Military Spending "+year, //Titulo
                                                        "Countries", //Eje x
                                                        "Money", //Eje y
                                                        dataSet,
                                                        PlotOrientation.HORIZONTAL,
                                                        false, // Leyenda
                                                        false,
                                                        rootPaneCheckingEnabled);
        
        
        //"--------------------------------------"
        CategoryPlot plot = chart.getCategoryPlot();

        CategoryAxis axis = plot.getDomainAxis();

        CategoryPlot p = chart.getCategoryPlot(); 
        ValueAxis axis2 = p.getRangeAxis();

        Font font = new Font("Dialog", Font.PLAIN, 10);// Eje y
        axis.setTickLabelFont(font);
        Font font2 = new Font("Dialog", Font.PLAIN, 15);//Eje x
        axis2.setTickLabelFont(font2);

        LegendTitle legend = new LegendTitle(plot.getRenderer());

        Font font3 = new Font("Dialog", Font.PLAIN, 7); 
        legend.setItemFont(font3); 
        legend.setPosition(RectangleEdge.BOTTOM); 
        chart.addLegend(legend); 

        return chart;
    }
    
    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        this.histogram = histogram.getTop10Hist();
        Iterator<String> i = this.histogram.keySet().iterator();
        while(i.hasNext()) {
            String key = (String) i.next();
            dataSet.addValue(this.histogram.get(key),key + " = " + this.histogram.get(key),key);
            System.out.println(key + "----"+this.histogram.get(key));
        }
                
        return dataSet;
    }

    @Override
    public void execute() {
        this.setVisible(true);
    }
    
    
}
