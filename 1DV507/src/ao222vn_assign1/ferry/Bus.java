package ao222vn_assign1.ferry;

public class Bus extends Vehicle {
	
	public Bus (int passenger) {
		super(passenger);
		super.sizeOfVehicle = 20;
		super.MAX_PASSENGERS = 20;
		super.PassengerCost = 10;
		super.vehicleCost = 200;
	}
}
