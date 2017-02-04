package ao222vn_assign1.intCollection;

import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
	
//		ArrayIntList part////////////////////////////////////////////////////
		ArrayIntList intArray = new ArrayIntList();
		
		intArray.add(1);
		intArray.add(2);
		intArray.add(2);
		intArray.addAt(3, 2);
		intArray.remove(0);
		
		System.out.println("Get index 1: " + intArray.get(1));
		
		if(intArray.isEmpty())
			System.out.println("Arrayen är tom");
		
		System.out.println(intArray.toString());
//		////////////////////////////////////////////////////////////////////
		
//		ArrayIntStack part////////////////////////////////////////////////////

		ArrayIntStack stackArray = new ArrayIntStack();
		stackArray.push(1);
		stackArray.push(2);
		stackArray.push(3);
		
		Iterator<Integer> it = stackArray.iterator();
	
//		iterate though array
		while(it.hasNext()) 
			System.out.print( it.next() + " ");
		
		
		System.out.println("\nSize of iterator " + stackArray.size());
		System.out.println("Peek " + stackArray.peek());
		System.out.println("Pop " + stackArray.pop());
		System.out.println("Size of iterator " + stackArray.size());
		System.out.print("Print out iterator " + stackArray);
	
		
//		////////////////////////////////////////////////////////////////////

		

		
		
		
		

		
	}
}
