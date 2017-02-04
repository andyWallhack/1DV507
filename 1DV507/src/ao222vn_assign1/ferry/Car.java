package ao222vn_assign1.ferry;

public class Car  extends Vehicle{
	
	public Car (int passenger) {
		
		super(passenger);
		super.sizeOfVehicle = 5;
		super.MAX_PASSENGERS = 4;
		super.PassengerCost = 15;
		super.vehicleCost = 100;
	}
}
