package ao222vn_assign1;


import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;



public class SinMain {

	public static void main(String[] args) {
	

		int maxStep = 40;
		
		
		double[] xData = new double[maxStep];
	    double[] yData = new double[maxStep];
		
	   for(int i = 0; i < maxStep; i ++)
		   xData[i] = 2*Math.PI/maxStep * i;

	   yData = valueOf(xData);
	   
	   for(int i = 0; i < yData.length; i++)
		   System.out.println(yData[i]);

	 
	    
			    
	    // Display scatter plot
	    XYChart chart = QuickChart.getChart("Sin chart", "X", "Y", "y(x)", xData, yData);

	    new SwingWrapper(chart).displayChart();

	}
	/**
	 * Calculating y value
	 * @param x value
	 * @return array of y values
	 */
	private static double [] valueOf(double [] x) {
		
		double temp[] = new double [x.length];
		for(int i = 0; i < x.length; i++)
			temp[i]= (1 + x[i]/Math.PI)*Math.cos(x[i])*Math.cos(40*x[i]);
		
		
		return temp;
		
	}
}
