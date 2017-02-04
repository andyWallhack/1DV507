package ao222vn_assign1.ferry;

public  class Vehicle {
	
	private int passenger;
	protected Object  typOfVehicle;
	protected int sizeOfVehicle;
	protected int PassengerCost;
	protected int MAX_PASSENGERS;
	protected int vehicleCost;
	protected static int IDNR = 0;
	protected int ID;
	
//	Constructor
	public Vehicle (int passenger) {
		this.passenger = passenger;
		this.ID = IDNR++;
	}
	
/**
 * Set passenger cost
 */
	public  void setPassengerCost() {
		if(!tooManyPassenger())
			totalCost();
		else 
			System.out.println("Two many passangers");
	}
			
/**
 * Calculate total cost of vehicle 
 * @return total cost of the vehicle
 */
	public  int totalCost()  {
		return this.passenger * this.PassengerCost +  this.vehicleCost;
	}
	
	
/**
 * Check how many passenger in vehicle 
 * @return true if there is enough
 */
	private  boolean tooManyPassenger() {
		boolean tooMany = false;
		if((getPassenger() + this.passenger) > this.MAX_PASSENGERS)
			tooMany = true;
		
		return tooMany;
	}

/**
 * checks size of vehicle 
 * @return size of vehicle
 */
	public int sizeOfVehicle() {
		return this.sizeOfVehicle;
	}
	
/**
 * 
 * @return how many passenger
 */
	public int getPassenger() {
		
		return this.passenger;
	}
}
