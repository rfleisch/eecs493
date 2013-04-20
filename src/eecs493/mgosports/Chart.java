package eecs493.mgosports;

import java.awt.Color;
import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class Chart {

	public static JFreeChart createChart(CategoryDataset dataset)
	{
		JFreeChart chart =  ChartFactory.createAreaChart(
				"", //chart Title 
				"Last 30 Days", // x axis label 
				"Number of Tweets", // y axis label
				dataset, 
				PlotOrientation.VERTICAL, 
				false, //include legend
				false, //tooltips
				false);
		chart.setBackgroundPaint(Color.white);
		
		CategoryPlot plot = chart.getCategoryPlot();
		plot.setForegroundAlpha(0.5f);
		
		plot.setBackgroundPaint(Color.lightGray);
		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.white);
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.white);
		plot.getDomainAxis().setTickLabelsVisible(false);
		plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		//range.setVisible(false);
		return chart;
	}
	
	public static ChartPanel createChartPanel(double [][] data)
	{
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				"", "", data
		);
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		chartPanel.setEnforceFileExtensions(false);
		return chartPanel;
	}
}
