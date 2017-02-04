package ao222vn_assign1.ferry;

import java.util.Iterator;


public class FerryMain {

	public static void main(String[] args) {
		
		
//		Object of cars
		FerryPlatform platform = new FerryPlatform();
		Bus DEF123 = new Bus(15);
		Lorries GHI123 = new Lorries(2);
		Car ABC123 = new Car(4);
		Car ABC124 = new Car(2);
		Bicycle cresent = new Bicycle(1);
		Passenger passenger = new Passenger();
		
		
//		Embarks vehicle
		platform.embark(ABC123);
		platform.embark(ABC124);
		platform.embark(ABC124);
		platform.embark(cresent);
		platform.embark(DEF123);
		platform.embark(GHI123);
		platform.embark(passenger);
		platform.embark(passenger);
		platform.embark(passenger); 
		
		 
//		Print out
		System.out.println("\nHow many people " + platform.countPassengers());
		System.out.println("How much space is taken up " + platform.countVehicleSpace());
		int money = platform.countMoney();
		System.out.println("How much money " + money );
		
		
		Iterator<Vehicle> vec = platform.iterator();
		while(vec.hasNext()) 
			System.out.println(vec.next().sizeOfVehicle);
		
//		Emptying the ferry
		platform.disembark();	
		
		System.out.println("How many people " + platform.countPassengers());
		System.out.println("How much space is taken up " + platform.countVehicleSpace());
		System.out.println("How much money " + money );
	
	}
}

