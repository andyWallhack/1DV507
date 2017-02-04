package ao222vn_assign1;

public class SumMain {

	public static void main(String[] args) {
		
		System.out.print(addSum(1,10));

	}
	
	public static int addSum(int a, int b) {
//		sum of the integers from 1 to N/2 added with the sum of the integers from N/2+1 to N	

		if(b == a) return 1;

		return  addSum(a,  ((b-a)/2+a) - 1 ) + (b-a)/2+a;
		
	}
}


