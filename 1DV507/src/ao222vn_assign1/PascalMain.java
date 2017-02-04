package ao222vn_assign1;

public class PascalMain {

	public static void main(String[] args) {
		
//		Printout
		int [] array = pascalRow(5);
		for(int i = 0; i< array.length; i++)
			System.out.print(array[i]+ " ");
	}
	
	/**
	 * Writes out last row of Pascal triangle
	 * @param n row size
	 * @return array with the last row sequence
	 */
	public static int [] pascalRow(int n) {
		
		int [] pascal = new int[n+1];
		
//		Base-case
		if(n == 0) {
			pascal[0] = 1;
			return pascal;
		}
		
		pascal[0] = pascal[n] = 1;
			
		int [] temp = new int [n+1];
		temp = pascalRow(n - 1);
	
//		Adds number in Pascal array from previous Pascal array (like a nested for-loop)
		for(int i = 1; i < temp.length ; i++) {
			pascal[i] = temp[i-1] + temp[i];
		}
		return pascal;
	}
}
