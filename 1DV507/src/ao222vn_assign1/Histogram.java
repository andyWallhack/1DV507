package ao222vn_assign1;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.LegendPosition;

public class Histogram {

	public static void main(String[] args) {
		
		
//		Kontrollerar sifferhistorik.
		int[] antalSiffror = new int[11];
		antalSiffror = check(fileToArray(args[0]));
		
//		Skriver ut.
		print(antalSiffror, args[0]);
		
		
		new SwingWrapper(getChart(antalSiffror)).displayChart();
		new SwingWrapper<PieChart>(getChart1(antalSiffror)).displayChart();

	}
	
/**
 * Läser tal från fil och lägger in i en array	
 * @param inputFileName filens plats i datorn.
 * @return en array vid namn antal med alla tal i
 */
	public static ArrayList<Integer> fileToArray(String inputFileName) {
		
		ArrayList<Integer> antal = new ArrayList<>();
		Scanner fileName = null;
		File inputFile;
		
//		Läser in fil 
		try {
			inputFile = new File(inputFileName);
			fileName = new Scanner(inputFile);
		}
		catch (FileNotFoundException s) {
			System.err.println("Filen finns inte\n");
			s.getMessage();
			System.exit(0);
		}
		
//		Gör igenom filen.
		while(fileName.hasNext()) {
			antal.add(fileName.nextInt());
			
		}
		
		fileName.close();
		return antal;
	}
	
/**
 * Kontrollerar mellan vilken intervall siffornas storlek är
 * @param number inlästa arrayen
 * @return array med intervall av siffror 
 */
	public static int[] check(ArrayList<Integer> number) {
		
		int[] antal = new int[11];
	
		for(int i = 0; i < number.size(); i++) {
			int element = number.get(i);
			if(element > 0 && element <= 10) {
				antal[0]++;
			}
			else if(element > 10 && element <= 20) {
				antal[1]++;
			}
			else if(element > 20 && element <= 30) {
				antal[2]++;
			}
			else if(element > 30 && element <= 40) {
				antal[3]++;
			}
			else if(element > 40 && element <= 50) {
				antal[4]++;
			}
			else if(element > 50 && element <= 60) {
				antal[5]++;
			}
			else if(element > 60 && element <= 70) {
				antal[6]++;
			}
			else if(element > 70 && element <= 80) {
				antal[7]++;
			}
			else if(element > 80 && element <= 90) {
				antal[8]++;
			}
			else if(element > 90 && element <= 100) {
				antal[9]++;
			}
			else {
				antal[10]++;
			}
		}
		
		return antal;
	}

	public static void print(int[] number, String fileName) {
		
		int sum = 0;
		
		for(int i : number)
			sum += i;
		
		System.out.printf("L�ser heltal fr�n filen: %s\n", fileName);
		System.out.printf("Antal i intervallet [1, 100]: %d\n",	(sum - number[number.length - 1]));
		System.out.printf("�vriga %d\n", number[number.length - 1]);
		System.out.printf("Histogram\n");
		
//		Skriver ut historik
		for(int i = 0; i < number.length - 1; i++) {
			System.out.printf("%-2d - %3d%5s ", i*10 + 1, (i + 1)*10, "|");
			
			for(int j = 0; j < number[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints out a chart with the 11 different intervals of numbers history
	 * @param arrayList number history 
	 * @return printed chart
	 */
	public static CategoryChart getChart(int [] arrayList) {
		
	    // Create Chart
	    CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title("Score Histogram").xAxisTitle("Score").yAxisTitle("Number").build();
	 
	    // Customize Chart
	    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
	    chart.getStyler().setHasAnnotations(true);

//	    Text under the bars
	    int [] xArray = {1,2,3,4,5,6,7,8,9,10,11};
	 
	    chart.addSeries("Histogram ", xArray, arrayList);

	    return chart;
	  }

	
	public static PieChart getChart1(int [] arrayList) {		 
	    // Create Chart
	    PieChart chart = new PieChartBuilder().width(800).height(600).title("Pie").build();
	 
	    // Customize Chart
	   
	    Color[] sliceColors = new Color[] { new Color(224, 68, 14), new Color(230, 105, 62), new Color(236, 143, 110)};
	    chart.getStyler().setSeriesColors(sliceColors);
	 
	 
	  
	    chart.addSeries("1 - 10 ", arrayList[0]);
	    chart.addSeries("11 - 20 ", arrayList[1]);
	    chart.addSeries("21 -30 ", arrayList[2]);
	    chart.addSeries("31 - 40", arrayList[3]);
	    chart.addSeries("41 - 50", arrayList[4]);
	    chart.addSeries("51 - 60", arrayList[5]);
	    chart.addSeries("61 - 70", arrayList[6]);
	    chart.addSeries("71 - 80", arrayList[7]);
	    chart.addSeries("81 - 90", arrayList[8]);
	    chart.addSeries("91 - 100", arrayList[9]);
	    chart.addSeries("Övrigt" + "", arrayList[10]);
	  
	 
	    return chart;
	  }
}

	
	
