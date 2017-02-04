package ao222vn_assign2;

import java.util.Iterator;

public class QueueMain {

	public static void main(String[] args) {
		LinkedQueue queue = new LinkedQueue();
		
		//Checks if the queue list is empty
		if(queue.isEmpty())
			System.out.println("The queue is empty");
		
		//Return the size of the queue
		System.out.println("Size of the queue " + queue.size());
		
		//Adds objects last in the queue
		for(int i = 0; i < 10; i++) {queue.enqueue(i);}
		
		
		//Checks if the queue list is empty
		if(queue.isEmpty())
			System.out.println("The queue is empty");
		
		
		System.out.println("The first object in the queue =  " + queue.first());
		System.out.println("The last object in the queue =  " + queue.last());

		
		//Takes out the first object and remove it of the queue
		System.out.println("Take out the first object in queue " + queue.dequeue());
		
		//Iterate over the queue list
		Iterator<Object> obj = queue.iterator();
		System.out.println("Interate over the queue list");
		while(obj.hasNext()) {
			System.out.println(obj.next());
		}
	}
}
