package ao222vn_assign1.ferry;

import java.util.Iterator;

public class FerryPlatform implements Ferry{
	
	private int vSize;
	private int vLength = 8;
	private int pSize;
	private int pLength = 8;
	private Vehicle[] vehicles = new Vehicle[this.vLength];
	private Passenger[] pers = new Passenger[this.pLength];
	private int spaceForVehicles;
	private int spaceForPassengers;
	private int howManyPeople;
	
//	Constructor
	public FerryPlatform() {
		this.vSize = 0;
		this.howManyPeople = 0;
		this.spaceForVehicles = 200;
		this.spaceForPassengers = 200;
	}

	
/**
 * Counts passenger on the ferry 
 * @return how many people on ferry
 */
	@Override
	public int countPassengers() {
		int totalPassanger = 0;
		for(int i = 0; i < this.pSize; i++)
			totalPassanger += vehicles[i].getPassenger();
		
		return totalPassanger + this.howManyPeople;
	}
	
/**
 * Check how much vehicle space is taken 
 * @return taken vehicle space
 */
	@Override
	public int countVehicleSpace() {
		int vehicleSpace = 0;
		for(int i = 0; i < this.vSize; i++)
			vehicleSpace += vehicles[i].sizeOfVehicle;
			
		return vehicleSpace;
	}
	
/**
 * Counts money
 * @return money
 */
	@Override
	public int countMoney() {
		int totalMoney = 0;
		for(int i = 0; i < this.vSize; i++ )
			totalMoney += vehicles[i].totalCost();
		
		for(int i = 0; i < this.howManyPeople; i++)
			totalMoney += pers[i].getCost();
		
		return totalMoney;
		
	}
	
/**
 * Embark a vehicle on the ferry
 */
	@Override
	public void embark(Vehicle v) {
		for(int i = 0; i < this.vSize; i++) {
			if(this.vehicles[i].equals(v)) {
				System.err.println("Can´t embark vehicle two times!");
				return;
			}
		}
	
//		Controls if there is space for in on ferry, if so controls in the vehicle array has space for in. If not allocates
		if(hasSpaceFor(v)) {
			if(this.vSize == this.vLength) {
				this.vLength *= 2;
				Vehicle[] temp = new Vehicle[this.vSize];
				this.vehicles = new Vehicle[this.vLength];
				this.vehicles = temp;
			}
			this.vehicles[this.vSize++] = v;
		}
		else
				System.out.println("Out of space");

	}
	
/**
 * Empty the ferry 
 * null set arrays vehicles and pers
 */
	@Override
	public void disembark() {
	
		for(int i = this.vSize -1; i >=  0; i--)
			this.vehicles[i] = null;
		
		for(int i = this.pSize -1; i >= 0; i--)
			this.pers[i] = null;
		
		this.vSize = 0;
		this.pSize = 0;	
	}
	
/**
 * Check if space on ferry
 * @ return true is space left
 */
	@Override
	public boolean hasSpaceFor(Vehicle v) {
		
		boolean hasSpaceForVehicle = false;
		if((v.sizeOfVehicle + countVehicleSpace()) < this.spaceForVehicles)
			 hasSpaceForVehicle = true;
		
		return hasSpaceForVehicle;
	}

/**
 * Iterator
 */
	@Override
	public Iterator<Vehicle> iterator() {
		// TODO Auto-generated method stub
		return new VehicleIterator() ;
	}

/**
 * Embark passenger if there is enough room
 */
	@Override
	public void embark(Passenger p) {
		
		if(hasRoomFor(p)) {
			if(this.pSize == this.pLength) {
				this.pLength *= 2;
				Passenger[] temp = new Passenger[this.pSize];
				this.pers = new Passenger[this.pLength];
				this.pers = temp;
			}
			this.pers[this.pSize++] = p;
		}
		else
				System.out.println("Out of space");
	}

/**
 * Checks if the is space for passenger
 * @return true if space
 */
	@Override
	public boolean hasRoomFor(Passenger p) {
		boolean hasSpaceForPeople = false;
		int peopleOnBoard = countPassengers();
		if((p.getPassenger() + peopleOnBoard) <= this.spaceForPassengers)
			hasSpaceForPeople = true;
		
		return hasSpaceForPeople;
	}
	
	
	/*Private inner class used by iterator()*/
	class VehicleIterator implements Iterator<Vehicle> {
		private int count = 0;
		public Vehicle next() {return vehicles[count++];}
		
		public boolean hasNext() {return count < vSize;}
		
		public void remove() {
			throw new RuntimeException("remove() is not implemented");
		}
	}
}
